package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.input.KeyCode;

public class JavaFXKeyCodeConverter extends AbstractJavaFXFromStringConverter<KeyCode> {

	@Override
	public KeyCode getDefaultValue() {
            return KeyCode.SPACE;
	}

	@Override
	public Class<KeyCode> getTargetType() {
		return KeyCode.class;
	}

	@Override
	public KeyCode valueFromString(String constraint) {
		return KeyCode.valueOf(constraint);
	}

}