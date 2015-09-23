/*
 Copyright 2013 Gunnar Kappei

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package io.github.moosbusch.permagon.application;

import io.github.moosbusch.permagon.util.FxmlFieldInjector;
import java.util.ResourceBundle;
import javafx.util.Builder;
import org.osgi.framework.BundleContext;
import org.osgi.framework.launch.Framework;
import org.osgi.util.tracker.BundleTrackerCustomizer;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * @author moosbusch
 */
public interface PermagonApplicationContext
        extends ConfigurableApplicationContext, BundleTrackerCustomizer, ServiceTrackerCustomizer {

    public static final String APPLICATION_BEAN_NAME = "applicationBean";
    public static final String FRAMEWORK_BEAN_NAME = "frameworkBean";
    public static final String APPLICATION_WINDOW_PROPERTY_NAME = "applicationWindow";

    public <T> T createBean(Class<T> type);

    public <T> T createBean(Class<T> type, Object... args);

    public Builder<Object> getBuilder(Class<?> type);

    public ResourceBundle getResources();

    public PermagonApplication<? extends PermagonApplicationContext> getApplication();

    public Framework getFramework();

    public FxmlFieldInjector getFxmlFieldInjector();

    public void shutdownContext();

    public BundleContext getBundleContext();

}
