package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.shape.DrawMode;

public class JavaFXDrawModeConverter extends AbstractJavaFXFromStringConverter<DrawMode> {

	@Override
	public DrawMode getDefaultValue() {
            return DrawMode.LINE;
	}

	@Override
	public Class<DrawMode> getTargetType() {
		return DrawMode.class;
	}

	@Override
	public DrawMode valueFromString(String constraint) {
		return DrawMode.valueOf(constraint);
	}

}