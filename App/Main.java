package App;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=Codecademy;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";

        Connection con = null;

        Statement stmt = null;

        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            String SQL = "SELECT * FROM Certificate";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);

            System.out.print(String.format("| %33s | %33s | %33s |\n", " ", " ", " ").replace(" ", "-"));

        }

        catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (Exception e) {
                }
            if (stmt != null)
                try {
                    stmt.close();
                } catch (Exception e) {
                }
            if (con != null)
                try {
                    con.close();
                } catch (Exception e) {
                }
        }
    }
}