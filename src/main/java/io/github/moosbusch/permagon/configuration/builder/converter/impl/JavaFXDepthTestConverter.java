package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.DepthTest;

public class JavaFXDepthTestConverter extends AbstractJavaFXFromStringConverter<DepthTest> {

    @Override
    public DepthTest getDefaultValue() {
        return DepthTest.INHERIT;
    }

    @Override
    public Class<DepthTest> getTargetType() {
        return DepthTest.class;
    }

    @Override
    public DepthTest valueFromString(String constraint) {
        return DepthTest.valueOf(constraint);
    }

}
