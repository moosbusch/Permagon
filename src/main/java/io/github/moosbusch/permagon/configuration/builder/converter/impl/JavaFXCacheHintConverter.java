package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.CacheHint;

public class JavaFXCacheHintConverter extends AbstractJavaFXFromStringConverter<CacheHint> {

	@Override
	public CacheHint getDefaultValue() {
            return CacheHint.DEFAULT;
	}

	@Override
	public Class<CacheHint> getTargetType() {
		return CacheHint.class;
	}

	@Override
	public CacheHint valueFromString(String constraint) {
		return CacheHint.valueOf(constraint);
	}

}