/*
 */
package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;

/**
 *
 * @author gki
 */
public class JavaFXScrollBarPolicyConverter extends AbstractJavaFXFromStringConverter<ScrollBarPolicy> {

    @Override
    public Class<ScrollBarPolicy> getTargetType() {
        return ScrollBarPolicy.class;
    }

    @Override
    public ScrollBarPolicy getDefaultValue() {
        return ScrollBarPolicy.AS_NEEDED;
    }

    @Override
    public ScrollBarPolicy valueFromString(String constraint) {
        return ScrollBarPolicy.valueOf(constraint);
    }
//    @Override
//    public <T> T convert(Class<T> type, Object value) {
//        T result = (T) ScrollBarPolicy.AS_NEEDED;
//
//        if (ScrollBarPolicy.class.isAssignableFrom(type)) {
//            if (value != null) {
//                if (value instanceof ScrollBarPolicy) {
//                    result = (T) value;
//                } else if (value instanceof String) {
//                    if (!value.toString().isEmpty()) {
//                        result = (T) ScrollBarPolicy.valueOf(value.toString());
//                    }
//                }
//            }
//        }
//
//        return result;
//    }

}
