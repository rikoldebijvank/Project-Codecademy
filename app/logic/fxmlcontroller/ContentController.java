package app.logic.fxmlcontroller;

import app.database.ModulesDAO;
import app.presentation.Gui;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import app.domain.content.Module;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ContentController extends Controller implements Initializable {
    private Gui gui = new Gui();
    private ModulesDAO dao = new ModulesDAO();

    @FXML
    private TableView<Module> moduleTableView;
    @FXML
    private TableColumn<Module, String> courseName;
    @FXML
    private TableColumn<Module, String> moduleTitle;
    @FXML
    private TableColumn<Module, Integer> averageProgress;

    public void continueToModules() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/ModuleStatistics.fxml");
    }

    public void continueToWebcasts() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/AddWebcast.fxml");
    }

    public void continueToAddModule() throws IOException {
        gui.changeScene("../presentation/fxmlfiles/AddModule.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            courseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
            moduleTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
            averageProgress.setCellValueFactory(new PropertyValueFactory<>("averageProgress"));
            moduleTableView.setItems(dao.getModules());

    }
}
