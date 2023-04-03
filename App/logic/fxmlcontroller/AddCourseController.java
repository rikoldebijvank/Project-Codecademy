package app.logic.fxmlcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import app.database.DatabaseController;
import app.domain.Difficulty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddCourseController extends AdminController implements Initializable {
    private DatabaseController controller = new DatabaseController();

    @FXML
    private TextField courseName;
    @FXML
    private TextField courseSubject;
    @FXML
    private TextField courseIntro;
    @FXML
    private ChoiceBox<Difficulty> courseDifficulty;
    @FXML
    private Label addCourseSuccessLabel;
    @FXML
    private TextField adminCourseEmail;

    ObservableList<Difficulty> courseDifficultyList = FXCollections.observableArrayList(Difficulty.BEGINNER,
            Difficulty.ADVANCED, Difficulty.EXPERT);

    // "nieuwe cursussen toevoegen" functie via gui
    public void addCourse() {
        controller.createCourse(courseName.getText(), courseSubject.getText(), courseIntro.getText(),
                courseDifficulty.getValue().name(), adminCourseEmail.getText());
        addCourseSuccessLabel.setText("Course Successfully Added");
    }

    //
    // laat de moeilijkheid opties in de choose box bij nieuwe cursus aanmaken
    // (addCourse page)
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        courseDifficulty.setValue(Difficulty.BEGINNER);
        courseDifficulty.setItems(courseDifficultyList);

    }
}
