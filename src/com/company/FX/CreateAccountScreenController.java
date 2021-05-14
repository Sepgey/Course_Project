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
import javafx.stage.Stage;

import java.io.IOException;

public class CreateAccountScreenController {
    public Button create;
    public TextField textFieldName;
    public TextField textFieldLogin;
    public PasswordField passwordFieldPassword;

    public void CreateClick(ActionEvent actionEvent) {

        String name = textFieldName.getText();
        String login = textFieldLogin.getText();
        String password = passwordFieldPassword.getText();

        if(name.trim().length() == 0 || login.trim().length() == 0 || password.trim().length() == 0)
        {
            //TODO: Alert
            return;
        }

        Client c = new Client(0, name, login, password);

        Database.insertClient(c);

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
