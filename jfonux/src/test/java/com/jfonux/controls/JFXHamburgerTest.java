package com.jfonux.controls;

import com.jfonux.transitions.HamburgerNextArrowBasicTransition;
import com.jfx4test.framework.junit.ApplicationTest;
import com.jfx4test.framework.junit.Start;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import com.jfonux.transitions.HamburgerSlideCloseTransition;
import com.jfonux.transitions.HamburgerBasicCloseTransition;
import com.jfonux.transitions.HamburgerBackArrowBasicTransition;

import org.junit.jupiter.api.Test;


@ApplicationTest(delayInSeconds = 20)
public class JFXHamburgerTest {

    @Start
    void onStart(Stage stage) {
        FlowPane main = new FlowPane();
        main.setVgap(20);
        main.setHgap(20);

        JFXHamburger h1 = new JFXHamburger();
        HamburgerSlideCloseTransition burgerTask = new HamburgerSlideCloseTransition(h1);
        burgerTask.setRate(-1);
        h1.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
            burgerTask.setRate(burgerTask.getRate() * -1);
            burgerTask.play();
        });

        JFXHamburger h2 = new JFXHamburger();
        HamburgerBasicCloseTransition burgerTask1 = new HamburgerBasicCloseTransition(h2);
        burgerTask1.setRate(-1);
        h2.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
            burgerTask1.setRate(burgerTask1.getRate() * -1);
            burgerTask1.play();
        });

        JFXHamburger h3 = new JFXHamburger();
        HamburgerBackArrowBasicTransition burgerTask2 = new HamburgerBackArrowBasicTransition(h3);
        burgerTask2.setRate(-1);
        h3.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
            burgerTask2.setRate(burgerTask2.getRate() * -1);
            burgerTask2.play();
        });

        JFXHamburger h4 = new JFXHamburger();
        HamburgerNextArrowBasicTransition burgerTask3 = new HamburgerNextArrowBasicTransition(h4);
        burgerTask3.setRate(-1);
        h4.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
            burgerTask3.setRate(burgerTask3.getRate() * -1);
            burgerTask3.play();
        });


        main.getChildren().add(h1);
        main.getChildren().add(h2);
        main.getChildren().add(h3);
        main.getChildren().add(h4);

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
    void hamburger() {

    }
}
