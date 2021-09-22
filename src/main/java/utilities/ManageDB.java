package utilities;

import java.sql.DriverManager;

public class ManageDB extends CommonOps {

    public static void openConnection(String dbURL, String user, String pass) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL, user, pass);
            stmt = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Error occurred while connecting to the DB, see details: " + e);
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println("Error occurred while closing the DB, see details: " + e);
        }
    }
}
