package com.jfonux.controls;


import com.jfx4test.framework.api.FxRobot;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import com.jfx4test.framework.junit.ApplicationTest;
import com.jfx4test.framework.junit.Start;
import org.junit.jupiter.api.Test;


@ApplicationTest(delayInSeconds =10)
public class JFXButtonTest {

    @Start
    void onStart(Stage stage) {
        FlowPane main = new FlowPane();
        main.setVgap(20);
        main.setHgap(20);

        main.getChildren().add(new Button("Java Button"));
        JFXButton jfoenixButton = new JFXButton("JFoenix Button");
        main.getChildren().add(jfoenixButton);

        JFXButton button = new JFXButton("RAISED BUTTON");
        button.getStyleClass().add("button-raised");
        main.getChildren().add(button);

        JFXButton button1 = new JFXButton("DISABLED");
        button1.setDisable(true);
        main.getChildren().add(button1);

        StackPane pane = new StackPane();
        pane.getChildren().add(main);
        StackPane.setMargin(main, new Insets(100));
        pane.setStyle("-fx-background-color:WHITE");

        final Scene scene = new Scene(pane, 800, 200);
        scene.getStylesheets().add(JFXButtonTest.class.getResource("/css/jfoenix-components.css").toExternalForm());
        stage.setTitle("JFX Button Demo");
        stage.setScene(scene);
        stage.show();

    }

    @Test
    void click_button(FxRobot robot) {

    }
}
