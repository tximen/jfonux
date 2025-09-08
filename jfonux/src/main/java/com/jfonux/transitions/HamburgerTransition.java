package com.jfonux.transitions;


import com.jfonux.controls.JFXHamburger;
import javafx.animation.Transition;

/**
 * Transition builder interface of {@link JFXHamburger}
 *
 * @author Shadi Shaheen
 * @version 1.0
 * @since 2016-03-09
 */
public interface HamburgerTransition {

    /**
     * build a transition to animate the hamburger node
     *
     * @param burger the node to be animated
     * @return animation transition
     */
    Transition getAnimation(JFXHamburger burger);
}

