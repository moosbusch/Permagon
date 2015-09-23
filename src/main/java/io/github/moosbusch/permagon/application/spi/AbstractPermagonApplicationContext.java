/*
 * Copyright 2015 Gunnar Kappei.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.moosbusch.permagon.application.spi;

import io.github.moosbusch.permagon.application.PermagonApplication;
import io.github.moosbusch.permagon.application.PermagonApplicationContext;
import io.github.moosbusch.permagon.configuration.JavaFXBeanConfiguration;
import io.github.moosbusch.permagon.util.FxmlFieldInjector;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.FrameworkEvent;
import org.osgi.framework.FrameworkListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.launch.Framework;
import org.osgi.util.tracker.BundleTracker;
import org.osgi.util.tracker.ServiceTracker;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Gunnar Kappei
 */
public abstract class AbstractPermagonApplicationContext
        extends AnnotationConfigApplicationContext
        implements PermagonApplicationContext {

    private final FxmlFieldInjector fxmlFieldInjector;
    private BundleContext bundleCtx;
    private BundleTracker allBundlesTracker;
    private ServiceTracker allServiceTracker;

    public AbstractPermagonApplicationContext(PermagonApplication<? extends PermagonApplicationContext> application) {
        this.fxmlFieldInjector = new FxmlFieldInjector(this);
        init(Objects.requireNonNull(application));
    }

    private void init(PermagonApplication<? extends PermagonApplicationContext> application) {
        Platform.setImplicitExit(true);
        registerShutdownHook();

        try {
            getBeanFactory().registerSingleton(APPLICATION_BEAN_NAME, application);
            loadAnnotationConfig(application);
        } finally {
            refresh();
        }
        try {
            initFrameWork();
        } catch (BundleException ex) {
            Logger.getLogger(AbstractPermagonApplicationContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadAnnotationConfig(
            PermagonApplication<? extends PermagonApplicationContext> application) {
        Collection<String> beanPackages = application.getBeanConfigurationPackages();
        Collection<Class<?>> annotatedClasses = application.getBeanConfigurationClasses();

        if (isValidBeanConfigurationClasses(annotatedClasses)) {

            if (!annotatedClasses.isEmpty()) {
                register(annotatedClasses.toArray(new Class[0]));
            }

            if (beanPackages != null) {
                if (!beanPackages.isEmpty()) {
                    scan(beanPackages.toArray(new String[0]));
                }
            }

            return;
        }

        throw new IllegalStateException(
                "No configuration-class of type 'JavaFXBeanConfiguration' is defined!");

    }

    private void initFrameWork() throws BundleException {
        getFramework().init(new FrameworkListenerImpl());
        getFramework().start();
    }

    protected <S> S addingServiceImpl(ServiceReference reference) {
        Object result = getBundleContext().getService(reference);

        if (result != null) {
            return (S) getBundleContext().getService(reference);
        }

        return null;
    }

    protected boolean isValidBeanConfigurationClasses(
            Collection<Class<?>> beanConfigurationClasses) {
        return beanConfigurationClasses.stream().anyMatch((beanConfigurationClass)
                -> (JavaFXBeanConfiguration.class.isAssignableFrom(beanConfigurationClass)));
    }

    protected String getBeanCreationMethodName(Class<?> type) {
        Collection<Class<?>> configClasses
                = getApplication().getBeanConfigurationClasses();

        if (configClasses != null) {
            if (!configClasses.isEmpty()) {
                for (Class<?> configClass : configClasses) {
                    Method[] methods = configClass.getMethods();

                    for (Method method : methods) {
                        Class<?> returnType = method.getReturnType();
                        if (returnType == type) {
                            return method.getName();
                        }
                    }
                }
            }
        }

        throw new BeanCreationException("No qualifying bean of type '"
                + type.getName() + "' is defined!");
    }

    @Override
    public final <T> T createBean(Class<T> type) {
        return getBean(getBeanCreationMethodName(type), type);
    }

    @Override
    public final <T> T createBean(Class<T> type, Object... args) {
        return (T) getBean(getBeanCreationMethodName(type), args);
    }

    @Override
    public final PermagonApplication<? extends PermagonApplicationContext> getApplication() {
        return (PermagonApplication<? extends PermagonApplicationContext>) getBean(APPLICATION_BEAN_NAME);
    }

    @Override
    public Framework getFramework() {
        return getBean(Framework.class);
    }

    @Override
    public FxmlFieldInjector getFxmlFieldInjector() {
        return fxmlFieldInjector;
    }

    @Override
    public BundleContext getBundleContext() {
        return bundleCtx;
    }

    @Override
    public final Object addingService(ServiceReference reference) {
        Object service = addingServiceImpl(reference);
        getBeanFactory().registerSingleton(service.getClass().getSimpleName() + "Service", service);
        return service;
    }

    private class FrameworkListenerImpl implements FrameworkListener {

        @Override
        public void frameworkEvent(FrameworkEvent event) {
            BundleContext ctx = Objects.requireNonNull(event.getBundle().getBundleContext());
            AbstractPermagonApplicationContext.this.bundleCtx = ctx;
            AbstractPermagonApplicationContext.this.allBundlesTracker = new BundleTracker(
                    ctx, 0, AbstractPermagonApplicationContext.this);
            AbstractPermagonApplicationContext.this.allServiceTracker = new ServiceTracker(
                    ctx, Object.class, AbstractPermagonApplicationContext.this);
        }

    }
}
