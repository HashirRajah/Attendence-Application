package db;

//imports
import java.sql.*;
import styles.*;
import variables.Variables;
import backEnd.*;

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

    public static void login(String username, String password) {
        dbConnect();
        //
        if (db_conn != null) {
            String passwd = "";
            String type = "";
            //
            try {
                // sql
                String sql = "SELECT * FROM users WHERE username = ?;";
                PreparedStatement stmt = db_conn.prepareStatement(sql);
                //
                stmt.setString(1, username);
                ResultSet result = stmt.executeQuery();
                //
                while (result.next()) {
                    passwd = result.getString(2);
                    type = result.getString(3);
                    break;
                }
                System.out.println(passwd);
                if (PasswordManipulation.validatePassword(password, passwd)) {
                    Variables.loggedIn = true;
                    // sql
                    sql = "SELECT * FROM";
                    //
                    switch (type) {
                        case "admin":
                            sql += " admin WHERE a_username = ?;";
                            PreparedStatement stmtA = db_conn.prepareStatement(sql);
                            stmtA.setString(1, username);
                            result = stmtA.executeQuery();
                            break;
                        case "lecturer":
                            sql += " lecturer WHERE l_username = ?;";
                            PreparedStatement stmtL = db_conn.prepareStatement(sql);
                            stmtL.setString(1, username);
                            result = stmtL.executeQuery();
                            break;
                        case "student":
                            sql += " students WHERE studId = ?;";
                            PreparedStatement stmtS = db_conn.prepareStatement(sql);
                            stmtS.setInt(1, Integer.parseInt(username));
                            result = stmtS.executeQuery();
                            break;
                    }

                }
            } catch (Exception e) {

            } finally {
                try {
                    db_conn.close();
                } catch (Exception e) {

                }
            }
        }
    }
}
