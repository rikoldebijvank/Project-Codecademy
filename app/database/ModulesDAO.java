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
                data.add(new Module(name, moduleTitles.get(name), 8));
            }
        }

        System.out.println("All data: " + data.get(0).getTitle());

        return data;
    }
}
