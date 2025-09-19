package com.jfonux.controls;

import com.jfx4test.framework.api.FxRobot;
import com.jfx4test.framework.junit.ApplicationTest;
import com.jfx4test.framework.junit.FxAssertions;
import org.junit.jupiter.api.Test;

import static com.jfx4test.framework.util.WaitForAsyncUtils.sleepSeconds;

@ApplicationTest(value="fxml/hamburgerView.fxml", delayInSeconds = 2)
public class HamburgerViewTest {

    @Test
    void click_hamburger(FxRobot robot) {
        sleepSeconds(4);
        FxAssertions.assertNotVisiblyById("navigationBox");
        robot.clickById("titleBurger" );
        sleepSeconds(4);
        FxAssertions.assertVisiblyById("navigationBox");
        robot.clickById("titleBurger" );
        FxAssertions.assertNotVisiblyById("navigationBox");
    }
}
