/*
 */
package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.layout.Priority;

/**
 *
 * @author gki
 */
public class JavaFXLayoutPriorityConverter extends AbstractJavaFXFromStringConverter<Priority> {

    @Override
    public Class<Priority> getTargetType() {
        return Priority.class;
    }

    @Override
    public Priority getDefaultValue() {
        return Priority.SOMETIMES;
    }

    @Override
    public Priority valueFromString(String constraint) {
        return Priority.valueOf(constraint);
    }

//    @Override
//    public <T> T convert(Class<T> type, Object value) {
//        T result = (T) Priority.SOMETIMES;
//
//        if (Priority.class.isAssignableFrom(type)) {
//            if (value != null) {
//                if (value instanceof Priority) {
//                    result = (T) (Priority) value;
//                } else if (value instanceof String) {
//                    if (!value.toString().isEmpty()) {
//                        result = (T) Priority.valueOf(value.toString());
//                    }
//                }
//            }
//        }
//
//        return result;
//    }

}
