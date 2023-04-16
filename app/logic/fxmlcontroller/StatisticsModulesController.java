package app.logic.fxmlcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import app.database.DatabaseController;
import app.domain.Course;
import app.domain.individuals.Student;
import app.presentation.Gui;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class StatisticsModulesController extends Controller implements Initializable{

    private DatabaseController controller = new DatabaseController();
    private Gui gui = new Gui();
    
    @FXML
    private ComboBox<String> courseComboBox;
    @FXML
    private ComboBox<String> studentComboBox;

    public static String selectedCourse;
    public static String selectedStudent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Course> courses= getCourseData();
        ObservableList<String> coursesStringList = courses.stream()
        .map(Course::getCourseName)
        .distinct()
        .collect(Collectors.toCollection(FXCollections::observableArrayList));
        courseComboBox.setItems(coursesStringList);
        ObservableList<Student> students = getStudentData(courses);
        ObservableList<String> studentsStringList = students.stream()
        .map(Student::getName)
        .distinct()
        .collect(Collectors.toCollection(FXCollections::observableArrayList));
        studentComboBox.setItems(studentsStringList);

    }

    // get alle benodigde data vanuit de sql
    public ObservableList<Course> getCourseData() {
        
        ObservableList<Course> courseData = FXCollections.observableArrayList();
        String courseName = controller.returnSQL("SELECT CourseName FROM Course", "CourseName")
                        .toString();
        String[] courseNames = courseName.split(";");
        
        for (int i = 0; i < courseNames.length; i++) {
            courseData.add(new Course(courseNames[i]));
        }

        return courseData;
    }


    public ObservableList<Student> getStudentData(ObservableList<Course> courses) {
        
        ObservableList<Student> studentData = FXCollections.observableArrayList();
        for (int j = 0; j < courses.size(); j++) {
            String course = courses.get(j).getCourseName();
            String studentName = controller.returnSQL("SELECT Name FROM Student " + 
            "WHERE Email IN ( SELECT StudentEmail FROM ViewedContent " + 
            "WHERE ContentID IN ( SELECT ContentID FROM ContentItem " + 
            "Where CourseName = '" + course + "'));", "Name")
                            .toString();
            String[] studentNames = studentName.split(";");
            for (int i = 0; i < studentNames.length; i++) {
                studentData.add(new Student(studentNames[i]));
            }
        }
        
        return studentData;
    }

    public void showProgress() {
        selectedCourse = courseComboBox.getValue();
        selectedStudent = studentComboBox.getValue();
            try {
                gui.changeScene("../presentation/fxmlfiles/ProgressModulesPerStudent.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
}
