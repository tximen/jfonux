package com.jfonux.skins;

import com.jfonux.controls.JFXPasswordField;
import javafx.beans.InvalidationListener;
import javafx.beans.WeakInvalidationListener;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.css.PseudoClass;

import java.util.function.Consumer;

public class JFXPasswordFieldSkin extends JFXTextFieldSkin<JFXPasswordField> {
    private static final char BULLET = '●';
    private final PseudoClass PSEUDO_UNMASKED = PseudoClass.getPseudoClass("unmasked");
    private final InvalidationListener invalidationListener = observable ->
        getSkinnable().pseudoClassStateChanged(PSEUDO_UNMASKED, !((JFXPasswordField) getSkinnable()).isMaskedText());

    private final WeakInvalidationListener maskedListener = new WeakInvalidationListener(invalidationListener);

    public JFXPasswordFieldSkin(JFXPasswordField passwordField) {
        super(passwordField);
        passwordField.maskedTextProperty().addListener(maskedListener);
        invalidationListener.invalidated(null);
        //registerChangeListener(passwordField.maskedTextProperty(), "MASKED_TEXT");
        // TODO have a look at this
        registerChangeListener(passwordField.maskedTextProperty(), this::changeConsumer);
    }

    private void changeConsumer(ObservableValue<?> value) {
        System.err.println(getClass() + "TODO 1 refactor");
    }

    /**
    @Override
    protected void handleControlPropertyChanged(String propertyReference) {
        if ("MASKED_TEXT".equals(propertyReference)) {
            getSkinnable().appendText("#");
            final int length = getSkinnable().getLength();
            getSkinnable().deleteText(length - 1, length);
        } else {
            super.handleControlPropertyChanged(propertyReference);
        }
    }
*/
    @Override
    protected String maskText(String txt) {
        // handler mask text
        if (getSkinnable() != null && ((JFXPasswordField) getSkinnable()).isMaskedText()) {
            int n = txt.length();
            StringBuilder passwordBuilder = new StringBuilder(n);
            for (int i = 0; i < n; i++) {
                passwordBuilder.append(BULLET);
            }
            return passwordBuilder.toString();
        } else {
            return txt;
        }
    }
}
