package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.print.PrintSides;

public class JavaFXPrintSidesConverter extends AbstractJavaFXFromStringConverter<PrintSides> {

	@Override
	public PrintSides getDefaultValue() {
            return PrintSides.ONE_SIDED;
	}

	@Override
	public Class<PrintSides> getTargetType() {
		return PrintSides.class;
	}

	@Override
	public PrintSides valueFromString(String constraint) {
		return PrintSides.valueOf(constraint);
	}

}