package db;

//imports
import java.sql.*;
import styles.*;

public class DatabaseConnection {
    static final String URL = new String(
            "jdbc:sqlserver://localhost:1433;DatabaseName=attendance_application_db;encrypt=true;trustServerCertificate=true;IntegratedSecurity=true");
    public static Connection db_conn = null;

    public static void dbConnect() {
        //
        try {
            db_conn = DriverManager.getConnection(URL);
            // System.out.println("Success");
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public static void updateTheme(Theme theme) {
        dbConnect();
        //
        if (db_conn != null) {
            try {
                String sql = "UPDATE setting SET theme = '" + theme.getName() + "';";
                Statement update = db_conn.createStatement();
                // execute update
                update.executeUpdate(sql);
                // System.out.println(x);
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                try {
                    db_conn.close();
                } catch (Exception e) {

                }
            }
        }
    }
}
