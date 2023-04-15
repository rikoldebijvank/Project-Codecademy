package app.logic.fxmlcontroller;

import java.time.LocalDate;

import app.database.DatabaseController;
import app.presentation.Gui;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddNewRegistrationController {
    
    DatabaseController controller = new DatabaseController();
    Gui gui = new Gui();
    
    @FXML
    private TextField courseNameTextField;
    @FXML
    private TextField studentEmailTextField;
    @FXML
    private Button addNewRegistrationBtn;
    private LocalDate currentDate;

    public void addNewRegistration() throws Exception{
        String courseName = courseNameTextField.getText().toString();
        String studentEmail = studentEmailTextField.getText().toString();
        currentDate = LocalDate.now();
        
        controller.executeSQL("INSERT INTO Registration (CourseName, StudentEmail, Date) VALUES ( '" + courseName + "', '" + studentEmail + "', '" + currentDate + "')");
        courseNameTextField.clear();
        studentEmailTextField.clear();
        gui.changeScene("../presentation/fxmlfiles/RegistrationPerCourse.fxml");


    }
    
}
