package App.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Gui extends Application {
    public static void start(Stage stage) throws Exception {

        stage.setTitle("Avans New");

        Scene mainview = new Scene();
        stage.setScene(mainview);
        stage.show();
    }
}
