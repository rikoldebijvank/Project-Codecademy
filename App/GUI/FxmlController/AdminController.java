package App.GUI.FxmlController;

import java.io.IOException;
import App.GUI.Gui;

public abstract class AdminController {
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

    public void continueToAdminAddModulePage() throws IOException {
        gui.changeScene("./FxmlFiles/addModule.fxml");
    }

    public void continueToAdminAddWebcastPage() throws IOException {
        gui.changeScene("./FxmlFiles/addWebcast.fxml");
    }
}
