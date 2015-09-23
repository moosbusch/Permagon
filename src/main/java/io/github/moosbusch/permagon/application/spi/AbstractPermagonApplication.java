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
package io.github.moosbusch.permagon.application.spi;

import io.github.moosbusch.permagon.application.PermagonApplication;
import io.github.moosbusch.permagon.application.PermagonApplicationContext;
import io.github.moosbusch.permagon.configuration.controller.PermagonController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Builder;
import javafx.util.BuilderFactory;
import javafx.util.Callback;

/**
 *
 * @author Gunnar Kappei
 * @param <T> The application-context
 */
public abstract class AbstractPermagonApplication<T extends PermagonApplicationContext>
    extends Application implements PermagonApplication<T> {

    private final T applicationContext;

    public AbstractPermagonApplication() {
        this.applicationContext = initApplicationContext();
    }

    private T initApplicationContext() {
        return createApplicationContext();
    }

    protected abstract T createApplicationContext();

    protected void processScene(Scene scene) {
    }

    protected void processParent(Parent root) {
    }

    protected void processStage(Stage stage) {
    }

    @Override
    public final T getApplicationContext() {
        return applicationContext;
    }

    @Override
    public final void start(Stage stage) throws Exception {
        final T ctx = getApplicationContext();
        URL fxmlFileUrl = getFXMLConfigurationFile();
        Callback<Class<?>, Object> controllerFactory = new Callback<Class<?>, Object>() {

            public Object call(Class<?> type) {
                Object result = getApplicationContext().createBean(type);

                if (result instanceof PermagonController) {
                    return (PermagonController) result;
                }

                throw new IllegalStateException(
                        "Controllers must inherit from 'PermagonController.class'");
            }
        };

        ResourceBundle resources = ctx.getResources();

        Parent root = (Parent) FXMLLoader.load(fxmlFileUrl, resources, new BuilderFactory() {

            public Builder<?> getBuilder(Class<?> type) {
                return ctx.getBuilder(type);
            }
        }, controllerFactory);

        processParent(root);
        processStage(stage);

        Scene scene = new Scene(root);
        processScene(scene);

        stage.setScene(scene);
        stage.onShowingProperty().addListener(getApplicationContext().getFxmlFieldInjector());
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
