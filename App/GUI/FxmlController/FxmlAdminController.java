package App.GUI.FxmlController;

import java.io.IOException;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import App.DatabaseController;
import App.GUI.Gui;
import javafx.fxml.FXML;

public class FxmlAdminController {
    private DatabaseController controller = new DatabaseController();
    private Gui gui = new Gui();

    public void continueToHomePage() throws IOException {
        gui.changeScene("././startingPage.fxml");
    }

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

    public void continueToAdminModulesStatistics() throws IOException {
        gui.changeScene("./FxmlFiles/adminModulesStatistics.fxml");
    }

    public void continueToAdminGenderStatistics() throws IOException {
        gui.changeScene("./FxmlFiles/adminGenderStatistics.fxml");
    }

    public void continueToAdminWebcastsStatistics() throws IOException {
        gui.changeScene("./FxmlFiles/adminWebcastsStatistics.fxml");
    }

    public void continueToAdminCertificatesStatistics() throws IOException {
        gui.changeScene("./FxmlFiles/adminCertificatesStatistics.fxml");
    }

    @FXML
    private TextField courseName;
    @FXML
    private TextField courseSubject;
    @FXML
    private TextField courseIntro;
    @FXML
    private TextField courseDifficulty;
    @FXML
    private Label addCourseSuccessLabel;
    @FXML
    private TextField adminCourseEmail;

    public void addCourse() {
        controller.createCourse(courseName.getText(), courseSubject.getText(), courseIntro.getText(),
                courseDifficulty.getText(), adminCourseEmail.getText());
        addCourseSuccessLabel.setText("Course Successfully Added");
    }
}
