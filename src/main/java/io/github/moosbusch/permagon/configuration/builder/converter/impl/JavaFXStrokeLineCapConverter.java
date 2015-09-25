package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.shape.StrokeLineCap;

public class JavaFXStrokeLineCapConverter extends AbstractJavaFXFromStringConverter<StrokeLineCap> {

	@Override
	public StrokeLineCap getDefaultValue() {
            return StrokeLineCap.ROUND;
	}

	@Override
	public Class<StrokeLineCap> getTargetType() {
		return StrokeLineCap.class;
	}

	@Override
	public StrokeLineCap valueFromString(String constraint) {
		return StrokeLineCap.valueOf(constraint);
	}

}