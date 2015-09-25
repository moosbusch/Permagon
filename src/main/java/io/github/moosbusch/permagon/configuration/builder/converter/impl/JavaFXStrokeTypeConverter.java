package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.shape.StrokeType;

public class JavaFXStrokeTypeConverter extends AbstractJavaFXFromStringConverter<StrokeType> {

	@Override
	public StrokeType getDefaultValue() {
            return StrokeType.CENTERED;
	}

	@Override
	public Class<StrokeType> getTargetType() {
		return StrokeType.class;
	}

	@Override
	public StrokeType valueFromString(String constraint) {
		return StrokeType.valueOf(constraint);
	}

}