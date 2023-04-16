package app.database;

import app.domain.Course;
import app.domain.Difficulty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class CoursesDAO {
    private DatabaseController controller = new DatabaseController();

    // get alle benodigde data vanuit de sql
    public ObservableList<Course> getData() {
        ObservableList<Course> data = FXCollections.observableArrayList();

        String courseNames = controller.returnSQL("SELECT CourseName FROM Course", "CourseName")
                .toString();
        String[] courseNamesArray = courseNames.split(";");

        String subjects = controller.returnSQL("SELECT Subject FROM Course", "Subject")
                .toString();
        String[] subjectNames = subjects.split(";");

        String difficulty = controller.returnSQL("SELECT Difficulty FROM Course", "Difficulty")
                .toString();
        String[] difficultyNames = difficulty.split(";");
        ArrayList<Difficulty> difficultyList = new ArrayList<>();
        for (String difficulties : difficultyNames) {
            if (difficulties.equals("BEGINNER")) {
                difficultyList.add(Difficulty.BEGINNER);
            } else if (difficulties.equals("ADVANCED")) {
                difficultyList.add(Difficulty.ADVANCED);
            } else if (difficulties.equals("EXPERT")) {
                difficultyList.add(Difficulty.EXPERT);
            }
        }

        ArrayList<Integer> studentsFinishedArrayList = new ArrayList<>();
        for(String name : courseNamesArray) {
            Object studentsFinished = controller.returnSQL("SELECT COUNT(CourseFinished) AS StudentsFinished FROM Registration WHERE CourseFinished = 1 AND CourseName = '" + name + "'", "StudentsFinished");
            String[] studentsFinishedArray = studentsFinished.toString().split(";");
            studentsFinishedArrayList.add(Integer.valueOf(studentsFinishedArray[0]));
        }

        for (int i = 0; i < courseNamesArray.length && i < difficultyList.size(); i++) {
            data.add(new Course(courseNamesArray[i], subjectNames[i], difficultyList.get(i), studentsFinishedArrayList.get(i)));
        }
        return data;
    }
}
