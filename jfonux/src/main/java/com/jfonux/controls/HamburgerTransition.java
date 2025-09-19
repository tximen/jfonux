package com.jfonux.controls;


import com.jfonux.transitions.CachedTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.beans.binding.Bindings;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.util.Duration;

import java.util.concurrent.Callable;
import java.util.function.Function;

/**
 * Transition builder interface of {@link JFXHamburger}
 *
 * @author Shadi Shaheen
 * @version 1.0
 * @since 2016-03-09
 */
public abstract class HamburgerTransition extends CachedTransition {

    public HamburgerTransition() {
    }

    public HamburgerTransition(JFXHamburger burger, Function<JFXHamburger, Timeline> timelineFunction) {
        super (burger, timelineFunction.apply(burger));
        timeline.bind(Bindings.createObjectBinding(() -> timelineFunction.apply(burger),
                burger.widthProperty(),
                burger.heightProperty(),
                ((Region) burger.getChildren().get(0)).widthProperty(),
                ((Region) burger.getChildren().get(0)).heightProperty()));
        // reduce the number to increase the shifting , increase number to reduce shifting
        setCycleDuration(Duration.seconds(0.3));
        setDelay(Duration.seconds(0));

    }

    public HamburgerTransition(final Node node, final Timeline timeline) {
        super (node, timeline);
    }
    /**
     * build a transition to animate the hamburger node
     *
     * @param burger the node to be animated
     * @return animation transition
     */
    public abstract Transition getAnimation(JFXHamburger burger);


    public void createRateEvent(MouseEvent event) {
        setRate(getRate() * -1);
        play();
    }



}

