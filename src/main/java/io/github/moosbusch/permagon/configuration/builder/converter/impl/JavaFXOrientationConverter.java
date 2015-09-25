package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.geometry.Orientation;

public class JavaFXOrientationConverter extends AbstractJavaFXFromStringConverter<Orientation> {

	@Override
	public Orientation getDefaultValue() {
            return Orientation.HORIZONTAL;
	}

	@Override
	public Class<Orientation> getTargetType() {
		return Orientation.class;
	}

	@Override
	public Orientation valueFromString(String constraint) {
		return Orientation.valueOf(constraint);
	}

}