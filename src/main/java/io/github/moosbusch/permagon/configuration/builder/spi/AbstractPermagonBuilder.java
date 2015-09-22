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
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXColorConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXLayoutPriorityConverter;
import io.github.moosbusch.permagon.configuration.builder.converter.impl.JavaFXScrollBarPolicyConverter;
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
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
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
        setConverter(Priority.class, new JavaFXLayoutPriorityConverter());
        setConverter(ScrollBarPolicy.class, new JavaFXScrollBarPolicyConverter());
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

                if (value instanceof Node) {
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
