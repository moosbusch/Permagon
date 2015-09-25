package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.stage.StageStyle;

public class JavaFXStageStyleConverter extends AbstractJavaFXFromStringConverter<StageStyle> {

	@Override
	public StageStyle getDefaultValue() {
            return StageStyle.DECORATED;
	}

	@Override
	public Class<StageStyle> getTargetType() {
		return StageStyle.class;
	}

	@Override
	public StageStyle valueFromString(String constraint) {
		return StageStyle.valueOf(constraint);
	}

}