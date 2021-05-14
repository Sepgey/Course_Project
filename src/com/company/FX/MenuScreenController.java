package com.company.FX;

import com.company.Client;
import com.company.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuScreenController {

    public Button buttonDeleteAccount;
    public Button buttonChangeData;


    public void onAllHeroesClick(javafx.event.ActionEvent actionEvent) {
        Parent parent = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("HeroesScreen.fxml"));
            loader.load();
            HeroesScreenController screenController = loader.getController();
            screenController.loadHeroes();
            parent = loader.getRoot();
        } catch (IOException s) {
            s.printStackTrace();
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

    public void onStrengthClick(javafx.event.ActionEvent actionEvent) {
        Parent parent = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("StrengthScreen.fxml"));
            loader.load();
            StrengthScreenController screenController = loader.getController();
            screenController.loadStrength();
            parent = loader.getRoot();
        } catch (IOException s) {
            s.printStackTrace();
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

    public void onAgilityClick(ActionEvent actionEvent) {
        Parent parent = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("AgilityScreen.fxml"));
            loader.load();
            AgilityScreenController screenController = loader.getController();
            screenController.loadAgility();
            parent = loader.getRoot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent);
        Stage s = new Stage();
        s.setScene(scene);
        s.show();
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

    public void onMagicClick(javafx.event.ActionEvent actionEvent) {
        Parent parent = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("MagicScreen.fxml"));
            loader.load();
            MagicScreenController screenController = loader.getController();
            screenController.loadMagic();
            parent = loader.getRoot();
        } catch (IOException s) {
            s.printStackTrace();
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

    public void clickDeleteAccount(ActionEvent actionEvent) {
        Database.deleteClient(Client.activeClient);

        Parent parent = null;
        try {

            parent = FXMLLoader.load(getClass().getResource("EnterScreen.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent);
        Stage s = new Stage();
        s.setScene(scene);
        s.show();
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

    public void clickChangePersonalData(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ChangePersonalDataScreen.fxml"));
            loader.load();

            ChangePersonalDataScreenController controller = loader.getController();
            controller.preload();

            Parent parent = loader.getRoot();
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
