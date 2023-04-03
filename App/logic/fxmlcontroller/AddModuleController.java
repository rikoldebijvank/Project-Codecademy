package app.logic.fxmlcontroller;

import java.io.IOException;

import app.database.DatabaseController;
import app.domain.content.Status;
import app.presentation.Gui;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AddModuleController extends AdminController {
    private DatabaseController controller = new DatabaseController();
    private Gui gui = new Gui();

    @FXML
    private TextField moduleContactPersonName;
    @FXML
    private TextField moduleDescription;
    @FXML
    private TextField moduleID;
    @FXML
    private TextField moduleNumber;
    @FXML
    private DatePicker modulePublicationDate;
    @FXML
    private ChoiceBox<Status> moduleStatus;
    @FXML
    private TextField moduleTitle;
    @FXML
    private TextField moduleVersion;
    @FXML
    private TextField addModuleCourse;

    // "nieuwe modules toevoegen" functie via gui
    public void addModule() throws IOException {
        controller.executeSQL("INSERT INTO ContentItem VALUES ('" + moduleID.getText() + "', '"
                + modulePublicationDate.getValue() + "', '" + moduleStatus.getValue() + "', '"
                + addModuleCourse.getText() + "')");
        controller.executeSQL("INSERT INTO Module VALUES ('" + moduleTitle.getText() + "', '" + moduleVersion.getText()
                + "', '" + moduleID.getText() + "', '" + moduleContactPersonName.getText() + "', '"
                + moduleDescription.getText() + "', '" + moduleNumber.getText() + "')");

        gui.changeScene("../presentation/fxmlfiles/adminCoursesPage.fxml");
    }
}
