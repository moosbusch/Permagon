package io.github.moosbusch.permagon.configuration.builder.converter.impl;

import io.github.moosbusch.permagon.configuration.builder.converter.spi.AbstractJavaFXFromStringConverter;
import javafx.scene.control.TreeSortMode;

public class JavaFXTreeSortModeConverter extends AbstractJavaFXFromStringConverter<TreeSortMode> {

	@Override
	public TreeSortMode getDefaultValue() {
            return TreeSortMode.ONLY_FIRST_LEVEL;
	}

	@Override
	public Class<TreeSortMode> getTargetType() {
		return TreeSortMode.class;
	}

	@Override
	public TreeSortMode valueFromString(String constraint) {
		return TreeSortMode.valueOf(constraint);
	}

}