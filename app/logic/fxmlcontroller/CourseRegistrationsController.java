package app.logic.fxmlcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import app.database.DatabaseController;
import app.domain.individuals.Student;
import app.presentation.Gui;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CourseRegistrationsController extends Controller implements Initializable{

    DatabaseController controller = new DatabaseController();
    Gui gui = new Gui();

    @FXML
    private TableView<Student> registrationsPerCourse;
    @FXML
    private TableColumn<Student, String> studentNames;
    @FXML
    private TableColumn<Student, Button> removeRegistrationStudentBtn;
    @FXML
    private Button addNewRegistrationBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentNames.setCellValueFactory(new PropertyValueFactory<Student, String>("Name"));
        removeRegistrationStudentBtn.setCellValueFactory(new PropertyValueFactory<Student, Button>("removeRegistrationButton"));
        registrationsPerCourse.setItems(getData());
        
    }


    // get alle benodigde data vanuit de sql
    public ObservableList<Student> getData() {
        ObservableList<Student> data = FXCollections.observableArrayList();
        String studentName = controller.returnSQL("SELECT Name FROM Student " + 
        "JOIN Registration ON Student.Email = Registration.StudentEmail " + 
        "JOIN Course ON Registration.CourseName = Course.CourseName", "Name")
                        .toString();
        String[] studentNames = studentName.split(";");
        ArrayList<Button> studentRegisterationsButtons = new ArrayList<>();
        for (String name : studentNames) {
                Button newButton = new Button("Unenroll");
                newButton.setOnAction((event) -> {
                        try {
                                controller.executeSQL("DELETE FROM Registration WHERE CourseName = " + RegistrationsController.courseName1 + " AND StudentEmail = (SELECT Email FROM Student WHERE Name = " + name);
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                });
                studentRegisterationsButtons.add(newButton);
        }

        for (int i = 0; i < studentNames.length; i++) {
                data.add(new Student(studentNames[i]));
        }
        return data;
    }


}
