package app.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Gui extends Application {
    private static Stage stg;

    // de start methode van grafische user interface
    @Override
    public void start(Stage stage) throws Exception {
        stg = stage;
        stage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("fxmlfiles/LoginPage.fxml"));
        stage.setTitle("Avans Dash - Rik Olde Bijvank (2202811) & Baraa Bayrkdar (student#)");
        stage.setScene(new Scene(root, 696, 493));
        stage.show();
    }

    // om tussen verschillende scene (pagina's van app) te bewegen
    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }
}
