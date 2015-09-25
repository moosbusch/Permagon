package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.shape.CullFace;

public class JavaFXCullFaceConverter extends AbstractJavaFXFromStringConverter<CullFace> {

	@Override
	public CullFace getDefaultValue() {
            return CullFace.NONE;
	}

	@Override
	public Class<CullFace> getTargetType() {
		return CullFace.class;
	}

	@Override
	public CullFace valueFromString(String constraint) {
		return CullFace.valueOf(constraint);
	}

}