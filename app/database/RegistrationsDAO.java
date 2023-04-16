package app.database;

import app.domain.individuals.Student;
import app.logic.fxmlcontroller.RegistrationsController;
import app.presentation.Gui;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class RegistrationsDAO {
    private DatabaseController controller = new DatabaseController();
    private Gui gui = new Gui();

    // get alle benodigde data vanuit de sql
    public ObservableList<Student> getData() {
        ObservableList<Student> data = FXCollections.observableArrayList();
        String studentName = controller.returnSQL("SELECT Name FROM Student " +
                        "WHERE Email IN ( SELECT StudentEmail FROM Registration " +
                        "WHERE CourseName = '" + RegistrationsController.courseName1 + "');", "Name")
                .toString();
        String[] studentNames = studentName.split(";");
        ArrayList<Button> studentRegisterationsButtons = new ArrayList<>();
        for (String name : studentNames) {
            Button newButton = new Button("Unenroll");
            newButton.setOnAction((event) -> {
                try {
                    controller.executeSQL("DELETE FROM Registration WHERE CourseName = '" + RegistrationsController.courseName1 +
                            "' AND StudentEmail = (SELECT Email FROM Student WHERE Name = '" + name + "');");
                    gui.changeScene("../presentation/fxmlfiles/RegistrationsPerCourse.fxml");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            studentRegisterationsButtons.add(newButton);
        }

        for (int i = 0; i < studentNames.length; i++) {
            data.add(new Student(studentNames[i], studentRegisterationsButtons.get(i)));
        }
        return data;
    }
}
