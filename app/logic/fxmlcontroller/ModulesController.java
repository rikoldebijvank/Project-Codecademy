package app.logic.fxmlcontroller;

import app.database.ModulesDAO;
import app.presentation.Gui;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import app.domain.content.Module;

import java.net.URL;
import java.util.ResourceBundle;

public class ModulesController extends Controller implements Initializable {
    private ModulesDAO dao = new ModulesDAO();

    @FXML
    private TableView<Module> moduleTableView;
    @FXML
    private TableColumn<Module, String> courseName;
    @FXML
    private TableColumn<Module, String> moduleTitle;
    @FXML
    private TableColumn<Module, Integer> averageProgress;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            courseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
            moduleTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
            averageProgress.setCellValueFactory(new PropertyValueFactory<>("averageProgress"));
            moduleTableView.setItems(dao.getModules());

    }
}
