package app.database;

import app.domain.content.Content;
import app.logic.fxmlcontroller.StatisticsModulesController;
import app.presentation.Gui;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProgressDAO {
    private DatabaseController controller = new DatabaseController();

    // get alle benodigde data vanuit de sql
    public ObservableList<Content> getData() {
        ObservableList<Content> data = FXCollections.observableArrayList();

        String moduleTitle = controller.returnSQL("SELECT Title FROM Module " +
                "WHERE ID IN (SELECT ModuleID FROM ContentItem WHERE Status = 'ACTIVE' AND CourseName ='" + StatisticsModulesController.selectedCourse +
                "')", "Title").toString();
        String[] modules = moduleTitle.split(";");

        String moduleProgress = controller.returnSQL("SELECT PercentageViewed FROM ViewedContent " +
                        "WHERE ContentID IN ( SELECT ContentID FROM ContentItem WHERE Status = 'ACTIVE' AND CourseName = '"+ StatisticsModulesController.selectedCourse + "' AND ModuleID IS NOT NULL) " +
                        "AND StudentEmail IN ( SELECT Email FROM Student WHERE Name = '" + StatisticsModulesController.selectedStudent + "')",
                "PercentageViewed").toString();
        String[] modulesProg = moduleProgress.split(";");



        String webcastTitle = controller.returnSQL("SELECT Title FROM Webcast " +
                "WHERE ID IN ( SELECT ModuleID FROM ContentItem WHERE Status = 'ACTIVE' AND CourseName ='"+ StatisticsModulesController.selectedCourse +
                "')", "Title").toString();
        System.out.println(webcastTitle);
        String[] webcasts = webcastTitle.split(";");

        String webcastProgress = controller.returnSQL("SELECT PercentageViewed FROM ViewedContent "+
                        "WHERE ContentID IN ( SELECT ContentID FROM ContentItem WHERE Status = 'ACTIVE' AND CourseName = '"+ StatisticsModulesController.selectedCourse + "' AND WebcastID IS NOT NULL) " +
                        "AND StudentEmail IN ( SELECT Email FROM Student WHERE Name = '" + StatisticsModulesController.selectedStudent + "')",
                "PercentageViewed").toString();
        String[] webcastsProg = webcastProgress.split(";");

        int length = 0;
        if(modules.length > webcasts.length) {
            length = modules.length;
        } else if(webcasts.length > modules.length) {
            length = webcasts.length;
        } else {
            length = modules.length;
        }

        for (int i = 0; i < length; i++) {
            if(i > modules.length) {
                data.add(new Content("No Data", modulesProg[i] + "%", webcasts[i], webcastsProg[i] + "%"));
            } else if(i > webcasts.length) {
                data.add(new Content(modules[i], modulesProg[i] + "%", "No Data", webcastsProg[i] + "%"));
            } else {
                data.add(new Content(modules[i], modulesProg[i] + "%", webcasts[i], webcastsProg[i] + "%"));
            }
        }
        return data;
    }
}
