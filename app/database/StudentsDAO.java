package app.database;

import app.domain.individuals.Student;
import app.presentation.Gui;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.ArrayList;

public class StudentsDAO {
    private DatabaseController controller = new DatabaseController();
    private Gui gui = new Gui();

    public ObservableList<Student> getStudents() {
        ObservableList<Student> data = FXCollections.observableArrayList();
        Object studentName = controller.returnSQL("SELECT Name FROM Student", "Name");
        Object studentEmail = controller.returnSQL("SELECT Email FROM Student", "Email");
        Object studentGender = controller.returnSQL("SELECT Gender FROM Student", "Gender");

        String[] studentNames = studentName.toString().split(";");
        String[] studentEmails = studentEmail.toString().split(";");
        String[] studentGenders = studentGender.toString().split(";");

        ArrayList<Button> buttons = new ArrayList<>();
        for(int index = 0; index < studentNames.length; index++ ) {
            Button newButton = new Button("Delete");
            int finalIndex = index;

            newButton.setOnAction((event) -> {
                try {
                    controller.executeSQL("DELETE FROM Student WHERE Email = '" + studentEmails[finalIndex] + "'");
                    buttons.clear();
                    gui.changeScene("../presentation/fxmlfiles/Students.fxml");
                } catch(Exception e) {
                    e.printStackTrace();
                }
            });
            buttons.add(newButton);
        }

        for(int i = 0; i < studentNames.length; i++) {
            data.add(new Student(studentNames[i], studentEmails[i], studentGenders[i], buttons.get(i)));
        }

        return data;
    }
}
