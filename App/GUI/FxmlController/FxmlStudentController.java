package App.GUI;

import App.DatabaseController;

public class FxmlStudentController {
    private DatabaseController controller = new DatabaseController();
    private Gui gui = new Gui();


    // new methodes
    public void continueToStudentCoursesPage() throws IOException {
        gui.changeScene("FxmlFiles/studentCoursesPage.fxml");
    }

    public void backToStudentHomePage() throws IOException {
        gui.changeScene("FxmlFiles/studentHomePage.fxml");
    }
}