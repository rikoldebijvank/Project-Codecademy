package App.GUI.FxmlController;

import java.io.IOException;
import App.GUI.Gui;

public abstract class StudentController {
    private Gui gui = new Gui();

    public void continueToHomePage() throws IOException {
        gui.changeScene("././startingPage.fxml");
    }

    public void continueToStudentCourses() throws IOException {
        gui.changeScene("./FxmlFiles/studentCoursesPage.fxml");
    }

    public void continueToStudentRegistrations() throws IOException {
        gui.changeScene("./FxmlFiles/studentShowRegistrations.fxml");
    }

    public void continueToStudentCertificates() throws IOException {
        gui.changeScene("./FxmlFiles/studentCertificates.fxml");
    }

    public void continueToStudentStatistics() throws IOException {
        gui.changeScene("./FxmlFiles/studentStatistics.fxml");
    }

    public void backToStudentHomePage() throws IOException {
        gui.changeScene("./FxmlFiles/studentHomePage.fxml");
    }
}