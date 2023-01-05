package App.GUI;

import java.io.IOException;

import App.DatabaseController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FxmlController {
    DatabaseController controller = new DatabaseController();
    Gui gui = new Gui();

    public FxmlController() {

    }

    @FXML
    private Button studentContinue;
    @FXML
    private Button adminContinue;

    public void continueToStudentPage() throws IOException {
        gui.changeScene("FxmlFiles/StudentLoginPage.fxml");
    }

    public void continueToAdminPage() throws IOException {
        gui.changeScene("FxmlFiles/AdminLoginPage.fxml");
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

    public void checkLogin(String userType) throws IOException {
        String signInValuePassword = controller.checkSQLPassword(email.getText(), password.getText(), userType);
        if (signInValuePassword == null) {
            error.setText("Login Failed");
        } else if (!signInValuePassword.isEmpty()) {
            error.setText("Login Complete!");
            gui.changeScene("FxmlFiles/afterLogin.fxml");
        } else {
            error.setText("Login Failed");
        }
    }

    public void checkAdminLogin() throws IOException {
        checkLogin("Admins");
    }

    public void checkStudentLogin() throws IOException {
        checkLogin("Students");
    }

    public void signUp(String userType) throws IOException {
        String signUpSQL = "INSERT INTO " + userType + " VALUES ('" + email.getText() + "', '" + password.getText()
                + "');";
        String signUpSQLTakenValue = controller.checkSQLEmail(email.getText(), userType);
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

    public void adminSignUp() throws IOException {
        signUp("Admins");
    }

    public void studentSignUp() throws IOException {
        signUp("Students");
    }
}
