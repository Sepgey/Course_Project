package com.company.FX;

import com.company.Client;
import com.company.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.io.IOException;

public class ChangePersonalDataScreenController {
    public Button ChangeButton;
    public TextField textFieldName;
    public TextField textFieldLogin;
    public TextField textFieldPassword;

    public void preload() {
        textFieldName.setText(Client.activeClient.getName());
        textFieldLogin.setText(Client.activeClient.getLogin());
        textFieldPassword.setText(Client.activeClient.getPassword());
    }

    public void clickChangeButton(ActionEvent actionEvent) {

        String name = textFieldName.getText();
        String login = textFieldLogin.getText();
        String password = textFieldPassword.getText();

        if (name.trim().length() == 0 || login.trim().length() == 0 || password.trim().length() == 0) {
            //TODO: Alert
            return;
        }

        Client.activeClient.setName(name);
        Client.activeClient.setLogin(login);
        Client.activeClient.setPassword(password);

        Database.updateClient(Client.activeClient);

        try {
            Parent parent = FXMLLoader.load(getClass().getResource("MenuScreen.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        } catch (IOException s) {
            s.printStackTrace();
        }
    }
}
