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

public class StatisticsWebcastsController extends FxmlController implements Initializable{

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
        topWebcastsTitles.setCellValueFactory(new PropertyValueFactory<Webcast, String>("Webcast"));
        viewsWebcast.setCellValueFactory(new PropertyValueFactory<Webcast, Integer>("Total Views"));
        topWebcastsTable.setItems(getData());
        
    }
    
    // get alle benodigde data vanuit de sql
    public ObservableList<Webcast> getData() {
        ObservableList<Webcast> data = FXCollections.observableArrayList();
        // String webcastTitle = controller.returnSQL("SELECT Title, FROM Webcast", "Title")
        //                 .toString();
        // String[] webcastTitles = webcastTitle.split(";");
        
        String views = controller.returnSQL("SELECT Webcast.Title, View as views FROM Webcast w " +
        "ORDER BY views DESC " +
        "LIMIT 3", "Views")
        .toString();
        String[] webcastsViews = views.split(";");

        for (int i = 0; i < webcastsViews.length; i++) {
            String[] webcastViews = webcastsViews[i].split(",");
            data.add(new Webcast(webcastViews[0], Integer.valueOf(webcastViews[1])));
        }
        return data;
    }
}
