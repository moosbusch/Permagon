package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.control.ContentDisplay;

public class JavaFXContentDisplayConverter extends AbstractJavaFXFromStringConverter<ContentDisplay> {

    @Override
    public ContentDisplay getDefaultValue() {
        return ContentDisplay.LEFT;
    }

    @Override
    public Class<ContentDisplay> getTargetType() {
        return ContentDisplay.class;
    }

    @Override
    public ContentDisplay valueFromString(String constraint) {
        return ContentDisplay.valueOf(constraint);
    }

}
