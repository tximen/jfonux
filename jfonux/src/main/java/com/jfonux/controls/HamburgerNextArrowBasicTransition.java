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
public class HamburgerNextArrowBasicTransition extends HamburgerTransition {

    public HamburgerNextArrowBasicTransition(JFXHamburger burger) {
        super(burger, HamburgerNextArrowBasicTransition::createTimeline);
    }

    private static Timeline createTimeline(JFXHamburger burger) {
        double burgerWidth = burger.getChildren().get(0).getLayoutBounds().getWidth();
        double burgerHeight = burger.getChildren().get(2).getBoundsInParent().getMaxY() - burger.getChildren()
                .get(0)
                .getBoundsInParent()
                .getMinY();

        double hypotenuse = Math.sqrt(Math.pow(burgerHeight / 2 - burger.getChildren()
                .get(0)
                .getLayoutBounds()
                .getHeight() / 2, 2) + Math.pow(burgerWidth / 2,
                2));
        double angle = Math.toDegrees(Math.asin((burgerHeight / 2 - burger.getChildren()
                .get(0)
                .getLayoutBounds()
                .getHeight() / 2) / hypotenuse));

        double burgerDiagonal = Math.sqrt(Math.pow(burger.getChildren().get(0).getLayoutBounds().getHeight(),
                2) + Math.pow(burger.getChildren()
                .get(0)
                .getBoundsInParent()
                .getWidth() / 2, 2));
        double theta = (90 - angle) + Math.toDegrees(Math.atan((burger.getChildren()
                .get(0)
                .getLayoutBounds()
                .getHeight()) / (burger.getChildren()
                .get(0)
                .getBoundsInParent()
                .getWidth() / 2)));
        double hOffset = Math.cos(Math.toRadians(theta)) * burgerDiagonal / 2;
        double transY = burger.getChildren().get(0).getLayoutBounds().getHeight() / 2 + burger.getSpacing() - hOffset;
        double transX = burgerWidth / 2 - Math.sin(Math.toRadians(theta)) * (burgerDiagonal / 2);

        return new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        new KeyValue(burger.rotateProperty(), 0, Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(0).rotateProperty(), 0, Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(0).translateYProperty(), 0, Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(0).translateXProperty(), 0, Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(0).scaleXProperty(), 1, Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(2).rotateProperty(), 0, Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(2).translateYProperty(), 0, Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(2).translateXProperty(), 0, Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(2).scaleXProperty(), 1, Interpolator.EASE_BOTH)

                ),
                new KeyFrame(Duration.millis(1000),
                        new KeyValue(burger.rotateProperty(), 0, Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(0).rotateProperty(), angle, Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(0).translateYProperty(), transY, Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(0).translateXProperty(), transX, Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(0).scaleXProperty(), 0.5, Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(2).rotateProperty(), -angle, Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(2).translateYProperty(),
                                -transY,
                                Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(2).translateXProperty(), transX, Interpolator.EASE_BOTH),
                        new KeyValue(burger.getChildren().get(2).scaleXProperty(), 0.5, Interpolator.EASE_BOTH)
                )
        );
    }

}


