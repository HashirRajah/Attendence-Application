package db;

//imports
import java.sql.*;

public class DatabaseConnection {
    public static void dbConnect() {
        String connectionString = new String(
                "jdbc:sqlserver://localhost:1433;DatabaseName=attendence_application_db;encrypt=true;trustServerCertificate=true;IntegratedSecurity=true");
        //
        try {
            try (Connection db_connect = DriverManager.getConnection(connectionString)) {
                System.out.println("Success");
            }

        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}
