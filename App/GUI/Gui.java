package App.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Gui extends Application {
    public static void start(Stage stage) throws Exception {

        Scene mainview = new Scene(totalPane);
        stage.setScene(mainview);
        stage.show();
    }
}
