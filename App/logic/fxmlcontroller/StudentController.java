package app.logic.fxmlcontroller;

import java.io.IOException;

import app.presentation.Gui;

public abstract class StudentController {
    private Gui gui = new Gui();

    // functie aan buttons geven om tussen alle pagina's (scenes)
    // te kunnen bewegen in studentDashboard
    public void continueToHomePage() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/StartingPage.fxml");
    }

    public void continueToStudentCourses() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/studentCoursesPage.fxml");
    }

    public void continueToStudentRegistrations() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/studentShowRegistrations.fxml");
    }

    public void continueToStudentCertificates() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/studentCertificates.fxml");
    }

    public void continueToStudentStatistics() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/studentStatistics.fxml");
    }

    public void backToStudentHomePage() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/studentHomePage.fxml");
    }
}
