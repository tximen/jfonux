package com.jfonux.controls;


import com.jfonux.transitions.CachedTransition;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.util.Duration;

import java.util.function.Function;

/**
 * Transition builder interface of {@link JFXHamburger}
 *
 * @author Shadi Shaheen
 * @version 1.0
 * @since 2016-03-09
 */
public abstract class HamburgerTransition extends CachedTransition {

    public HamburgerTransition(JFXHamburger burger, Function<JFXHamburger, Timeline> timelineFunction) {
        super (burger, timelineFunction.apply(burger));
        timeline.bind(Bindings.createObjectBinding(() -> timelineFunction.apply(burger),
                burger.widthProperty(),
                burger.heightProperty(),
                ((Region) burger.getChildren().getFirst()).widthProperty(),
                ((Region) burger.getChildren().getFirst()).heightProperty()));
        // reduce the number to increase the shifting , increase number to reduce shifting
        setCycleDuration(Duration.seconds(0.3));
        setDelay(Duration.seconds(0));

    }

    public void createRateEvent(MouseEvent event) {
        setRate(getRate() * -1);
        play();
    }

}

