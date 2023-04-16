package app.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import app.domain.content.Module;
import java.util.HashMap;
import java.util.List;

public class ModulesDAO {
    private DatabaseController controller = new DatabaseController();

    public ObservableList<Module> getModules() {
        ObservableList<Module> data = FXCollections.observableArrayList();

        Object courseName = controller.returnSQL("SELECT CourseName FROM Course", "CourseName");
        String[] courseNames = courseName.toString().split(";");

        HashMap<String, String> moduleTitles = new HashMap<>();

        for(String name : courseNames) {
            Object moduleTitle = controller.returnSQL("SELECT Title FROM Module WHERE ID IN (SELECT ModuleID FROM ContentItem WHERE CourseName = '" + name + "')", "Title");
            String[] moduleTitlesArray = moduleTitle.toString().split(";");
            for(String title : moduleTitlesArray) {
                moduleTitles.put(name, title);
                Object averageProgress = controller.returnSQL("SELECT AVG(PercentageViewed) AS AverageProgress FROM ViewedContent WHERE ContentID = (SELECT ContentID FROM ContentItem WHERE ModuleID = (SELECT ID FROM Module WHERE Title = '" + title + "'))", "AverageProgress");
                String[] averageProgressArray = averageProgress.toString().split(";");
                if(!averageProgressArray[0].equals("null")) {
                    data.add(new Module(name, moduleTitles.get(name), Integer.valueOf(averageProgressArray[0])));
                } else {
                    data.add(new Module(name, moduleTitles.get(name), 0));
                }
            }
        }

        return data;
    }
}
