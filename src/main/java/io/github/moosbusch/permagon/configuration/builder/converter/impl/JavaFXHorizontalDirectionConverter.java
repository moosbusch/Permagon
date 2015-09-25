package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.geometry.HorizontalDirection;

public class JavaFXHorizontalDirectionConverter extends AbstractJavaFXFromStringConverter<HorizontalDirection> {

    @Override
    public HorizontalDirection getDefaultValue() {
        return HorizontalDirection.RIGHT;
    }

    @Override
    public Class<HorizontalDirection> getTargetType() {
        return HorizontalDirection.class;
    }

    @Override
    public HorizontalDirection valueFromString(String constraint) {
        return HorizontalDirection.valueOf(constraint);
    }

}
