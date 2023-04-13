package app.logic.fxmlcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import app.domain.content.Module;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentStatisticsPageController implements Initializable {

    @FXML
    private TableView<Module> statisticsTable;
    @FXML
    private TableColumn<Module, String> statisticsTableCourseName;
    @FXML
    private TableColumn<Module, String> statisticsTableModule;
    @FXML
    private TableColumn<Module, Integer> statisticsTablePercentageFinished;

    // definiëren van de benodigde data en getData methode roepen
    // en op de juiste plek in de tabel weergeven
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        statisticsTableCourseName
                .setCellValueFactory(new PropertyValueFactory<Module, String>("courseName"));
        statisticsTableModule
                .setCellValueFactory(new PropertyValueFactory<Module, String>("title"));
        statisticsTablePercentageFinished
                .setCellValueFactory(new PropertyValueFactory<Module, Integer>("percentageFinished"));

        statisticsTable.setItems(getData());
    }

    // get alle benodigde data vanuit de sql
    public ObservableList<Module> getData() {
        ObservableList<Module> data = FXCollections.observableArrayList();
        data.add(new Module("title", "module", 60));
        return data;
    }
}
