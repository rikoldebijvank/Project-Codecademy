package app.database;

import app.domain.content.Webcast;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WebcastStatisticsDAO {
    private DatabaseController controller = new DatabaseController();

    // get alle benodigde data vanuit de sql
    public ObservableList<Webcast> getData() {
        ObservableList<Webcast> data = FXCollections.observableArrayList();
        String views = controller.returnSQL("SELECT TOP 3 Views AS topviews FROM Webcast ORDER BY views DESC", "topviews")
                .toString();
        String[] webcastsViews = views.split(";");

        String titles = controller.returnSQL("SELECT TOP 3 Title AS topviews FROM Webcast ORDER BY views DESC", "topviews")
                .toString();
        String[] webcastsTitles = titles.split(";");

        for (int i = 0; i < webcastsViews.length; i++) {
            data.add(new Webcast(webcastsTitles[i], Integer.valueOf(webcastsViews[i])));
        }
        return data;
    }
}
