package app.logic.fxmlcontroller;

import java.net.URL;
import java.util.ResourceBundle;
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

    private DatabaseController controller = new DatabaseController();

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
        progressTable.setItems(getData());
    }
    
    // get alle benodigde data vanuit de sql
    public ObservableList<Content> getData() {
        ObservableList<Content> data = FXCollections.observableArrayList();
        
        String moduleTitle = controller.returnSQL("SELECT Title FROM Module " + 
        "WHERE ID IN ( SELECT ModuleID FROM ContentItem WHERE CourseName ='" + StatisticsModulesController.selectedCourse +
         "')", "Title").toString();
        String[] modules = moduleTitle.split(";");
        
        String moduleProgress = controller.returnSQL("SELECT PercentageViewed FROM ViewedContent " +
        "WHERE ContentID IN ( SELECT ContentID FROM ContentItem WHERE CourseName = '"+ StatisticsModulesController.selectedCourse + "' AND ModuleID IS NOT NULL) " +
        "AND StudentEmail IN ( SELECT Email FROM Student WHERE Name = '" + StatisticsModulesController.selectedStudent + "')",
        "PercentageViewed").toString();
        String[] modulesProg = moduleProgress.split(";");


        
        String webcastTitle = controller.returnSQL("SELECT Title FROM Webcast " + 
        "WHERE ID IN ( SELECT ModuleID FROM ContentItem WHERE CourseName ='"+ StatisticsModulesController.selectedCourse +
        "')", "Title").toString();
        System.out.println(webcastTitle);
        String[] webcasts = webcastTitle.split(";");
        
        String webcastProgress = controller.returnSQL("SELECT PercentageViewed FROM ViewedContent "+
        "WHERE ContentID IN ( SELECT ContentID FROM ContentItem WHERE CourseName = '"+ StatisticsModulesController.selectedCourse + "' AND WebcastID IS NOT NULL) " +
        "AND StudentEmail IN ( SELECT Email FROM Student WHERE Name = '" + StatisticsModulesController.selectedStudent + "')",
        "PercentageViewed").toString();
        String[] webcastsProg = webcastProgress.split(";");

        for (int i = 0; i < modules.length; i++) {
                data.add(new Content(modules[i], modulesProg[i] + "%", webcasts[i], webcastsProg[i] + "%" ));
        }
        return data;
    }

}
