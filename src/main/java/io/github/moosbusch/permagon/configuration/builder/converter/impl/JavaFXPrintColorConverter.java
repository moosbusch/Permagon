package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.print.PrintColor;

public class JavaFXPrintColorConverter extends AbstractJavaFXFromStringConverter<PrintColor> {

    @Override
    public PrintColor getDefaultValue() {
        return PrintColor.COLOR;
    }

    @Override
    public Class<PrintColor> getTargetType() {
        return PrintColor.class;
    }

    @Override
    public PrintColor valueFromString(String constraint) {
        return PrintColor.valueOf(constraint);
    }

}
