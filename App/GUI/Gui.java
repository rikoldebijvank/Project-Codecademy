package App.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Gui extends Application {
    private static Stage stg;

    @Override
    public void start(Stage stage) throws Exception {
        stg = stage;
        stage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("FxmlFiles/StartingPage.fxml"));
        stage.setTitle("Avans Dash");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }
}