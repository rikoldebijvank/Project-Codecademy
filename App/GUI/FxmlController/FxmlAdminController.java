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
    private FxmlSignInController signInController = new FxmlSignInController();

    @FXML
    private Label adminWelcomeName;

    public void setAdminWelcomeName(String name) {
        adminWelcomeName.setText(name);
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

    public void addCourse() {
        controller.createCourse(courseName.getText(), courseSubject.getText(), courseIntro.getText(),
                courseDifficulty.getText(), signInController.adminEmailLoggedIn);
        addCourseSuccessLabel.setText("Course Successfully Added");
    }
}
