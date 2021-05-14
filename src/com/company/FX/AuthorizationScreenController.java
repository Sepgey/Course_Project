package com.company.FX;

import com.company.Client;
import com.company.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.io.IOException;

public class AuthorizationScreenController {
    public TextField textFieldLogin;
    public PasswordField passwordFieldPassword;
    public Button buttonAuthorization;

    public void onButtonAuthorizationClick(ActionEvent actionEvent) {
        performLogin(actionEvent.getSource());
    }

    public void performLogin(Object source) {
        String login = textFieldLogin.getText();
        String password = passwordFieldPassword.getText();
        if (login.trim().length() == 0 || password.trim().length() == 0) {
            //TODO: ALERT
            textFieldLogin.clear();
            passwordFieldPassword.clear();
            return;
        }

        Client client = Database.selectClientByLoginAndPassword(login, password);
        if (client == null) {
            //TODO: LOGIN FAIL
            textFieldLogin.clear();
            passwordFieldPassword.clear();
            return;
        } else {
            Client.activeClient = client;
        }

        try {
            Parent parent = FXMLLoader.load(getClass().getResource("MenuScreen.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            ((Node) source).getScene().getWindow().hide();
        } catch (IOException s) {
            s.printStackTrace();
        }
    }

    public void onPasswordFieldKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            performLogin(keyEvent.getSource());
        }
    }
}
