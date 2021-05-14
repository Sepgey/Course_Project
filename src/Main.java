import com.company.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        Database.connect();
        Application.launch(args);
    }

    @Override
    public void stop() throws Exception {
        Database.close();
        super.stop();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent load = FXMLLoader.load(getClass().getResource("com/company/FX/EnterScreen.fxml"));
        stage.setScene(new Scene(load));
        stage.show();
    }
}
