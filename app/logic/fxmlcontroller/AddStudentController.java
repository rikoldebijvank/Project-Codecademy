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

public class AddStudentController extends Controller {
    private DatabaseController controller = new DatabaseController();
    private Gui gui = new Gui();

    @FXML
    private TextField studentName;
    @FXML
    private TextField studentEmail;
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
    private Label studentSignUpError;

    // checken van ingevorde gegevens of ze aan de eisen voedoen en dan een nieuwe
    // account maken
    public void signUp() throws IOException {
        String signUpSQLTakenValue = controller.checkSQLEmail(studentEmail.getText(), "Students");

        if (studentName.getText().equals("") || studentEmail.getText().equals("")
                || studentDateOfBirth.getValue().equals("")
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

        } else if (!studentGender.getText().equals("M") && !studentGender.getText().equals("F")) {
            studentSignUpError.setText("Gender has to be either 'M' or 'F'");

        } else if (!(studentPostalCode.getText().matches("[1-9][0-9]{3} [A-Z]{2}"))) {
            studentSignUpError.setText("Incorrect Postal Code Format, use the format \"9999 XX\"");
            
        } else if (signUpSQLTakenValue == null) {
            controller.createStudent(studentName.getText(), studentEmail.getText(),
                    studentDateOfBirth.getValue(), studentAddress.getText(), studentPostalCode.getText(),
                    studentCountry.getText(), studentGender.getText());
            studentSignUpError.setText("Sign up complete!");
            gui.changeScene("../presentation/fxmlfiles/Students.fxml");
        } else if (signUpSQLTakenValue.equals(studentEmail.getText())) {
            studentSignUpError.setText("Email taken");
        } else {
            studentSignUpError.setText("Error");
        }
    }

    // roepen van signUp methode voor aanmelden van studenten
    public void studentSignUp() throws IOException {
        signUp();
    }

}
