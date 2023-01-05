package App.GUI;

import java.io.IOException;

import App.DatabaseController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FxmlController {
    DatabaseController controller = new DatabaseController();

    public FxmlController() {

    }

    @FXML
    private Button loginButton;
    @FXML
    private Button signUpButton;
    @FXML
    private Label error;
    @FXML
    private TextField email;
    @FXML
    private TextField password;

    public void checkLogin() throws IOException {
        Gui m = new Gui();
        String signInValuePassword = controller.checkSQLPassword(email.getText(), password.getText());
        if (signInValuePassword == null) {
            error.setText("Login Failed");
        } else if (!signInValuePassword.isEmpty()) {
            error.setText("Login Complete!");
            m.changeScene("FxmlFiles/afterLogin.fxml");
        } else {
            error.setText("Login Failed");
        }
    }

    public void signUp() throws IOException {
        String signUpSQL = "INSERT INTO Users VALUES ('" + email.getText() + "', '" + password.getText() + "');";
        String signUpSQLTakenValue = controller.checkSQLEmail(email.getText());
        if (email.getText().equals("") || password.getText().equals("")) {
            error.setText("Please fill out the form");
        } else if (!email.getText().contains("@") || !email.getText().contains(".")) {
            error.setText("Incorrect Format");
        } else if (password.getText().length() < 8) {
            error.setText("Password has to be greater than 8 characters");
        } else if (signUpSQLTakenValue == null) {
            controller.executeSQL(signUpSQL);
            error.setText("Sign Up Complete!");
        } else if (signUpSQLTakenValue.equals(email.getText())) {
            error.setText("Email taken");
        } else {
            error.setText("Error");
        }
    }
}
