package App.GUI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Gui extends Application {
    public void start(Stage stage) throws Exception {

        stage.setTitle("Avans new");

        TextField search = new TextField();
        TextField email = new TextField();
        TextField password = new TextField();

        email.setPrefWidth(350);
        password.setPrefWidth(350);
        search.setPrefWidth(350);

        Label label1 = new Label("Email");
        Label label2 = new Label("Password");
        
        Button signIn = new Button("Sign in");
        Button signUp = new Button("Sign up");

        signIn.setMaxWidth(100);
        signUp.setMaxWidth(100);

        BorderPane labelEmail = new BorderPane(null, null, null, null, label1);
        BorderPane labelPassword = new BorderPane(null, null, null, null, label2);
        BorderPane inputEmail = new BorderPane(null, null, email, null, null);
        BorderPane inputPassword = new BorderPane(null, null, password, null, null);
        BorderPane searchbox = new BorderPane(null, null, search, null, null);

        HBox buttonPane = new HBox(signIn, signUp);
        VBox totalPane = new VBox(labelEmail, inputEmail, labelPassword, inputPassword, buttonPane);


        BorderPane.setMargin(label1, new Insets(4, 10, 0, 0));
        BorderPane.setMargin(label2, new Insets(4, 10, 0, 0));
//        BorderPane.setMargin(label3, new Insets(4, 10, 0, 0));

        buttonPane.setSpacing(10);
        totalPane.setSpacing(10);
        totalPane.setPadding(new Insets(250));


        // FileInputStream inputstream = new FileInputStream("https://brightspace.avans.nl/d2l/lp/navbars/6606/theme/viewimage/191/view?v=20.22.11.18610"); 
        // Image image = new Image(inputstream); 

        // ImageView imageView = new ImageView(image);
        // Group root = new Group(imageView);
        // Scene scene = new Scene(root, 600, 500);
        // stage.setScene(scene);

        Scene mainview = new Scene(totalPane);
        stage.setScene(mainview);
        stage.show();
    }
}
