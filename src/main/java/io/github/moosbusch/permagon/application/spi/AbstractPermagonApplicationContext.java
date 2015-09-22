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
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Objects;
import javafx.application.Platform;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Gunnar Kappei
 */
public abstract class AbstractPermagonApplicationContext
        extends AnnotationConfigApplicationContext
        implements PermagonApplicationContext {

    public AbstractPermagonApplicationContext(PermagonApplication<? extends PermagonApplicationContext> application) {
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
                "No configuration-class of type 'PivotBeanConfiguration' is defined!");

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
        return (PermagonApplication<? extends PermagonApplicationContext>)
                getBean(APPLICATION_BEAN_NAME);
    }

//    private class WindowStateListenerImpl extends WindowStateListener.Adapter {
//
//        @Override
//        public Vote previewWindowOpen(Window window) {
//            for (String key : getBeanDefinitionNames()) {
//                final Object value = Objects.requireNonNull(getBean(key));
//
//                if (value instanceof Bindable) {
//                    org.apache.pivot.wtk.ApplicationContext.queueCallback(new BindingCallback(AbstractPermagonApplicationContext.this, (Bindable) value));
//                }
//            }
////            for (String key : getComponents()) {
////                final Object value = Objects.requireNonNull(getBean(key));
////
////                if (value instanceof Bindable) {
////                    org.apache.pivot.wtk.ApplicationContext.queueCallback(
////                            new BindingCallback(AbstractLumpiApplicationContext.this, (Bindable) value));
////                }
////            }
//            return super.previewWindowOpen(window);
//        }
//
//    }

//    private class BindingCallback implements Runnable {
//
//        private final Bindable target;
//
//        public BindingCallback(ApplicationContext applicationContext, Bindable target) {
//            this.target = target;
//        }
//
//        @Override
//        public void run() {
//            try {
//                bind(AbstractPermagonApplicationContext.this, target);
//            } catch (IllegalAccessException ex) {
//                Logger.getLogger(AbstractPermagonApplicationContext.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//        public void bind(ApplicationContext applicationContext, Bindable bean) throws IllegalAccessException {
//            Field[] fields = bean.getClass().getDeclaredFields();
//
//            for (Field field : fields) {
//                if (field.isAnnotationPresent(BXML.class)) {
//                    String fieldName = field.getName();
//                    int fieldModifiers = field.getModifiers();
//                    BXML bindingAnnotation = field.getAnnotation(BXML.class);
//                    if ((fieldModifiers & Modifier.FINAL) > 0) {
//                        throw new IllegalAccessException(fieldName + " is final.");
//                    }
//                    if ((fieldModifiers & Modifier.PUBLIC) == 0) {
//                        field.setAccessible(true);
//                    }
//                    String id = bindingAnnotation.id();
//                    if (StringUtils.isBlank(id) || id.equals("\0")) {
//                        id = field.getName();
//                    }
//                    if (applicationContext.containsBean(id)) {
//                        Object value = applicationContext.getBean(id);
//                        FieldUtils.writeDeclaredField(target, id, value, true);
//                    }
//                }
//            }
//        }
//
//    }

}
