package app.logic.fxmlcontroller;

import java.io.IOException;

import app.presentation.Gui;

public abstract class Controller {
    private Gui gui = new Gui();

    //
    // functie aan buttons geven om tussen alle pagina's (scenes) te kunnen bewegen
    // in adminDashborad
    // ..

    public void continueToCoursesPage() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/CoursesPage.fxml");
    }

    public void continueToRegistrations() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/Registrations.fxml");
    }

    public void continueToStudents() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/Students.fxml");
    }

    public void continueToContent() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/Content.fxml");
    }

    public void backToHomePage() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/HomePage.fxml");
    }

    public void continueToAddCoursePage() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/AddCourse.fxml");
    }

    public void continueToStatistics() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/Statistics.fxml");
    }
    public void continueToModulesStatistics() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/ModuleStatistics.fxml");
    }

    public void continueToWebcastsStatistics() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/WebcastsStatistics.fxml");
    }

    public void continueToStudentRegistration() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/StudentRegistration.fxml");
    }

    public void continueToAddNewRegistration() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/AddNewRegistration.fxml");
    }

    public void continueToModules() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/ModuleStatistics.fxml");
    }

    public void continueToWebcasts() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/AddWebcast.fxml");
    }

    public void continueToStatisticsModules() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/ModulesStatistics.fxml");
    }

    public void continueToProgressPerStudent() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/ProgressModulesPerStudent.fxml");
    }
}
