package App.GUI.FxmlController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import App.DatabaseController;
import App.CourseMaterial.Course;
import App.CourseMaterial.Difficulty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminCoursesPageController extends AdminController implements Initializable {
        DatabaseController controller = new DatabaseController();

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

        @Override
        public void initialize(URL location, ResourceBundle resources) {
                adminCoursesCourseName
                                .setCellValueFactory(new PropertyValueFactory<Course, String>("courseName"));
                adminCoursesSubject
                                .setCellValueFactory(new PropertyValueFactory<Course, String>("subject"));
                adminCoursesDifficulty
                                .setCellValueFactory(new PropertyValueFactory<Course, String>("difficulty"));
                adminCoursesStudentsFinished
                                .setCellValueFactory(new PropertyValueFactory<Course, Integer>("studentsFinished"));

                adminCoursesTable.setItems(getData());
        }

        public ObservableList<Course> getData() {
                ObservableList<Course> data = FXCollections.observableArrayList();
                String courseName = controller.returnSQL("SELECT CourseName FROM Course", "CourseName")
                                .toString();
                String[] courseNames = courseName.split(";");

                String subject = controller.returnSQL("SELECT Subject FROM Course", "Subject")
                                .toString();
                String[] subjectNames = subject.split(";");

                String difficulty = controller.returnSQL("SELECT Difficulty FROM Course", "Difficulty")
                                .toString();
                String[] difficultyNames = difficulty.split(";");
                ArrayList<Difficulty> difficultyList = new ArrayList<>();
                for (String difficulties : difficultyNames) {
                        if (difficulties.equals("BEGINNER")) {
                                difficultyList.add(Difficulty.BEGINNER);
                        } else if (difficulties.equals("ADVANCED")) {
                                difficultyList.add(Difficulty.ADVANCED);
                        } else if (difficulties.equals("EXPERT")) {
                                difficultyList.add(Difficulty.EXPERT);
                        }
                }

                for (int i = 0; i < courseNames.length && i < difficultyList.size(); i++) {
                        data.add(new Course(courseNames[i], subjectNames[i], difficultyList.get(i), -1));
                }
                return data;
        }
}
