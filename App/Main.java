package App;

import javafx.application.Application;
import App.GUI.Gui;

import App.GUI.Gui;
import javafx.application.Application;

public class Main {

    public static void main(String[] args) {

        Application.launch(Gui.class);

        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=Codecademy;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";

        // DatabaseController control = new DatabaseController();
        // String signInSQL = "SELECT * FROM Users";
        // System.out.println(control.checkSQLEmail("rik@rik.nl"));

    }
}