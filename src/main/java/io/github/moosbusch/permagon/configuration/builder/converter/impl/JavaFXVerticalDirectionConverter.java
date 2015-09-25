package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.geometry.VerticalDirection;

public class JavaFXVerticalDirectionConverter extends AbstractJavaFXFromStringConverter<VerticalDirection> {

	@Override
	public VerticalDirection getDefaultValue() {
            return VerticalDirection.DOWN;
	}

	@Override
	public Class<VerticalDirection> getTargetType() {
		return VerticalDirection.class;
	}

	@Override
	public VerticalDirection valueFromString(String constraint) {
		return VerticalDirection.valueOf(constraint);
	}

}