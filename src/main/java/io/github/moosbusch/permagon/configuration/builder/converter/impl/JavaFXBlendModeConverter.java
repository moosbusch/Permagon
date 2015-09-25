package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.effect.BlendMode;

public class JavaFXBlendModeConverter extends AbstractJavaFXFromStringConverter<BlendMode> {

	@Override
	public BlendMode getDefaultValue() {
            return BlendMode.MULTIPLY;
	}

	@Override
	public Class<BlendMode> getTargetType() {
		return BlendMode.class;
	}

	@Override
	public BlendMode valueFromString(String constraint) {
		return BlendMode.valueOf(constraint);
	}

}