package com.jfonux.controls;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HamburgController implements Initializable {

    @FXML
    private VBox navigationBox;
    @FXML
    private JFXHamburger titleBurger;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        navigationBox.visibleProperty().bind(this.titleBurger.selectedProperty());
    }


}
