package com.company.FX;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class EnterScreenController {
    public Button Authorization;
    public Button CreateAccount;


    public void CreateAccountClick(javafx.event.ActionEvent actionEvent) {
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("CreateAccountScreen.fxml"));
        } catch (IOException s) {
            s.printStackTrace();
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

    public void AuthorizationClick(javafx.event.ActionEvent actionEvent) {
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("AuthorizationScreen.fxml"));
        } catch (IOException s) {
            s.printStackTrace();
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }
}
