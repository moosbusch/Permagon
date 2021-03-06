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
package io.github.moosbusch.permagon.configuration.controller.spi;

import io.github.moosbusch.permagon.application.PermagonApplicationContext;
import io.github.moosbusch.permagon.configuration.controller.PermagonController;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Gunnar Kappei
 */
public abstract class AbstractPermagonController implements PermagonController {

    @Autowired
    private PermagonApplicationContext appCtx;

    protected abstract void initializeImpl(URL location, ResourceBundle resources);

    @Override
    public void registerMembers() {
        Field[] fields = FieldUtils.getAllFields(getClass());

        for (Field field : fields) {
            FXML fxml = field.getAnnotation(FXML.class);

            if (fxml != null) {
                String fieldName = field.getName();
                Object fieldValue = null;

                try {
                    field.setAccessible(true);
                    fieldValue = field.get(this);
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                    Logger.getLogger(AbstractPermagonController.class.getName()).log(
                            Level.SEVERE, null, ex);
                } finally {
                    if (fieldValue != null) {
                        appCtx.getBeanFactory().registerSingleton(fieldName, fieldValue);
                    }
                }
            }
        }
    }

    @Override
    public final void initialize(URL location, ResourceBundle resources) {
        initializeImpl(location, resources);
        registerMembers();
    }

}
