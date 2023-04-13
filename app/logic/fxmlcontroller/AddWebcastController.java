package app.logic.fxmlcontroller;

import java.io.IOException;

import app.database.DatabaseController;
import app.domain.content.Status;
import app.presentation.Gui;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AddWebcastController {
    DatabaseController controller = new DatabaseController();
    Gui gui = new Gui();

    @FXML
    private TextField webcastContentId;
    @FXML
    private TextField webcastDescription;
    @FXML
    private TextField webcastLength;
    @FXML
    private DatePicker webcastPublicationDate;
    @FXML
    private TextField webcastSpeakerName;
    @FXML
    private TextField webcastTitle;
    @FXML
    private TextField webcastURL;
    @FXML
    private ChoiceBox<Status> webcastStatus;
    @FXML
    private TextField addWebcastCourseName;

    // "nieuwe webcast toevoegen" functie via gui
    public void addWebcast() throws IOException {
        controller.executeSQL("INSERT INTO ContentItem VALUES ('" + webcastContentId.getText() + "', '"
                + webcastPublicationDate.getValue() + "', '" + webcastStatus.getValue() + "', '"
                + addWebcastCourseName.getText() + "')");
        controller.executeSQL("INSERT INTO Webcast VALUES ('" + webcastTitle.getText() + "', '"
                + webcastContentId.getText() + "', '" + webcastSpeakerName.getText() + "', '"
                + webcastURL.getText() + webcastDescription.getText() + "', '" + webcastLength.getText() + "')");

        gui.changeScene("../presentation/fxmlfiles/CoursesPage.fxml");
    }

}
