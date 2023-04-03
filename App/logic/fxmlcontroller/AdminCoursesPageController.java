package app.logic.fxmlcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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

public class AdminCoursesPageController extends AdminController implements Initializable {
        DatabaseController controller = new DatabaseController();
        Gui gui = new Gui();

        @FXML
        private TableView<Course> adminCoursesTable;
        @FXML
        private TableColumn<Course, Button> adminCoursesCourseName;
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
                                .setCellValueFactory(new PropertyValueFactory<Course, Button>("courseButton"));
                adminCoursesSubject
                                .setCellValueFactory(new PropertyValueFactory<Course, String>("subject"));
                adminCoursesDifficulty
                                .setCellValueFactory(new PropertyValueFactory<Course, String>("difficulty"));
                adminCoursesStudentsFinished
                                .setCellValueFactory(new PropertyValueFactory<Course, Integer>("studentsFinished"));

                adminCoursesTable.setItems(getData());
        }

        // get alle benodigde data vanuit de sql
        public ObservableList<Course> getData() {
                ObservableList<Course> data = FXCollections.observableArrayList();
                String courseName = controller.returnSQL("SELECT CourseName FROM Course", "CourseName")
                                .toString();
                String[] courseNames = courseName.split(";");
                ArrayList<Button> courseButtons = new ArrayList<>();
                for (String name : courseNames) {
                        Button newButton = new Button(name);
                        newButton.setOnAction((event) -> {
                                try {
                                        gui.changeScene("../presentation/fxmlfiles/addModule.fxml");
                                } catch (IOException e) {
                                        e.printStackTrace();
                                }
                        });
                        courseButtons.add(newButton);
                }

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
                        data.add(new Course(courseButtons.get(i), subjectNames[i], difficultyList.get(i), -1));
                }
                return data;
        }
}
