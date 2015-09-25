/*
 * Copyright 2015 Gunnar Kappei.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.moosbusch.permagon.configuration.builder.spi;

import io.github.moosbusch.permagon.application.PermagonApplicationContext;
import io.github.moosbusch.permagon.configuration.builder.PermagonBuilder;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXAlertTypeConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXBackgroundRepeatConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXBlendModeConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXBlurTypeConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXCacheHintConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXColorConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXContentDisplayConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXCullFaceConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXCycleMethodConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXDepthTestConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXDrawModeConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXFillRuleConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXFontPostureConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXFontSmoothingTypeConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXFontWeightConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXHPosConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXHorizontalDirectionConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXInputMethodHighlightConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXKeyCodeConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXModalityConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXNodeOrientationConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXOrientationConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXOverrunStyleConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXPageOrientationConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXPosConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXPrintColorConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXPrintQualityConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXPrintSidesConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXPriorityConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXScrollBarPolicyConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXSelectionModeConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXSideConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXStageStyleConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXStrokeLineCapConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXStrokeLineJoinConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXStrokeTypeConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXStyleOriginConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXTabClosingPolicyConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXTextAlignmentConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXTextBoundsTypeConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXTransferModeConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXTreeSortModeConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXVPosConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXVerticalDirectionConverter;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.DefaultProperty;
import javafx.beans.property.MapProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.css.StyleOrigin;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.geometry.HPos;
import javafx.geometry.HorizontalDirection;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.geometry.VPos;
import javafx.geometry.VerticalDirection;
import javafx.print.PageOrientation;
import javafx.print.PrintColor;
import javafx.print.PrintQuality;
import javafx.print.PrintSides;
import javafx.scene.CacheHint;
import javafx.scene.DepthTest;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToolBar;
import javafx.scene.control.TreeSortMode;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BlurType;
import javafx.scene.input.InputMethodHighlight;
import javafx.scene.input.KeyCode;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.util.Builder;
import javafx.util.BuilderFactory;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

/**
 *
 * @author Gunnar Kappei
 */
@DefaultProperty("properties")
public abstract class AbstractPermagonBuilder implements Map<String, Object>, PermagonBuilder<Object> {

    private static final long serialVersionUID = 6321535594458554960L;
    private transient final PermagonApplicationContext applicationContext;
    private transient final Class<?> type;
    private transient final BuilderFactory builderFactory;
    private transient final MapProperty<String, Object> properties;

    public AbstractPermagonBuilder(PermagonApplicationContext applicationContext,
            Class<?> type, BuilderFactory builderFactory) {
        this.applicationContext = applicationContext;
        this.type = type;
        this.builderFactory = builderFactory;
        this.properties = new SimpleMapProperty(FXCollections.observableHashMap());
        init();
    }

    public AbstractPermagonBuilder(PermagonApplicationContext applicationContext, Class<?> type) {
        this(applicationContext, type, new JavaFXBuilderFactory());
    }

    private void init() {
        initConverters();
        properties.put(NODE_CHILDREN_PROPERTY, FXCollections.observableArrayList());
        properties.put(NODE_ITEMS_PROPERTY, FXCollections.observableArrayList());
        properties.put(NODE_TABS_PROPERTY, FXCollections.observableArrayList());
        properties.put(NODE_BUTTONS_PROPERTY, FXCollections.observableArrayList());
        properties.put(NODE_MENUS_PROPERTY, FXCollections.observableArrayList());
    }

