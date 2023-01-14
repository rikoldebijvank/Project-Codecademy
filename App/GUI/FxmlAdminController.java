package App.GUI;

import java.io.IOException;

import App.DatabaseController;

public class FxmlAdminController {
    private DatabaseController controller = new DatabaseController();
    private Gui gui = new Gui();
    private FxmlSignInController signInController = new FxmlSignInController();

    public void continueToStudentCoursesPage() throws IOException {
        gui.changeScene("FxmlFiles/studentCoursesPage.fxml");
    }

    public void backToFrontPage() throws IOException {
        gui.changeScene("startingPage.fxml");
    }
}
