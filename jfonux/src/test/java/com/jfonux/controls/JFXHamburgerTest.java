package com.jfonux.controls;

import com.jfx4test.framework.api.FxRobot;
import com.jfx4test.framework.junit.ApplicationTest;
import com.jfx4test.framework.junit.Start;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static com.jfx4test.framework.util.WaitForAsyncUtils.sleepSeconds;


@ApplicationTest(delayInSeconds = 2)
public class JFXHamburgerTest {

    @Start
    void onStart(Stage stage) {
        FlowPane main = new FlowPane();
        main.setVgap(20);
        main.setHgap(20);

        for (BurgerMode burgerMode : BurgerMode.values()) {
            main.getChildren().add(new JFXHamburger("hamburger0%d".formatted(1 + burgerMode.ordinal()), burgerMode));
        }

        StackPane pane = new StackPane();
        pane.getChildren().add(main);
        StackPane.setMargin(main, new Insets(60));
        pane.setStyle("-fx-background-color:WHITE");

        final Scene scene = new Scene(pane, 400, 200);
        scene.getStylesheets().add(JFXHamburgerTest.class.getResource("/css/jfoenix-components.css").toExternalForm());
        stage.setTitle("JFX Burgers Demo :) ");
        stage.setScene(scene);
        stage.setResizable(false);

        stage.show();

    }



    @Test
    void click_hamburger(FxRobot robot) {
        for (BurgerMode burgerMode : BurgerMode.values()) {
            String nodeID = "hamburger0%d".formatted(1 + burgerMode.ordinal());
            Logger.getLogger(JFXHamburgerTest.class.getName()).info("click [%s]".formatted(nodeID));
            robot.clickById(nodeID);
            sleepSeconds(2);
            Logger.getLogger(JFXHamburgerTest.class.getName()).info("click [%s]".formatted(nodeID));
            robot.clickById(nodeID);
            sleepSeconds(2);
            Logger.getLogger(JFXHamburgerTest.class.getName()).info("click [%s]".formatted(nodeID));
            robot.clickById(nodeID);
            sleepSeconds(2);
            Logger.getLogger(JFXHamburgerTest.class.getName()).info("click [%s]".formatted(nodeID));
            robot.clickById(nodeID);
        }
    }
}
