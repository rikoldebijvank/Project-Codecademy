package App.GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import App.DatabaseController;

public class Gui extends Application {
    public void start(Stage stage) throws Exception {
        DatabaseController controller = new DatabaseController();

        stage.setTitle("Avans Dash");

        Text message = new Text();
        TextField search = new TextField();
        TextField email = new TextField();
        TextField password = new TextField();

        email.setPrefWidth(350);
        password.setPrefWidth(350);
        search.setPrefWidth(350);

        Label label1 = new Label("Email");
        Label label2 = new Label("Password");

        Button signIn = new Button("Sign in");
        signIn.setOnAction((event) -> {
            String signInValuePassword = controller.checkSQLPassword(email.getText(), password.getText());
            if (signInValuePassword == null) {
                message.setText("Login Failed");
            } else if (!signInValuePassword.isEmpty()) {
                message.setText("Login Complete!");
            } else {
                message.setText("Login Failed");
            }
        });

        Button signUp = new Button("Sign up");
        signUp.setOnAction((event2) -> {
            String signUpSQL = "INSERT INTO Users VALUES ('" + email.getText() + "', '" + password.getText() + "');";
            String signUpSQLTakenValue = controller.checkSQLEmail(email.getText());
            if (email.getText().equals("") || password.getText().equals("")) {
                message.setText("Please fill out the form");
            } else if (!email.getText().contains("@")
                    || !email.getText().contains(".")) {
                message.setText("Incorrect Format");
            } else if (password.getText().length() < 8) {
                message.setText("Password has to be greater than 8 characters");
            } else if (signUpSQLTakenValue == null) {
                controller.executeSQL(signUpSQL);
                message.setText("Sign Up Complete!");
            } else if (signUpSQLTakenValue.equals(email.getText())) {
                message.setText("Email taken");
            } else {
                message.setText("Error");
            }
        });

        signIn.setMaxWidth(100);
        signUp.setMaxWidth(100);

        BorderPane signUpCompleteText = new BorderPane(message);
        BorderPane labelEmail = new BorderPane(null, null, null, null, label1);
        BorderPane labelPassword = new BorderPane(null, null, null, null, label2);
        BorderPane inputEmail = new BorderPane(null, null, email, null, null);
        BorderPane inputPassword = new BorderPane(null, null, password, null, null);
        BorderPane searchbox = new BorderPane(null, null, search, null, null);

        HBox buttonPane = new HBox(signIn, signUp);
        VBox totalPane = new VBox(signUpCompleteText, labelEmail, inputEmail, labelPassword, inputPassword, buttonPane);

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