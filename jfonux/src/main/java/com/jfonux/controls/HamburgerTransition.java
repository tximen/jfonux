package com.jfonux.controls;


import com.jfonux.transitions.CachedTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

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

