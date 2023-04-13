package app.logic.fxmlcontroller;

import java.io.IOException;

import app.presentation.Gui;

public abstract class Controller {
    private Gui gui = new Gui();

    //
    // functie aan buttons geven om tussen alle pagina's (scenes) te kunnen bewegen
    // in adminDashborad
    // ..
    public void continueToHomePage() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/StartingPage.fxml");
    }

    public void continueToAdminCoursesPage() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/CoursesPage.fxml");
    }

    public void continueToAdminStudentPage() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/adminStudentPage.fxml");
    }

    public void backToAdminHomePage() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/HomePage.fxml");
    }

    public void continueToAddCoursePage() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/AddCourse.fxml");
    }

    public void continueToAdminStatistics() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/Statistics.fxml");
    }
    public void continueToAdminModulesStatistics() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/ModulesStatistics.fxml");
    }

    public void continueToAdminGenderStatistics() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/GenderStatistics.fxml");
    }

    public void continueToAdminWebcastsStatistics() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/WebcastsStatistics.fxml");
    }

    public void continueToAdminAddModulePage() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/AddModule.fxml");
    }

    public void continueToAdminAddWebcastPage() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/AddWebcast.fxml");
    }
}
