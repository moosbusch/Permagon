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
package io.github.moosbusch.permagon.configuration.impl;

import io.github.moosbusch.permagon.application.PermagonApplicationContext;
import io.github.moosbusch.permagon.configuration.builder.spi.AbstractPermagonBuilder;
import java.util.HashMap;
import java.util.Map;
import javafx.util.BuilderFactory;
import org.apache.commons.beanutils.Converter;

/**
 *
 * @author Gunnar Kappei
 */
public class DefaultPermagonBuilder extends AbstractPermagonBuilder {

    private static final long serialVersionUID = 2046727323981473225L;
    private transient Map<Class<?>, Converter> converters;

    public DefaultPermagonBuilder(PermagonApplicationContext applicationContext,
            Class<?> type, BuilderFactory builderFactory) {
        super(applicationContext, type, builderFactory);
    }

    public DefaultPermagonBuilder(PermagonApplicationContext applicationContext, Class<?> type) {
        super(applicationContext, type);
    }

    @Override
    protected Map<Class<?>, Converter> getConverters() {
        if (this.converters == null) {
            this.converters = new HashMap<>();

        }
        
        return this.converters;
    }

}
