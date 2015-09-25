package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.print.PageOrientation;

public class JavaFXPageOrientationConverter extends AbstractJavaFXFromStringConverter<PageOrientation> {

    @Override
    public PageOrientation getDefaultValue() {
        return PageOrientation.PORTRAIT;
    }

    @Override
    public Class<PageOrientation> getTargetType() {
        return PageOrientation.class;
    }

    @Override
    public PageOrientation valueFromString(String constraint) {
        return PageOrientation.valueOf(constraint);
    }

}
