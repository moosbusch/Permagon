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
package io.github.moosbusch.permagon.application.impl;

import io.github.moosbusch.permagon.application.PermagonApplication;
import io.github.moosbusch.permagon.application.PermagonApplicationContext;
import io.github.moosbusch.permagon.application.spi.AbstractPermagonApplicationContext;
import io.github.moosbusch.permagon.configuration.impl.DefaultPermagonBuilder;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.util.Builder;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;

/**
 *
 * @author Gunnar Kappei
 */
public class DefaultPermagonApplicationContext extends AbstractPermagonApplicationContext {

    public DefaultPermagonApplicationContext(
            PermagonApplication<? extends PermagonApplicationContext> application) {
        super(application);
    }

    @Override
    public Builder<Object> getBuilder(Class<?> type) {
        return new DefaultPermagonBuilder(this, type);
    }

    @Override
    public ResourceBundle getResources() {
        return null;
    }

    @Override
    public void modifiedService(ServiceReference reference, Object service) {
    }

    @Override
    public void removedService(ServiceReference reference, Object service) {
    }

    @Override
    public Object addingBundle(Bundle bundle, BundleEvent event) {
        return bundle;
    }

    @Override
    public void modifiedBundle(Bundle bundle, BundleEvent event, Object object) {
    }

    @Override
    public void removedBundle(Bundle bundle, BundleEvent event, Object object) {
    }

    @Override
    public void shutdownContext() {
        try {
            getFramework().stop();
        } catch (BundleException ex) {
            Logger.getLogger(DefaultPermagonApplicationContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        Platform.exit();
        System.exit(0);
    }

}
