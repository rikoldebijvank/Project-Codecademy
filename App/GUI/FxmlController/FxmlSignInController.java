package App.GUI;

import java.io.IOException;
import java.time.LocalDate;

import App.DatabaseController;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FxmlSignInController {
    private DatabaseController controller = new DatabaseController();
    private Gui gui = new Gui();

    public void continueToStudentLogin() throws IOException {
        gui.changeScene("FxmlFiles/studentLoginPage.fxml");
    }

    public void continueToStudentRegistration() throws IOException {
        gui.changeScene("FxmlFiles/studentRegistration.fxml");
    }

    public void continueToAdminLogin() throws IOException {
        gui.changeScene("FxmlFiles/adminLoginPage.fxml");
    }

    public void continueToAdminRegistration() throws IOException {
        gui.changeScene("FxmlFiles/adminRegistration.fxml");
    }

    @FXML
    private TextField studentName;
    @FXML
    private TextField studentEmail;
    @FXML
    private PasswordField studentPassword;
    @FXML
    private DatePicker studentDateOfBirth;
    @FXML
    private TextField studentAddress;
    @FXML
    private TextField studentResidence;
    @FXML
    private TextField studentCountry;
    @FXML
    private TextField studentGender;
    @FXML
    private TextField adminEmail;
    @FXML
    private PasswordField adminPassword;
    @FXML
    private Label studentLoginError;
    @FXML
    private Label adminLoginError;
    @FXML
    private TextField studentLoginEmail;
    @FXML
    private PasswordField studentLoginPassword;
    @FXML
    private TextField adminLoginEmail;
    @FXML
    private PasswordField adminLoginPassword;
    @FXML
    private Label studentSignUpError;
    @FXML
    private Label adminSignUpError;

    public void checkLogin(String userType) throws IOException {
        if (userType.equals("Students")) {
            String signInValuePassword = controller.checkSQLPassword(studentLoginEmail.getText(),
                    studentLoginPassword.getText(), userType);
            if (signInValuePassword == null) {
                studentLoginError.setText("Login Failed");
            } else if (!signInValuePassword.isEmpty()) {
                studentLoginError.setText("Login Complete!");
            } else {
                studentLoginError.setText("Login Failed");
            }
        }
        if (userType.equals("Admins")) {
            String signInValuePassword = controller.checkSQLPassword(adminLoginEmail.getText(),
                    adminLoginPassword.getText(), userType);
            if (signInValuePassword == null) {
                adminLoginError.setText("Login Failed");
            } else if (!signInValuePassword.isEmpty()) {
                adminLoginError.setText("Login Complete!");
            } else {
                adminLoginError.setText("Login Failed");
            }
        }
    }

    public void checkAdminLogin() throws IOException {
        checkLogin("Admins");
    }

    public void checkStudentLogin() throws IOException {
        checkLogin("Students");
    }

    public void signUp(String userType) throws IOException {
        if (userType.equals("Students")) {
            String signUpSQLTakenValue = controller.checkSQLEmail(studentEmail.getText(), "Students");
            if (studentName.getText().equals("") || studentEmail.getText().equals("")
                    || studentPassword.getText().equals("") || studentDateOfBirth.getValue().equals("")
                    || studentAddress.getText().equals("") || studentResidence.getText().equals("")
                    || studentCountry.getText().equals("") || studentGender.getText().equals("")) {
                studentSignUpError.setText("Please fill out the form");
            } else if (!studentEmail.getText().contains("@") || !studentEmail.getText().contains(".")) {
                studentSignUpError.setText("Incorrect email format");
            } else if (studentDateOfBirth.getValue().isAfter(LocalDate.now())) {
                studentSignUpError.setText("Birth date has to be in the past");
            } else if (studentPassword.getText().length() < 8) {
                studentSignUpError.setText("Password has to be greater than 8 characters");
            } else if (!studentGender.getText().equals("Male") && !studentGender.getText().equals("Female")) {
                studentSignUpError.setText("Gender has to be either 'Male' or 'Female'");
            } else if (signUpSQLTakenValue == null) {
                controller.createStudent(studentName.getText(), studentEmail.getText(), studentPassword.getText(),
                        studentDateOfBirth.getValue(), studentAddress.getText(), studentResidence.getText(),
                        studentCountry.getText(), studentGender.getText());
                studentSignUpError.setText("Sign up complete!");
            } else if (signUpSQLTakenValue.equals(studentEmail.getText())) {
                studentSignUpError.setText("Email taken");
            } else {
                studentSignUpError.setText("Error");
            }
        }
        if (userType.equals("Admins")) {
            String signUpSQLTakenValue = controller.checkSQLEmail(adminEmail.getText(), "Admins");
            if (adminEmail.getText().equals("") || adminEmail.getText().equals("")) {
                adminSignUpError.setText("Please fill out the form");
            } else if (!adminEmail.getText().contains("@") || !adminEmail.getText().contains(".")) {
                adminSignUpError.setText("Incorrect email format");
            } else if (adminPassword.getText().length() < 8) {
                adminSignUpError.setText("Password has to be greater than 8 characters");
            } else if (signUpSQLTakenValue == null) {
                controller.createAdmin(adminEmail.getText(), adminPassword.getText());
                adminSignUpError.setText("Sign up complete!");
            } else if (signUpSQLTakenValue.equals(adminEmail.getText())) {
                adminSignUpError.setText("Email taken");
            } else {
                adminSignUpError.setText("Error");
            }
        }
    }

    public void adminSignUp() throws IOException {
        signUp("Admins");
    }

    public void studentSignUp() throws IOException {
        signUp("Students");
    }

}
