package App;

import java.sql.*;
import java.time.LocalDate;

public class DatabaseController {
    private String connectionUrl = "jdbc:sqlserver://localhost;databaseName=Codecademy;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public void executeSQL(String sqlString) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);
            stmt = con.createStatement();
            rs = stmt.executeQuery(sqlString);
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String checkSQLEmail(String email, String userType) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT Email FROM " + userType);
            while (rs.next()) {
                String passwordIncluded = rs.getString("Email");
                if (passwordIncluded.equals(email)) {
                    return passwordIncluded;
                }
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkSQLPassword(String email, String password, String userType) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT Password FROM " + userType + " WHERE Email = '" + email + "'");
            while (rs.next()) {
                String passwordIncluded = rs.getString("Password");
                if (passwordIncluded.equals(password)) {
                    return passwordIncluded;
                }
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createStudent(String name, String email, String password, LocalDate dateOfBirth, String address,
            String residence,
            String country, String gender) {
        executeSQL("INSERT INTO Student VALUES ('" + email + "', '" + name + "', '" + dateOfBirth
                + "', '" + gender + "', '" + address + "', '" + residence + "', '" + country
                + "') INSERT INTO Students VALUES ('" + email + "', '" + password + "')");
    }

    public void createAdmin(String name, String email, String password) {
        executeSQL("INSERT INTO Admins VALUES ('" + name + "', '" + email + "', '" + password + "')");
    }

    public void createCourse(String name, String subject, String intro, String difficulty, String adminEmail) {
        executeSQL("INSERT INTO Course VALUES ('" + name + "', '" + subject + "', '" + intro + "', '" + difficulty
                + "', '" + adminEmail + "')");
    }
}
