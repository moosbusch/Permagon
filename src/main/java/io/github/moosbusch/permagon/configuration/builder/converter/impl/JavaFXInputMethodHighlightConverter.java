package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.input.InputMethodHighlight;

public class JavaFXInputMethodHighlightConverter extends AbstractJavaFXFromStringConverter<InputMethodHighlight> {

	@Override
	public InputMethodHighlight getDefaultValue() {
            return InputMethodHighlight.SELECTED_CONVERTED;
	}

	@Override
	public Class<InputMethodHighlight> getTargetType() {
		return InputMethodHighlight.class;
	}

	@Override
	public InputMethodHighlight valueFromString(String constraint) {
		return InputMethodHighlight.valueOf(constraint);
	}

}