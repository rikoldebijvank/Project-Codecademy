package App.GUI;

import java.io.IOException;

import App.DatabaseController;

public class FxmlAdminController {
    private DatabaseController controller = new DatabaseController();
    private Gui gui = new Gui();
    private FxmlSignInController signInController = new FxmlSignInController();

    //new methodes

    public void continueToAdminCoursesPage() throws IOException {
        gui.changeScene("FxmlFiles/adminCoursesPage.fxml");
    }

    public void continueToAdminStudentPage() throws IOException {
        gui.changeScene("FxmlFiles/adminStudentPage.fxml");
    }

    public void backToAdminHomePage() throws IOException {
        gui.changeScene("FxmlFiles/adminHomePage.fxml");
    }
}
