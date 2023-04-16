package app.logic.fxmlcontroller;

import app.presentation.Gui;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import java.io.IOException;

public class LoginController extends Controller {
    private Gui gui = new Gui();
    @FXML
    private Label adminLoginError;
    @FXML
    private PasswordField loginPassword;

    public void backToFrontPage() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/startingPage.fxml");
    }

    public void continueToLogin() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/adminLoginPage.fxml");
    }

    public void checkLogin() throws IOException {
        String signInValuePassword = "codecademy";
        if (loginPassword.getText().isEmpty()) {
            adminLoginError.setText("Login Failed");
        } else if (loginPassword.getText().equals(signInValuePassword)) {
            adminLoginError.setText("Login Complete!");
            gui.changeScene("../presentation/fxmlfiles/HomePage.fxml");
        } else {
            adminLoginError.setText("Login Failed");
        }
    }
}
