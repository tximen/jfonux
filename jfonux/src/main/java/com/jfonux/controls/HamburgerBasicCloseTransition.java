package com.jfonux.controls;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * transform {@link JFXHamburger} into right arrow
 *
 * @author Shadi Shaheen
 * @version 1.0
 * @since 2016-03-09
 */
public class HamburgerBasicCloseTransition  extends HamburgerTransition {

    public HamburgerBasicCloseTransition(JFXHamburger burger) {
        super(burger, HamburgerBasicCloseTransition::createTimeline);
    }

    private static Timeline createTimeline(JFXHamburger burger) {
        double burgerWidth = burger.getChildren().get(0).getLayoutBounds().getWidth();
        double burgerHeight = burger.getChildren().get(2).getBoundsInParent().getMaxY() - burger.getChildren()
                .get(0)
                .getBoundsInParent()
                .getMinY();

        double hypotenuse = Math.sqrt(Math.pow(burgerHeight, 2) + Math.pow(burgerWidth, 2));
        double angle = (Math.toDegrees(Math.asin(burgerWidth / hypotenuse)) - 100) * -1;
        return new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        new KeyValue(burger.rotateProperty(), 0, Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(0).rotateProperty(), 0, Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(0).translateYProperty(), 0, Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(2).rotateProperty(), 0, Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(2).translateYProperty(), 0, Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(1).opacityProperty(), 1, Interpolator.EASE_BOTH)
                ),
                new KeyFrame(Duration.millis(1000),
                        new KeyValue(burger.rotateProperty(), 0, Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(0).rotateProperty(), angle, Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(0).translateYProperty(),
                                (burgerHeight / 2) - burger.getChildren()
                                        .get(0)
                                        .getBoundsInLocal()
                                        .getHeight() / 2,
                                Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(2).rotateProperty(), -angle, Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(2).translateYProperty(),
                                -((burgerHeight / 2) - burger.getChildren()
                                        .get(0)
                                        .getBoundsInLocal()
                                        .getHeight() / 2),
                                Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(1).opacityProperty(), 0, Interpolator.EASE_BOTH)
                )
        );
    }


}

