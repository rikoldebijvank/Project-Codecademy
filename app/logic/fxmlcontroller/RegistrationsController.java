package app.logic.fxmlcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import app.database.DatabaseController;
import app.domain.Course;
import app.presentation.Gui;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RegistrationsController implements Initializable{

    DatabaseController controller = new DatabaseController();
        Gui gui = new Gui();

        @FXML
        private TableView<Course> coursesRegistrations;
        @FXML
        private TableColumn<Course, String> courseNames;
        @FXML
        private TableColumn<Course, Button> viewRegistrationsBtn;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        courseNames.setCellValueFactory(new PropertyValueFactory<Course, String>("courseName"));
        viewRegistrationsBtn.setCellValueFactory(new PropertyValueFactory<Course, Button>("View registrations"));
        coursesRegistrations.setItems(getData());
        
    }


    // get alle benodigde data vanuit de sql
    public ObservableList<Course> getData() {
        ObservableList<Course> data = FXCollections.observableArrayList();
        String courseName = controller.returnSQL("SELECT CourseName FROM Course", "CourseName")
                        .toString();
        String[] courseNames = courseName.split(";");
        ArrayList<Button> courseButtons = new ArrayList<>();
        for (String name : courseNames) {
                Button newButton = new Button("View Registrations");
                newButton.setOnAction((event) -> {
                        try {
                                gui.changeScene("../presentation/fxmlfiles/CoursePage.fxml");
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                });
                courseButtons.add(newButton);
        }

        for (int i = 0; i < courseNames.length; i++) {
                data.add(new Course(courseButtons.get(i), courseNames[i]));
        }
        return data;
}
    

}
