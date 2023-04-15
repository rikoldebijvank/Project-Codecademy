package app.logic.fxmlcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import app.database.DatabaseController;
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

    DatabaseController controller = new DatabaseController();
    Gui gui = new Gui();
    
    @FXML
    private TableView<Webcast> topWebcastsTable;;
    @FXML
    private TableColumn<Webcast, String> topWebcastsTitles;
    @FXML
    private TableColumn<Webcast, Integer> viewsWebcast;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        topWebcastsTitles.setCellValueFactory(new PropertyValueFactory<Webcast, String>("title"));
        viewsWebcast.setCellValueFactory(new PropertyValueFactory<Webcast, Integer>("views"));
        topWebcastsTable.setItems(getData());
        
    }
    
    // get alle benodigde data vanuit de sql
    public ObservableList<Webcast> getData() {
        ObservableList<Webcast> data = FXCollections.observableArrayList();
        String views = controller.returnSQL("SELECT TOP 3 Views AS topviews FROM Webcast ORDER BY views DESC", "topviews")
            .toString();
        String[] webcastsViews = views.split(";");

        String titles = controller.returnSQL("SELECT TOP 3 Title AS topviews FROM Webcast ORDER BY views DESC", "topviews")
            .toString();
        String[] webcastsTitles = titles.split(";");

        for (int i = 0; i < webcastsViews.length; i++) {
            data.add(new Webcast(webcastsTitles[i], Integer.valueOf(webcastsViews[i])));
        }
        return data;
    }
}
