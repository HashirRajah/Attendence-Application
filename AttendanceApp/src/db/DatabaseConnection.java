package db;

//imports
import java.sql.*;
import styles.*;
import variables.Variables;
import backEnd.*;
import gui.AppFrame;
import gui.MainPanel;

import java.util.ArrayList;

import app_version.Configuration;

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
                update.close();
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
                // System.out.println(passwd);
                if (PasswordManipulation.validatePassword(password, passwd)) {
                    Variables.loggedIn = true;
                    // System.out.println("logged in");
                    // sql
                    sql = "SELECT * FROM";
                    //
                    ResultSet userInfo;
                    switch (type) {
                        case "admin":
                            sql += " admin WHERE a_username = ?;";
                            break;
                        case "lecturer":
                            sql += " lecturer WHERE l_username = ?;";
                            break;
                        case "student":
                            sql += " students WHERE studId = ?;";
                            break;
                    }
                    //
                    PreparedStatement stmt2 = db_conn.prepareStatement(sql);
                    if (type.equals("student")) {
                        stmt2.setInt(1, Integer.parseInt(username));
                    } else {
                        stmt2.setString(1, username);
                    }
                    userInfo = stmt2.executeQuery();
                    //
                    ArrayList<String> userData = new ArrayList<String>();
                    //
                    ResultSetMetaData mtdt = userInfo.getMetaData();
                    int numColumns = mtdt.getColumnCount();
                    // System.out.println(numColumns);
                    while (userInfo.next()) {
                        for (int i = 1; i <= numColumns; i++) {
                            userData.add(userInfo.getString(i));
                            // System.out.println(userInfo.getString(i));
                        }
                        break;
                    }
                    //
                    switch (type) {
                        case "admin":
                            Variables.userLoggedIn = new Admin(username, userData.get(3).charAt(0), userData.get(5),
                                    userData.get(1), userData.get(2), userData.get(4), userData.get(6),
                                    passwd, userData.get(7));
                            Variables.userType = "admin";
                            break;
                        case "lecturer":
                            Variables.userLoggedIn = new Lecturer(username, userData.get(3).charAt(0), userData.get(5),
                                    userData.get(1), userData.get(2), userData.get(4),
                                    userData.get(6), passwd, userData.get(8), userData.get(7));
                            Variables.userType = "lecturer";
                            break;
                        case "student":
                            Variables.userLoggedIn = new Student(username, userData.get(3).charAt(0),
                                    userData.get(5), userData.get(1),
                                    userData.get(2), userData.get(4), userData.get(6),
                                    passwd, userData.get(8));
                            Variables.userType = "student";
                            break;
                    }
                    // System.out.println(Variables.userLoggedIn);
                    if (Variables.userLoggedIn != null) {
                        Configuration.menuConfiguration();
                        AppFrame.menu.setupSideButton(Variables.activeTheme);
                        MainPanel.cl.show(AppFrame.mainPanel, "settings");
                    }
                    // close all statements
                    stmt.close();
                    stmt2.close();
                } else {
                    MainPanel.login.errorMsg.setVisible(true);
                    MainPanel.login.repaint();
                }
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
