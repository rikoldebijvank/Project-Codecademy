package app.logic.fxmlcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import app.database.DatabaseController;
import app.database.WebcastStatisticsDAO;
import app.domain.content.Webcast;
import app.presentation.Gui;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StatisticsWebcastsController extends Controller implements Initializable{
    private WebcastStatisticsDAO dao = new WebcastStatisticsDAO();
    
    @FXML
    private TableView<Webcast> topWebcastsTable;;
    @FXML
    private TableColumn<Webcast, String> topWebcastsTitles;
    @FXML
    private TableColumn<Webcast, Integer> viewsWebcast;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        topWebcastsTitles.setCellValueFactory(new PropertyValueFactory<>("title"));
        viewsWebcast.setCellValueFactory(new PropertyValueFactory<>("views"));
        topWebcastsTable.setItems(dao.getData());
    }
}