    protected void initConverters() {
        setConverter(Color.class, new JavaFXColorConverter());
        setConverter(Priority.class, new JavaFXPriorityConverter());
        setConverter(ScrollBarPolicy.class, new JavaFXScrollBarPolicyConverter());
        setConverter(VerticalDirection.class, new JavaFXVerticalDirectionConverter());
        setConverter(TabPane.TabClosingPolicy.class, new JavaFXTabClosingPolicyConverter());
        setConverter(DrawMode.class, new JavaFXDrawModeConverter());
        setConverter(VPos.class, new JavaFXVPosConverter());
        setConverter(StyleOrigin.class, new JavaFXStyleOriginConverter());
        setConverter(CycleMethod.class, new JavaFXCycleMethodConverter());
        setConverter(BlurType.class, new JavaFXBlurTypeConverter());
        setConverter(TreeSortMode.class, new JavaFXTreeSortModeConverter());
        setConverter(StrokeLineCap.class, new JavaFXStrokeLineCapConverter());
        setConverter(Alert.AlertType.class, new JavaFXAlertTypeConverter());
        setConverter(TextBoundsType.class, new JavaFXTextBoundsTypeConverter());
        setConverter(Orientation.class, new JavaFXOrientationConverter());
        setConverter(CacheHint.class, new JavaFXCacheHintConverter());
        setConverter(CullFace.class, new JavaFXCullFaceConverter());
        setConverter(BlendMode.class, new JavaFXBlendModeConverter());
        setConverter(Pos.class, new JavaFXPosConverter());
        setConverter(StageStyle.class, new JavaFXStageStyleConverter());
        setConverter(InputMethodHighlight.class, new JavaFXInputMethodHighlightConverter());
        setConverter(OverrunStyle.class, new JavaFXOverrunStyleConverter());
        setConverter(TransferMode.class, new JavaFXTransferModeConverter());
        setConverter(FontSmoothingType.class, new JavaFXFontSmoothingTypeConverter());
        setConverter(StrokeLineJoin.class, new JavaFXStrokeLineJoinConverter());
        setConverter(FontWeight.class, new JavaFXFontWeightConverter());
        setConverter(PrintSides.class, new JavaFXPrintSidesConverter());
        setConverter(KeyCode.class, new JavaFXKeyCodeConverter());
        setConverter(HPos.class, new JavaFXHPosConverter());
        setConverter(Side.class, new JavaFXSideConverter());
        setConverter(PrintQuality.class, new JavaFXPrintQualityConverter());
        setConverter(BackgroundRepeat.class, new JavaFXBackgroundRepeatConverter());
        setConverter(PrintColor.class, new JavaFXPrintColorConverter());
        setConverter(NodeOrientation.class, new JavaFXNodeOrientationConverter());
        setConverter(FillRule.class, new JavaFXFillRuleConverter());
        setConverter(DepthTest.class, new JavaFXDepthTestConverter());
        setConverter(Modality.class, new JavaFXModalityConverter());
        setConverter(FontPosture.class, new JavaFXFontPostureConverter());
        setConverter(HorizontalDirection.class, new JavaFXHorizontalDirectionConverter());
        setConverter(StrokeType.class, new JavaFXStrokeTypeConverter());
        setConverter(TextAlignment.class, new JavaFXTextAlignmentConverter());
        setConverter(SelectionMode.class, new JavaFXSelectionModeConverter());
        setConverter(PageOrientation.class, new JavaFXPageOrientationConverter());
        setConverter(ContentDisplay.class, new JavaFXContentDisplayConverter());
    }

    protected abstract Map<Class<?>, Converter> getConverters();

    protected PermagonApplicationContext getApplicationContext() {
        return applicationContext;
    }

    protected Class<?> getType() {
        return type;
    }

    protected BuilderFactory getBuilderFactory() {
        return builderFactory;
    }

    protected void buildPane(Pane pane) {
        if (containsKey(NODE_CHILDREN_PROPERTY)) {
            Object obj = Objects.requireNonNull(get(NODE_CHILDREN_PROPERTY));

            if (obj instanceof ObservableMap) {
                ObservableMap propertiesMap = (ObservableMap) obj;
                Object childrenObj = Objects.requireNonNull(propertiesMap.get(NODE_CHILDREN_PROPERTY));

                if (childrenObj instanceof ObservableList) {
                    pane.getChildren().addAll((ObservableList) childrenObj);
                }
            }
        }
    }

    protected void buildTabPane(TabPane pane) {
        if (containsKey(NODE_TABS_PROPERTY)) {
            Object obj = Objects.requireNonNull(get(NODE_TABS_PROPERTY));

            if (obj instanceof ObservableMap) {
                ObservableMap propertiesMap = (ObservableMap) obj;
                Object childrenObj = Objects.requireNonNull(propertiesMap.get(NODE_TABS_PROPERTY));

                if (childrenObj instanceof ObservableList) {
                    pane.getTabs().addAll((ObservableList) childrenObj);
                }
            }
        }
    }

    protected void buildTab(Tab pane) {
        if (containsKey(NODE_CONTENT_PROPERTY)) {
            Object obj = Objects.requireNonNull(get(NODE_CONTENT_PROPERTY));

            if (obj instanceof ObservableMap) {
                ObservableMap propertiesMap = (ObservableMap) obj;
                Object childrenObj = Objects.requireNonNull(propertiesMap.get(NODE_CONTENT_PROPERTY));

                if (childrenObj instanceof Node) {
                    pane.setContent((Node) childrenObj);
                }
            }
        }
    }

