package app.database;

import app.domain.individuals.Student;
import app.presentation.Gui;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class StudentsDAO {
    private DatabaseController controller = new DatabaseController();
    private Gui gui = new Gui();

    public ObservableList<Student> getStudents() {
        ObservableList<Student> data = FXCollections.observableArrayList();
        Object studentName = controller.returnSQL("SELECT Name FROM Student", "Name");
        Object studentEmail = controller.returnSQL("SELECT Email FROM Student", "Email");
        Object studentGender = controller.returnSQL("SELECT Gender FROM Student", "Gender");

        String[] studentNamesArray = studentName.toString().split(";");
        ArrayList<String> studentNames = new ArrayList<>(List.of(studentNamesArray));

        String[] studentEmailsArray = studentEmail.toString().split(";");
        ArrayList<String> studentEmails = new ArrayList<>(List.of(studentEmailsArray));

        String[] studentGendersArray = studentGender.toString().split(";");
        ArrayList<String> studentGenders = new ArrayList<>(List.of(studentGendersArray));


        ArrayList<Button> buttons = new ArrayList<>();
        if(studentNames.size() != 0) {
            for (int index = 0; index < studentNames.size(); index++) {
                Button newButton = new Button("Delete");
                int finalIndex = index;

                newButton.setOnAction((event) -> {
                    try {
                        controller.executeSQL("DELETE FROM Student WHERE Email = '" + studentEmails.get(finalIndex) + "'");
                        gui.changeScene("../presentation/fxmlfiles/Students.fxml");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                buttons.add(newButton);
            }
        }

        for(int i = 0; i < studentNames.size(); i++) {
            data.add(new Student(studentNames.get(i), studentEmails.get(i), studentGenders.get(i), buttons.get(i)));
        }

        return data;
    }
}