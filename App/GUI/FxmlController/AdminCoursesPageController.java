package App.GUI.FxmlController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import App.CourseMaterial.Course;
import App.CourseMaterial.Difficulty;
import App.GUI.Gui;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminCoursesPageController implements Initializable {
    Gui gui = new Gui();

    public void continueToAdminCoursesPage() throws IOException {
        gui.changeScene("./FxmlFiles/adminCoursesPage.fxml");
    }

    public void continueToAdminStudentPage() throws IOException {
        gui.changeScene("./FxmlFiles/adminStudentPage.fxml");
    }

    public void backToAdminHomePage() throws IOException {
        gui.changeScene("./FxmlFiles/adminHomePage.fxml");
    }

    public void continueToAddCoursePage() throws IOException {
        gui.changeScene("./FxmlFiles/addCourse.fxml");
    }

    public void continueToAdminStatistics() throws IOException {
        gui.changeScene("./FxmlFiles/adminStatistics.fxml");
    }

    @FXML
    private TableView<Course> adminCoursesTable;
    @FXML
    private TableColumn<Course, String> adminCoursesCourseName;
    @FXML
    private TableColumn<Course, String> adminCoursesSubject;
    @FXML
    private TableColumn<Course, Difficulty> adminCoursesDifficulty;
    @FXML
    private TableColumn<Course, Integer> adminCoursesStudentsFinished;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        adminCoursesCourseName
                .setCellValueFactory(new PropertyValueFactory<Course, String>("courseName"));
        adminCoursesSubject
                .setCellValueFactory(new PropertyValueFactory<Course, String>("subject"));
        adminCoursesDifficulty
                .setCellValueFactory(new PropertyValueFactory<Course, Difficulty>("difficulty"));
        adminCoursesStudentsFinished
                .setCellValueFactory(new PropertyValueFactory<Course, Integer>("studentsFinished"));

        adminCoursesTable.setItems(getData());
    }

    public ObservableList<Course> getData() {
        ObservableList<Course> data = FXCollections.observableArrayList();
        data.add(new Course("Math", "Math", Difficulty.ADVANCED, 457));
        return data;
    }
}
