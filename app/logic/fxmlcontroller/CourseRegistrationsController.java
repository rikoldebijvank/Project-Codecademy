package app.logic.fxmlcontroller;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import app.database.DatabaseController;
import app.database.RegistrationsDAO;
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
    private RegistrationsDAO dao = new RegistrationsDAO();

    @FXML
    private TableView<Student> registrationsPerCourse;
    @FXML
    private TableColumn<Student, String> studentNames;
    @FXML
    private TableColumn<Student, Button> removeRegistrationStudentBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentNames.setCellValueFactory(new PropertyValueFactory<Student, String>("Name"));
        removeRegistrationStudentBtn.setCellValueFactory(new PropertyValueFactory<Student, Button>("removeStudentButton"));
        registrationsPerCourse.setItems(dao.getData());
        
    }
}
