package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.print.PrintQuality;

public class JavaFXPrintQualityConverter extends AbstractJavaFXFromStringConverter<PrintQuality> {

    @Override
    public PrintQuality getDefaultValue() {
        return PrintQuality.NORMAL;
    }

    @Override
    public Class<PrintQuality> getTargetType() {
        return PrintQuality.class;
    }

    @Override
    public PrintQuality valueFromString(String constraint) {
        return PrintQuality.valueOf(constraint);
    }

}
