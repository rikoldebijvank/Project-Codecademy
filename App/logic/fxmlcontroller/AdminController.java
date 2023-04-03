package app.logic.fxmlcontroller;

import java.io.IOException;

import app.presentation.Gui;

public abstract class AdminController {
    private Gui gui = new Gui();

    //
    // functie aan buttons geven om tussen alle pagina's (scenes) te kunnen bewegen
    // in adminDashborad
    // ..
    public void continueToHomePage() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/StartingPage.fxml");
    }

    public void continueToAdminCoursesPage() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/adminCoursesPage.fxml");
    }

    public void continueToAdminStudentPage() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/adminStudentPage.fxml");
    }

    public void backToAdminHomePage() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/adminHomePage.fxml");
    }

    public void continueToAddCoursePage() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/addCourse.fxml");
    }

    public void continueToAdminStatistics() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/adminStatistics.fxml");
    }

    public void continueToAdminModulesStatistics() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/adminModulesStatistics.fxml");
    }

    public void continueToAdminGenderStatistics() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/adminGenderStatistics.fxml");
    }

    public void continueToAdminWebcastsStatistics() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/adminWebcastsStatistics.fxml");
    }

    public void continueToAdminCertificatesStatistics() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/adminCertificatesStatistics.fxml");
    }

    public void continueToAdminAddModulePage() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/addModule.fxml");
    }

    public void continueToAdminAddWebcastPage() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/addWebcast.fxml");
    }
}
