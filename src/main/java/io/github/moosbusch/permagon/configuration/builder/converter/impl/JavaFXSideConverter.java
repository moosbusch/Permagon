package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.geometry.Side;

public class JavaFXSideConverter extends AbstractJavaFXFromStringConverter<Side> {

    @Override
    public Side getDefaultValue() {
        return Side.LEFT;
    }

    @Override
    public Class<Side> getTargetType() {
        return Side.class;
    }

    @Override
    public Side valueFromString(String constraint) {
        return Side.valueOf(constraint);
    }

}
