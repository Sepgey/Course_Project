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

public class MagicScreenController {
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

    public void loadMagic() {
        List<Character> characters = Database.selectCharactersByClass("Magic");

        TableColumn<Object, Object> classColumn = new TableColumn<>("Class");
        classColumn.setCellValueFactory(new PropertyValueFactory<>("_class"));

        TableColumn<Object, Object> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Object, Object> mnRegenerationColumn = new TableColumn<>("MN Regeneration (%)");
        mnRegenerationColumn.setCellValueFactory(new PropertyValueFactory<>("feature"));

        tableViewCharacters.getColumns().addAll(classColumn, nameColumn, mnRegenerationColumn);


        for (int i = 0; i < characters.size(); i++) {
            tableViewCharacters.getItems().add(characters.get(i));
        }
    }
}
