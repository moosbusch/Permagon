package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.geometry.NodeOrientation;

public class JavaFXNodeOrientationConverter extends AbstractJavaFXFromStringConverter<NodeOrientation> {

	@Override
	public NodeOrientation getDefaultValue() {
            return NodeOrientation.INHERIT;
	}

	@Override
	public Class<NodeOrientation> getTargetType() {
		return NodeOrientation.class;
	}

	@Override
	public NodeOrientation valueFromString(String constraint) {
		return NodeOrientation.valueOf(constraint);
	}

}