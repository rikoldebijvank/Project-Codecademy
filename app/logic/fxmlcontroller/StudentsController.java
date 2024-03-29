package app.logic.fxmlcontroller;

import app.database.StudentsDAO;
import app.domain.individuals.Student;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentsController extends Controller implements Initializable {
    private StudentsDAO dao = new StudentsDAO();

    @FXML
    private TableView<Student> studentTableView;
    @FXML
    private TableColumn<Student, String> studentName;
    @FXML
    private TableColumn<Student, String> studentGender;
    @FXML
    private TableColumn<Student, Button> removeStudentButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(dao.getStudents() != null) {
            studentName.setCellValueFactory(new PropertyValueFactory<>("name"));
            studentGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
            removeStudentButton.setCellValueFactory(new PropertyValueFactory<>("removeStudentButton"));
            studentTableView.setItems(dao.getStudents());
        }
    }
}
