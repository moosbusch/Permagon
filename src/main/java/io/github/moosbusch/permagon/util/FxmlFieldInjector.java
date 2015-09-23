/*
 */
package io.github.moosbusch.permagon.util;

import io.github.moosbusch.permagon.application.PermagonApplicationContext;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.WindowEvent;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

/**
 *
 * @author gki
 */
public class FxmlFieldInjector implements ChangeListener<EventHandler<WindowEvent>> {

    private final PermagonApplicationContext applicationContext;

    public FxmlFieldInjector(PermagonApplicationContext applicationContext) {
        this.applicationContext = Objects.requireNonNull(applicationContext);
    }

    protected PermagonApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void inject() throws Exception {
        for (String key : getApplicationContext().getBeanDefinitionNames()) {
            final Object value = Objects.requireNonNull(getApplicationContext().getBean(key));
            List<Method> fxmlMethods = MethodUtils.getMethodsListWithAnnotation(value.getClass(), FXML.class);

            if ((value instanceof Initializable) || (!fxmlMethods.isEmpty())) {
                Field[] fxmlFields = FieldUtils.getFieldsWithAnnotation(value.getClass(), FXML.class);

                for (Field fxmlField : fxmlFields) {
                    String fieldName = fxmlField.getName();
                    int fieldModifiers = fxmlField.getModifiers();

                    if ((fieldModifiers & Modifier.FINAL) > 0) {
                        throw new IllegalAccessException(fieldName + " is final.");
                    }
                    if ((fieldModifiers & Modifier.PUBLIC) == 0) {
                        fxmlField.setAccessible(true);
                    }

                    if (applicationContext.containsBean(fieldName)) {
                        FieldUtils.writeDeclaredField(value, fxmlField.getName(), value, true);
                    }
                }
            }
        }
    }

    @Override
    public final void changed(ObservableValue<? extends EventHandler<WindowEvent>> observable,
            EventHandler<WindowEvent> oldValue, EventHandler<WindowEvent> newValue) {
        try {
            inject();
        } catch (Exception ex) {
            Logger.getLogger(FxmlFieldInjector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
