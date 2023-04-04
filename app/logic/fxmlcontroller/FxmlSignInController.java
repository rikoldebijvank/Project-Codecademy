package app.logic.fxmlcontroller;

import java.io.IOException;
import java.time.LocalDate;

import app.database.DatabaseController;
import app.presentation.Gui;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FxmlSignInController {
    private DatabaseController controller = new DatabaseController();
    private Gui gui = new Gui();
    String adminEmailLoggedIn;

    // functie aan buttons geven (in signInPage en signUpPage)
    // om tussen alle pagina's (scenes) te kunnen bewegen
    public void continueToStudentLogin() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/studentLoginPage.fxml");
    }

    public void continueToStudentRegistration() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/studentRegistration.fxml");
    }

    public void continueToAdminLogin() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/adminLoginPage.fxml");
    }

    public void continueToAdminRegistration() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/adminRegistration.fxml");
    }

    public void backToFrontPage() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/startingPage.fxml");
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
    private TextField studentPostalCode;
    @FXML
    private TextField studentCountry;
    @FXML
    private TextField studentGender;
    @FXML
    private TextField adminName;
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

    // checken van ingevoerde inloggegevens om users toe te laten
    public void checkLogin(String userType) throws IOException {
        if (userType.equals("Students")) {
            String signInValuePassword = controller.checkSQLPassword(studentLoginEmail.getText(),
                    studentLoginPassword.getText(), userType);
            if (signInValuePassword == null) {
                studentLoginError.setText("Login Failed");
            } else if (!signInValuePassword.isEmpty()) {
                studentLoginError.setText("Login Complete!");
                gui.changeScene("../presentation/fxmlfiles/studentHomePage.fxml");
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
                gui.changeScene("../presentation/fxmlfiles/adminHomePage.fxml");
            } else {
                adminLoginError.setText("Login Failed");
            }
        }
    }

    // roepen van checkLogin methode voor inloggen van de admins
    public void checkAdminLogin() throws IOException {
        checkLogin("Admins");
    }

    // roepen van checkLogin methode voor inloggen van de studenten
    public void checkStudentLogin() throws IOException {
        checkLogin("Students");
    }

    // checken van ingevorde gegevens of ze aan de eisen voedoen en dan een nieuwe
    // account maken
    public void signUp(String userType) throws IOException {
        if (userType.equals("Students")) {
            String signUpSQLTakenValue = controller.checkSQLEmail(studentEmail.getText(), "Students");

            if (studentName.getText().equals("") || studentEmail.getText().equals("")
                    || studentPassword.getText().equals("") || studentDateOfBirth.getValue().equals("")
                    || studentAddress.getText().equals("") || studentPostalCode.getText().equals("")
                    || studentCountry.getText().equals("") || studentGender.getText().equals("")) {
                studentSignUpError.setText("Please fill out the form");

            } else if (!studentEmail.getText().contains("@") || !studentEmail.getText().contains(".")
                    || !(studentEmail.getText().charAt(0) >= 'a') || !(studentEmail.getText().charAt(0) <= 'z')
                    || !(studentEmail.getText().charAt(studentEmail.getText().indexOf("@") + 1) >= 'a')
                    || !(studentEmail.getText().charAt(studentEmail.getText().indexOf("@") + 1) <= 'z')
                    || (studentEmail.getText().endsWith("."))) {
                studentSignUpError.setText("Incorrect email format");

            } else if (studentDateOfBirth.getValue().isAfter(LocalDate.now())) {
                studentSignUpError.setText("Birth date has to be in the past");

            } else if (studentPassword.getText().length() < 8) {
                studentSignUpError.setText("Password has to be greater than 8 characters");

            } else if (!studentGender.getText().equals("Male") && !studentGender.getText().equals("Female")) {
                studentSignUpError.setText("Gender has to be either 'Male' or 'Female'");

            } else if (!(studentPostalCode.getText().charAt(0) > '0') || !(studentPostalCode.getText().charAt(0) <= '9')
                    || !(studentPostalCode.getText().charAt(1) >= '0')
                    || !(studentPostalCode.getText().charAt(1) <= '9')
                    || !(studentPostalCode.getText().charAt(2) >= '0')
                    || !(studentPostalCode.getText().charAt(2) <= '9')
                    || !(studentPostalCode.getText().charAt(3) >= '0')
                    || !(studentPostalCode.getText().charAt(3) <= '9')
                    || !(studentPostalCode.getText().charAt(4) == ' ')
                    || !(studentPostalCode.getText().charAt(5) >= 'A')
                    || !(studentPostalCode.getText().charAt(5) <= 'Z')
                    || !(studentPostalCode.getText().charAt(6) >= 'A')
                    || !(studentPostalCode.getText().charAt(6) <= 'Z')) {
                studentSignUpError.setText("Incorrect Postal Code Format");

            } else if (signUpSQLTakenValue == null) {
                controller.createStudent(studentName.getText(), studentEmail.getText(), studentPassword.getText(),
                        studentDateOfBirth.getValue(), studentAddress.getText(), studentPostalCode.getText(),
                        studentCountry.getText(), studentGender.getText());
                studentSignUpError.setText("Sign up complete!");
                gui.changeScene("../presentation/fxmlfiles/studentHomePage.fxml");
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
            } else if (!adminEmail.getText().contains("@") || !adminEmail.getText().contains(".")
                    || !(adminEmail.getText().charAt(0) >= 'a') || !(adminEmail.getText().charAt(0) <= 'z')
                    || !(adminEmail.getText().charAt(adminEmail.getText().indexOf("@") + 1) >= 'a')
                    || !(adminEmail.getText().charAt(adminEmail.getText().indexOf("@") + 1) <= 'z')
                    || (adminEmail.getText().endsWith("."))) {
                adminSignUpError.setText("Incorrect email format");
            } else if (adminPassword.getText().length() < 8) {
                adminSignUpError.setText("Password has to be greater than 8 characters");
            } else if (signUpSQLTakenValue == null) {
                controller.createAdmin(adminName.getText(), adminEmail.getText(), adminPassword.getText());
                adminSignUpError.setText("Sign up complete!");
                gui.changeScene("../presentation/fxmlfiles/adminHomePage.fxml");
            } else if (signUpSQLTakenValue.equals(adminEmail.getText())) {
                adminSignUpError.setText("Email taken");
            } else {
                adminSignUpError.setText("Error");
            }
        }
    }

    // roepen van signUp methode voor aanmelden van admins
    public void adminSignUp() throws IOException {
        signUp("Admins");
    }

    // roepen van signUp methode voor aanmelden van studenten
    public void studentSignUp() throws IOException {
        signUp("Students");
    }

}
