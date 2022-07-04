package app_version;

//imports
import variables.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import db.*;
import java.sql.*;

public class Configuration {
    public static void runSetUp() {
        DatabaseConnection.dbConnect();
        // if connection successfull
        if (DatabaseConnection.db_conn != null) {
            //
            Statement query = null;
            try {
                // sql
                String sql = "SELECT * FROM setting;";
                query = DatabaseConnection.db_conn.createStatement();
                // execute query
                ResultSet result = query.executeQuery(sql);
                //
                String theme = "Default";
                //
                while (result.next()) {
                    theme = result.getString(2);
                }
                Variables.activeTheme = Variables.allThemes.get(theme);
            } catch (Exception e) {

            } finally {
                try {
                    DatabaseConnection.db_conn.close();
                } catch (Exception e) {

                }
            }
        }
    }

    public static void populateAppData() {
        Variables.appData.put("Name", "MoAttendance");
        Variables.appData.put("Version", "1.0");
        // populate themes hashmap
        for (int i = 0; i < Variables.themes.length; i++) {
            Variables.allThemes.put(Variables.themes[i].getName(), Variables.themes[i]);
        }
        // populate menuIcons
        for (int i = 0; i < Variables.allMenu.length; i++) {
            Variables.menuIcons.put(Variables.allMenu[i], Variables.iconFilePath[i]);
        }
    }

    public static void menuConfiguration() {
        Variables.activeMenu = new ArrayList<String>();
        if (Variables.loggedIn) {
            switch (Variables.userType) {
                case "admin":
                    for (int i = 0; i < Variables.adminMenu.length; i++) {
                        Variables.activeMenu.add(Variables.adminMenu[i]);
                    }
                    break;
                case "lecturer":
                    for (int i = 0; i < Variables.lecturerMenu.length; i++) {
                        Variables.activeMenu.add(Variables.lecturerMenu[i]);
                    }
                    break;
                case "student":
                    for (int i = 0; i < Variables.studentMenu.length; i++) {
                        Variables.activeMenu.add(Variables.studentMenu[i]);
                    }
                    break;
            }
        } else {
            Variables.activeMenu.add("Login");
        }
    }
}
