package com.company.FX;

import com.company.Character;
import com.company.Database;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class AgilityScreenController {
    public TableView<Object> tableViewCharacters;

    public void ReturnClick(javafx.event.ActionEvent actionEvent) {
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("MenuScreen.fxml"));
        } catch (IOException s) {
            s.printStackTrace();
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

    public void loadAgility() {
        List<Character> characters = Database.selectCharactersByClass("Agility");

        TableColumn<Object, Object> classColumn = new TableColumn<>("Class");
        classColumn.setCellValueFactory(new PropertyValueFactory<>("_class"));

        TableColumn<Object, Object> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Object, Object> evasionColumn = new TableColumn<>("Evasion (%)");
        evasionColumn.setCellValueFactory(new PropertyValueFactory<>("feature"));

        tableViewCharacters.getColumns().addAll(classColumn, nameColumn, evasionColumn);


        for (int i = 0; i < characters.size(); i++) {
            tableViewCharacters.getItems().add(characters.get(i));
        }
    }
}