    protected void buildSplitPane(SplitPane pane) {
        if (containsKey(NODE_ITEMS_PROPERTY)) {
            Object obj = Objects.requireNonNull(get(NODE_ITEMS_PROPERTY));

            if (obj instanceof ObservableMap) {
                ObservableMap propertiesMap = (ObservableMap) obj;

                propertiesMap.values().stream().filter((propertyValue) -> (propertyValue instanceof ObservableList)).forEach((propertyValue) -> {
                    pane.getItems().addAll((ObservableList) propertyValue);
                });
            }
        }
    }

    protected void buildToolBar(ToolBar pane) {
        if (containsKey(NODE_ITEMS_PROPERTY)) {
            Object obj = Objects.requireNonNull(get(NODE_ITEMS_PROPERTY));

            if (obj instanceof ObservableMap) {
                ObservableMap propertiesMap = (ObservableMap) obj;

                propertiesMap.values().stream().filter((propertyValue) -> (propertyValue instanceof ObservableList)).forEach((propertyValue) -> {
                    pane.getItems().addAll((ObservableList) propertyValue);
                });
            }
        }
    }

    protected void buildMenuBar(MenuBar pane) {
        if (containsKey(NODE_MENUS_PROPERTY)) {
            Object obj = Objects.requireNonNull(get(NODE_MENUS_PROPERTY));

            if (obj instanceof ObservableMap) {
                ObservableMap propertiesMap = (ObservableMap) obj;

                propertiesMap.values().stream().filter((propertyValue) -> (propertyValue instanceof ObservableList)).forEach((propertyValue) -> {
                    pane.getMenus().addAll((ObservableList) propertyValue);
                });
            }
        }
    }

    protected void buildMenu(Menu pane) {
        if (containsKey(NODE_ITEMS_PROPERTY)) {
            Object obj = Objects.requireNonNull(get(NODE_ITEMS_PROPERTY));

            if (obj instanceof ObservableMap) {
                ObservableMap propertiesMap = (ObservableMap) obj;

                propertiesMap.values().stream().filter((propertyValue) -> (propertyValue instanceof ObservableList)).forEach((propertyValue) -> {
                    pane.getItems().addAll((ObservableList) propertyValue);
                });
            }
        }
    }

    protected void buildScrollPane(ScrollPane pane) {
        if (containsKey(NODE_PROPERTIES_PROPERTY)) {
            Object obj = Objects.requireNonNull(get(NODE_PROPERTIES_PROPERTY));

            if (obj instanceof ObservableMap) {
                ObservableMap propertiesMap = (ObservableMap) obj;

                for (Object propertyValue : propertiesMap.values()) {
                    if (propertyValue instanceof Node) {
                        pane.setContent((Node) propertyValue);
                        return;
                    }
                }
            }
        }
    }

    protected void buildTitledPane(TitledPane pane) {
        if (containsKey(NODE_PROPERTIES_PROPERTY)) {
            Object obj = Objects.requireNonNull(get(NODE_PROPERTIES_PROPERTY));

            if (obj instanceof ObservableMap) {
                ObservableMap propertiesMap = (ObservableMap) obj;

                for (Object propertyValue : propertiesMap.values()) {
                    if (propertyValue instanceof Node) {
                        pane.setContent((Node) propertyValue);
                        return;
                    }
                }
            }
        }
    }

    protected void buildButtonBar(ButtonBar buttonBar) {
        if (containsKey(NODE_BUTTONS_PROPERTY)) {
            Object obj = Objects.requireNonNull(get(NODE_BUTTONS_PROPERTY));

            if (obj instanceof ObservableMap) {
                ObservableMap propertiesMap = (ObservableMap) obj;

                propertiesMap.values().stream().filter((propertyValue) -> (propertyValue instanceof ObservableList)).forEach((propertyValue) -> {
                    buttonBar.getButtons().addAll((ObservableList) propertyValue);
                });
            }
        }
    }

    protected void buildAccordion(Accordion accordion) {
        if (containsKey(NODE_PANES_PROPERTY)) {
            Object obj = Objects.requireNonNull(get(NODE_PANES_PROPERTY));

            if (obj instanceof ObservableMap) {
                ObservableMap propertiesMap = (ObservableMap) obj;

                propertiesMap.values().stream().filter((propertyValue) -> (propertyValue instanceof ObservableList)).forEach((propertyValue) -> {
                    accordion.getPanes().addAll((ObservableList) propertyValue);
                });
            }
        }
    }

