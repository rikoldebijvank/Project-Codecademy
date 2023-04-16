package app.logic.fxmlcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import app.database.DatabaseController;
import app.domain.Difficulty;
import app.presentation.Gui;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class AddCourseController extends Controller implements Initializable {
    private DatabaseController controller = new DatabaseController();
    Gui gui = new Gui();

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
    private TextField chaptersTextField;

    ObservableList<Difficulty> courseDifficultyList = FXCollections.observableArrayList(Difficulty.BEGINNER,
            Difficulty.ADVANCED, Difficulty.EXPERT);

    // "nieuwe cursussen toevoegen" functie via gui
    public void addCourse() throws Exception{
        if (!courseName.getText().isEmpty() && !courseSubject.getText().isEmpty() && !courseIntro.getText().isEmpty() && !(chaptersTextField.getText()).matches("[09]+")) {
            controller.createCourse(courseName.getText(), courseSubject.getText(), courseIntro.getText(),
                courseDifficulty.getValue().name(), Integer.parseInt(chaptersTextField.getText()));
            addCourseSuccessLabel.setText("Course Successfully Added");
            addCourseSuccessLabel.setTextFill(Color.web("#00ff1a"));
            gui.changeScene("../presentation/fxmlfiles/CoursesPage.fxml");
        } else {
            addCourseSuccessLabel.setText("Course Can't be Added, Fill Course information");
            addCourseSuccessLabel.setTextFill(Color.web("#b00"));
        }
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
