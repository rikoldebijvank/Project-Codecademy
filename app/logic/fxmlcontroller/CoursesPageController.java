package app.logic.fxmlcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import app.database.CoursesDAO;
import app.database.DatabaseController;
import app.domain.Course;
import app.domain.Difficulty;
import app.presentation.Gui;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CoursesPageController extends Controller implements Initializable {
        private CoursesDAO dao = new CoursesDAO();

        @FXML
        private TableView<Course> adminCoursesTable;
        @FXML
        private TableColumn<Course, String> adminCoursesCourseName;
        @FXML
        private TableColumn<Course, String> adminCoursesSubject;
        @FXML
        private TableColumn<Course, String> adminCoursesDifficulty;
        @FXML
        private TableColumn<Course, Integer> adminCoursesStudentsFinished;

        // definiëren van de benodigde data en getData methode roepen en op de juiste
        // plek in de tabel weergeven
        @Override
        public void initialize(URL location, ResourceBundle resources) {
                adminCoursesCourseName
                                .setCellValueFactory(new PropertyValueFactory<>("courseName"));
                adminCoursesSubject
                                .setCellValueFactory(new PropertyValueFactory<>("subject"));
                adminCoursesDifficulty
                                .setCellValueFactory(new PropertyValueFactory<>("difficulty"));
                adminCoursesStudentsFinished
                                .setCellValueFactory(new PropertyValueFactory<>("studentsFinished"));

                adminCoursesTable.setItems(dao.getData());
        }
}