    protected Object putListProperty(String propertyName, Object value) {
        Object result = null;
        Object childrenValue = Objects.requireNonNull(get(propertyName));

        if (childrenValue instanceof ObservableMap) {
            ObservableMap propertiesMap = (ObservableMap) childrenValue;
            Object obj = Objects.requireNonNull(propertiesMap.get(propertyName));

            if (obj instanceof ObservableList) {
                ObservableList childrenValueList = (ObservableList) obj;

                result = childrenValueList;

                if ((value instanceof Node) || (value instanceof Tab)) {
                    if (!childrenValueList.contains(value)) {
                        childrenValueList.add(value);
                        properties.put(propertyName, childrenValueList);
                    }
                }
            }
        }

        return result;
    }

    @Override
    public Object build() {
        Object result;
        Class<?> thype = getType();
        BuilderFactory buylderFactory = getBuilderFactory();
        PermagonApplicationContext applicationCtx = getApplicationContext();
        Map<Class<?>, Converter> converterz = getConverters();
        Builder<?> builder = buylderFactory.getBuilder(thype);

        if (builder != null) {
            result = builder.build();
            applicationCtx.getBeanFactory().autowireBean(result);
        } else {
            result = applicationCtx.createBean(thype);
        }

        converterz.entrySet().stream().forEach((converterEntry) -> {
            ConvertUtils.register(converterEntry.getValue(), converterEntry.getKey());
        });

        if (result instanceof Pane) {
            Pane resultPane = (Pane) result;
            buildPane(resultPane);

        } else if (result instanceof ScrollPane) {
            ScrollPane resultPane = (ScrollPane) result;
            buildScrollPane(resultPane);
        } else if (result instanceof SplitPane) {
            SplitPane resultPane = (SplitPane) result;
            buildSplitPane(resultPane);
        } else if (result instanceof TabPane) {
            TabPane resultPane = (TabPane) result;
            buildTabPane(resultPane);
        } else if (result instanceof Tab) {
            Tab resultPane = (Tab) result;
            buildTab(resultPane);
        } else if (result instanceof ButtonBar) {
            ButtonBar resultPane = (ButtonBar) result;
            buildButtonBar(resultPane);
        } else if (result instanceof Accordion) {
            Accordion resultPane = (Accordion) result;
            buildAccordion(resultPane);
        } else if (result instanceof TitledPane) {
            TitledPane resultPane = (TitledPane) result;
            buildTitledPane(resultPane);
        } else if (result instanceof ToolBar) {
            ToolBar resultPane = (ToolBar) result;
            buildToolBar(resultPane);
        } else if (result instanceof MenuBar) {
            MenuBar resultPane = (MenuBar) result;
            buildMenuBar(resultPane);
        }

        try {
            BeanUtils.populate(result, this);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(AbstractPermagonBuilder.class.getName()).log(
                    Level.SEVERE, null, ex);
        }

        return result;
    }

    @Override
    public void getConverter(Class<?> key) {
        getConverters().get(key);
    }

    @Override
    public void setConverter(Class<?> key, Converter value) {
        getConverters().put(key, value);
    }

    @Override
    public void removeConverter(Class<?> key, Converter value) {
        getConverters().remove(key, value);
    }

    public ObservableMap<String, Object> getProperties() {
        return properties;
    }

    @Override
    public Object put(String key, Object value) {
        Object result = null;

        if (value != null) {
            if (null != key)
                switch (key) {
                    case NODE_CHILDREN_PROPERTY:
                        return result = putListProperty(NODE_CHILDREN_PROPERTY, value);
                    case NODE_ITEMS_PROPERTY:
                        return result = putListProperty(NODE_ITEMS_PROPERTY, value);
                    case NODE_TABS_PROPERTY:
                        return result = putListProperty(NODE_TABS_PROPERTY, value);
            }
        }

        return properties.put(key, value);
    }

    @Override
    public int size() {
        return properties.size();
    }

    @Override
    public boolean isEmpty() {
        return properties.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return properties.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return properties.containsValue(value);
    }

    @Override
    public Object get(Object key) {
        return properties.get();
    }

    @Override
    public void putAll(Map<? extends String, ? extends Object> m) {
        properties.putAll(m);
    }

    @Override
    public void clear() {
        properties.clear();
    }

    @Override
    public Set<String> keySet() {
        return properties.keySet();
    }

    @Override
    public Collection<Object> values() {
        return properties.values();
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        return propertiesProperty().entrySet();
    }

    public MapProperty propertiesProperty() {
        return properties;
    }

    @Override
    public Object remove(Object key) {
        return properties.remove(key);
    }

}
