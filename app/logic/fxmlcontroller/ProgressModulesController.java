package app.logic.fxmlcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import app.database.ProgressDAO;
import app.domain.content.Content;
import app.database.DatabaseController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProgressModulesController extends Controller implements Initializable{
    ProgressDAO dao = new ProgressDAO();

    @FXML
    private TableView<Content> progressTable;
    @FXML
    private TableColumn<Content, String> webcastsTitles;
    @FXML
    private TableColumn<Content, String> webcastsProgress;
    @FXML
    private TableColumn<Content, String> modulesTitles;
    @FXML
    private TableColumn<Content, String> moduleProgress;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        modulesTitles.setCellValueFactory(new PropertyValueFactory<Content, String>("moduleTitle"));
        moduleProgress.setCellValueFactory(new PropertyValueFactory<Content, String>("moduleProgress"));
        webcastsTitles.setCellValueFactory(new PropertyValueFactory<Content, String>("webcastTitle"));
        webcastsProgress.setCellValueFactory(new PropertyValueFactory<Content, String>("webcastProgress"));
        progressTable.setItems(dao.getData());
    }
}
