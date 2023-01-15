package App.GUI.FxmlController;

import java.net.URL;
import java.util.ResourceBundle;
import App.CourseMaterial.Certificate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentCertificatePageController extends StudentController implements Initializable {

    @FXML
    private TableView<Certificate> studentCertificateTable;
    @FXML
    private TableColumn<Certificate, String> studentCertificateCourseName;
    @FXML
    private TableColumn<Certificate, Integer> studentCertificateID;
    @FXML
    private TableColumn<Certificate, Double> studentCertificateRating;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentCertificateCourseName
                .setCellValueFactory(new PropertyValueFactory<Certificate, String>("courseName"));
        studentCertificateID
                .setCellValueFactory(new PropertyValueFactory<Certificate, Integer>("id"));
        studentCertificateRating
                .setCellValueFactory(new PropertyValueFactory<Certificate, Double>("rating"));

        studentCertificateTable.setItems(getData());
    }

    public ObservableList<Certificate> getData() {
        ObservableList<Certificate> data = FXCollections.observableArrayList();
        data.add(new Certificate("rik", 100, 10.0));
        return data;
    }
}
