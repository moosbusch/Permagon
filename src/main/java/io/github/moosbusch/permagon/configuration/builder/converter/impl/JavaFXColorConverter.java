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
package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.paint.Color;

/**
 *
 * @author Gunnar Kappei
 */
public class JavaFXColorConverter extends AbstractJavaFXFromStringConverter<Color> {

    @Override
    public Class<Color> getTargetType() {
        return Color.class;
    }

    @Override
    public Color getDefaultValue() {
        return Color.WHITE;
    }

    @Override
    public Color valueFromString(String constraint) {
        return Color.valueOf(constraint);
    }

//    @Override
//    public <T> T convert(Class<T> type, Object value) {
//        T result = null;
//
//        if (Color.class.isAssignableFrom(type)) {
//            if (value instanceof Color) {
//                result = (T) value;
//            } else if (value instanceof String) {
//                String val = value.toString();
//
//                val = StringUtils.replace(val.toUpperCase(), "COLOR.", "");
//
//                result = (T) Color.valueOf(val);
//            }
//
//            return result;
//        }
//
//        throw new IllegalArgumentException("Cannot covert object of type " +
//                type.getName() + ". Exspected 'javafx.scene.paint.Color'." );
//    }

}
