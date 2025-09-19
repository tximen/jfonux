/*
 * Copyright (c) 2016 JFoenix
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.jfonux.controls;

import javafx.animation.Transition;
import javafx.beans.DefaultProperty;
import javafx.beans.NamedArg;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.Locale;

/**
 * the famous animated hamburger icon used in material design
 *
 * @author Shadi Shaheen
 * @author Thomas Simon
 */
@DefaultProperty(value = "animation")
public class JFXHamburger extends VBox {

    private Transition animation;
   // private String transitionMode;
    private HamburgerTransition burgerTask;

    /**
     * creates a hamburger icon
     */
    public JFXHamburger(@NamedArg("id") String id, @NamedArg("transition") BurgerMode transitionMode) {
        this (transitionMode);
        setId(id);
    }

    /**
     * creates a hamburger icon
     */
    public JFXHamburger(@NamedArg("transition") BurgerMode transitionMode) {
        System.err.println("trans: " + transitionMode);
      //  transitionMode = transitionMode;

        this.getChildren().addAll(createLine(), createLine(), createLine());
        this.getStyleClass().add(DEFAULT_STYLE_CLASS);
        this.setAlignment(Pos.CENTER);
        this.setFillWidth(false);
        this.setSpacing(4);
        this.burgerTask = burgerTransition(transitionMode);
        this.burgerTask.setRate(-1);
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, burgerTask::createRateEvent);
    }


    private HamburgerTransition burgerTransition(BurgerMode transitionMode) {
        return switch (transitionMode) {
            case null -> throw new IllegalStateException("transition mode must not be null");
            case BasicClose -> new HamburgerBasicCloseTransition(this);
            case BackArrow  -> new HamburgerBackArrowBasicTransition(this);
            case NextArrow  -> new HamburgerNextArrowBasicTransition(this);
            case SlideClose -> new HamburgerSlideCloseTransition(this);
        };
    }

    private static String lower(String message) {
        if (message == null) {
            return "";
        } else {
            return message.toLowerCase(Locale.ROOT);
        }
    }


    /**
     * create the burger line
     * @return burger line
     */
    private static StackPane createLine() {
        StackPane pane = new StackPane();
        pane.setOpacity(1);
        pane.setPrefSize(30, 4);
        pane.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5), Insets.EMPTY)));
        return pane;
    }

    /**
     * @return the current animation of the hamburger
     */
    public Transition getAnimation() {
        return animation;
    }


    /**
     * set a specified {@link HamburgerTransition}
     *
     * @param animation
     */

    public void setAnimation(Transition animation) {
        if (animation instanceof HamburgerTransition hamburger) {
            this.animation = hamburger.getAnimation(this);
            this.animation.setRate(-1);
        }
    }

    /**
     * Initialize the style class to 'jfx-hamburger'.
     * <p>
     * This is the selector class from which CSS can be used to style
     * this control.
     */
    private static final String DEFAULT_STYLE_CLASS = "jfx-hamburger";

}
