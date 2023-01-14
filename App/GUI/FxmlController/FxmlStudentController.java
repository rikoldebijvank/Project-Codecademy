package App.GUI.FxmlController;

import java.io.IOException;

import App.DatabaseController;
import App.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FxmlStudentController {
    private DatabaseController controller = new DatabaseController();
    private Gui gui = new Gui();

    @FXML
    private Label studentWelcomeName;

    public void continueToStudentCoursesPage() throws IOException {
        gui.changeScene("./FxmlFiles/studentCoursesPage.fxml");
    }

    public void backToStudentHomePage() throws IOException {
        gui.changeScene("./FxmlFiles/studentHomePage.fxml");
    }
}