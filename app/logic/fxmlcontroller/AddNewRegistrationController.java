package app.logic.fxmlcontroller;

import java.time.LocalDate;

import app.domain.Registration;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddNewRegistrationController {
    
    @FXML
    private TextField courseNameTextField;
    @FXML
    private TextField studentEmailTextField;
    @FXML
    private Button addNewRegistrationBtn;
    private LocalDate currentDate;

    public void addNewRegistration() {
        String courseName = courseNameTextField.getText().toString();
        String studentEmail = studentEmailTextField.getText().toString();
        currentDate = LocalDate.now();
        // Registration newReg = new Registration(courseName, studentEmail, currentDate);

    }
    
}
