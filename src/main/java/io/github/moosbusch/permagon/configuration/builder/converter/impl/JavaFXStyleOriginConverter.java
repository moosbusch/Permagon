package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.css.StyleOrigin;

public class JavaFXStyleOriginConverter extends AbstractJavaFXFromStringConverter<StyleOrigin> {

	@Override
	public StyleOrigin getDefaultValue() {
            return StyleOrigin.AUTHOR;
	}

	@Override
	public Class<StyleOrigin> getTargetType() {
		return StyleOrigin.class;
	}

	@Override
	public StyleOrigin valueFromString(String constraint) {
		return StyleOrigin.valueOf(constraint);
	}

}