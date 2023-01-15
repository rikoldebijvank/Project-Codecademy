package App.GUI.FxmlController;

import java.net.URL;
import java.util.ResourceBundle;
import App.CourseMaterial.Content.Module;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentStatisticsPageController extends StudentController implements Initializable {

    @FXML
    private TableView<Module> statisticsTable;
    @FXML
    private TableColumn<Module, String> statisticsTableCourseName;
    @FXML
    private TableColumn<Module, String> statisticsTableModule;
    @FXML
    private TableColumn<Module, Integer> statisticsTablePercentageFinished;

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

    public ObservableList<Module> getData() {
        ObservableList<Module> data = FXCollections.observableArrayList();
        data.add(new Module("title", "module", 60));
        return data;
    }
}
