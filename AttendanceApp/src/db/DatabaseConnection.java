package db;

//imports
import java.sql.*;
import styles.*;
import variables.Variables;
import backEnd.*;
import gui.*;
import pages.*;
import java.util.ArrayList;
import app_version.Configuration;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.net.URI;
import java.util.HashMap;

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
                        AppFrame.mainPanel.accountSettings = new AccountSettingsPage(Variables.activeTheme);
                        AppFrame.mainPanel.add(AppFrame.mainPanel.accountSettings, Variables.pages[6]);
                        Configuration.menuConfiguration();
                        AppFrame.menu.setupSideButton(Variables.activeTheme);
                        if (!Variables.userType.equals("admin")) {
                            fetchTodayClass();
                            MainPanel.homePage.setUpLabel(Variables.activeTheme);
                            MainPanel.cl.show(AppFrame.mainPanel, "home");
                            Variables.pagesStack.push("home");
                        }
                    }
                    if (Variables.userType.equals("admin")) {
                        AdminDashBoard dashboard = new AdminDashBoard(Variables.activeTheme);
                        AppFrame.mainPanel.add(dashboard, "dashboard");
                        MainPanel.cl.show(AppFrame.mainPanel, "dashboard");
                        Variables.pagesStack.push("dashboard");
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

    public static void fetchClasses() {
        dbConnect();
        MainPanel.classList.getAllClasses().getClassButtons().clear();
        if (db_conn != null) {
            try {
                String sql = "SELECT DISTINCT m.module_code, m.name FROM modules m";
                switch (Variables.userType) {
                    case "student":
                        sql += ", enroll e WHERE m.module_code = e.module_code AND e.studId = "
                                + Variables.userLoggedIn.getUsername() + ";";
                        break;
                    case "lecturer":
                        sql += ", room r WHERE m.module_code = r.module_code AND r.l_username = '"
                                + Variables.userLoggedIn.getUsername() + "';";
                        break;
                    case "admin":
                        sql += " WHERE progId = "
                                + Variables.programId + ";";
                        break;
                }
                // execute query
                Statement query = db_conn.createStatement();
                ResultSet results = query.executeQuery(sql);
                //
                ResultSetMetaData mtdt = results.getMetaData();
                // int numColumns = mtdt.getColumnCount();
                // System.out.println(numColumns);
                //
                while (results.next()) {
                    ModuleClass mod = new ModuleClass(results.getString(1), results.getString(2));

                    MainPanel.classList.getAllClasses().getClassButtons()
                            .add(new ClassButton(Variables.activeTheme, mod));

                }
                MainPanel.classList.getAllClasses().addClasses(Variables.activeTheme);
                // close
                query.close();
            } catch (Exception e) {
                System.out.println(e);
            } finally {

                try {
                    db_conn.close();
                } catch (Exception e) {

                }
            }
        }
        if (Variables.userType.equals("admin")) {
            MainPanel.cl.show(AppFrame.mainPanel, "classes");
            Variables.pagesStack.push("classes");
        }
    }

    public static void fetchClassesList(String module_code) {
        dbConnect();
        if (db_conn != null && MainPanel.classes.getAllClassesList().getClassButtons().isEmpty()) {
            try {
                String sql = "SELECT * FROM class c";
                switch (Variables.userType) {
                    case "student":
                        sql += " WHERE c.module_code = '" + module_code + "';";
                        break;
                    case "lecturer":
                        sql += ", room r WHERE r.classId = c.classId AND r.module_code = '" + module_code
                                + "' AND r.l_username = '"
                                + Variables.userLoggedIn.getUsername() + "';";
                        break;
                    case "admin":
                        sql += " WHERE c.module_code = '" + module_code + "';";
                        break;
                }
                // System.out.println(sql);
                // execute query
                Statement query = db_conn.createStatement();
                ResultSet results = query.executeQuery(sql);
                //
                ResultSetMetaData mtdt = results.getMetaData();
                // int numColumns = mtdt.getColumnCount();
                // System.out.println(numColumns);
                //
                while (results.next()) {
                    Classes c = new Classes(results.getInt(1), results.getString(2), results.getString(3),
                            results.getString(4), results.getString(5), results.getString(6));

                    MainPanel.classes.getAllClassesList().getClassButtons()
                            .add(new ClassButton(Variables.activeTheme, c));

                }
                MainPanel.classes.getAllClassesList().addClasses(Variables.activeTheme);
                // close
                query.close();
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

    public static void add_Attendance(String date, String classId, String sem, String week, Classes c) {
        dbConnect();
        if (db_conn != null) {
            try {
                String sql = "INSERT INTO attendance(date, classId, week, semester, status) VALUES('" + date + "', "
                        + classId + ", " + week + ", " + sem + ", 'completed');";
                String sql2 = "SELECT MAX(id) AS max_id FROM attendance WHERE classId = " + classId + ";";
                String tableName = "attendance_" + classId;
                String colName = "attd_";
                String sql4 = "SELECT a.studId, CONCAT(s.fname, ' ', s.lname) AS name FROM students s, "
                        + tableName
                        + " a WHERE a.studId = s.studId;";
                String sql5 = "SELECT m.module_code, m.name FROM class c, modules m WHERE c.module_code = m.module_code AND c.classId = "
                        + classId + ";";

                // System.out.println(sql);
                // execute query

                Statement query = db_conn.createStatement();
                boolean status = query.execute(sql);

                if (!status) {
                    //
                    ResultSet result = query.executeQuery(sql2);
                    int col = 1;
                    while (result.next()) {
                        col = result.getInt(1);
                    }
                    //
                    String mod_code = "";
                    String mod_name = "";
                    ResultSet module = query.executeQuery(sql5);
                    while (module.next()) {
                        mod_code = module.getString(1);
                        mod_name = module.getString(2);
                    }
                    //
                    colName += String.valueOf(col);
                    String sql3 = "ALTER TABLE " + tableName + " ADD " + colName + " VARCHAR(255);";
                    boolean status2 = query.execute(sql3);
                    // System.out.println(status2);
                    AppFrame.mainPanel.attendance = new AttendancePage(Variables.activeTheme, c,
                            new Attendance(col, date, Integer.parseInt(week), Integer.parseInt(sem), "completed"),
                            mod_code, mod_name);
                    if (!status2) {
                        // System.out.println("hey");
                        ResultSet students = query.executeQuery(sql4);
                        while (students.next()) {
                            MainPanel.attendance.getAttendanceBoard().getIds().add(students.getString(1));
                            MainPanel.attendance.getAttendanceBoard().getNames().add(students.getString(2));
                        }
                        //
                        AppFrame.mainPanel.attendance.getAttendanceBoard().setUpDetails(Variables.activeTheme);
                        AppFrame.mainPanel.attendance.getAttendanceBoard().setUpListOfStudents(Variables.activeTheme);
                        AppFrame.mainPanel.add(AppFrame.mainPanel.attendance, "attendance");
                        MainPanel.cl.show(AppFrame.mainPanel, "attendance");
                    }
                }
                //
                // close
                query.close();
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

    public static void saveAttendance(String classId, String attendanceId) {
        dbConnect();
        if (db_conn != null && AppFrame.mainPanel.attendance != null) {
            try {
                String tableName = "attendance_" + classId;
                String colName = "attd_" + attendanceId;
                String sql = "UPDATE " + tableName + " SET " + colName + " = '";
                Statement update = db_conn.createStatement();
                for (int i = 0; i < AppFrame.mainPanel.attendance.getAttendanceBoard().getPresence().size(); i++) {
                    String id = AppFrame.mainPanel.attendance.getAttendanceBoard().getIds().get(i);
                    String value = ((AppFrame.mainPanel.attendance.getAttendanceBoard().getPresence().get(i)
                            .isSelected()) ? "present" : "absent");
                    //
                    sql += value + "' WHERE studId = " + id + ";";
                    //
                    // System.out.println(sql);
                    update.execute(sql);
                    sql = "UPDATE " + tableName + " SET " + colName + " = '";
                }
                //

                MainPanel.cl.show(AppFrame.mainPanel, "attendance-choice");
                AppFrame.mainPanel.remove(AppFrame.mainPanel.attendance);
                AppFrame.mainPanel.attendance = null;
                update.close();
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

    public static void fetchAllAttendance(String classId, Classes cls) {
        dbConnect();
        if (db_conn != null) {
            try {
                String sql = "SELECT * FROM attendance WHERE classId = " + classId
                        + " ORDER BY date DESC, semester DESC, week DESC;";
                Statement query = db_conn.createStatement();
                ResultSet results = query.executeQuery(sql);
                ListAttendancePage attdList = new ListAttendancePage(Variables.activeTheme, cls);
                while (results.next()) {
                    Attendance attd = new Attendance(results.getInt(1), results.getString(2), results.getInt(4),
                            results.getInt(5), results.getString(6));
                    attdList.getAllAttendance().getattdList().add(attd);
                }
                //
                attdList.getAllAttendance().setUpView(Variables.activeTheme);
                AppFrame.mainPanel.add(attdList, "list-of-attendance");
                MainPanel.cl.show(AppFrame.mainPanel, "list-of-attendance");
                Variables.pagesStack.push("list-of-attendance");
                //
                query.close();
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

    public static void fetchAttendance(Classes classes, Attendance attd) {
        dbConnect();
        if (db_conn != null) {
            try {
                String tableName = "attendance_" + classes.getId();
                String colName = "attd_" + attd.getId();
                String sql = "SELECT a.studId, CONCAT(s.fname, ' ', s.lname) AS name, " + colName + " FROM students s, "
                        + tableName
                        + " a WHERE a.studId = s.studId;";
                //
                String sql2 = "SELECT m.module_code, m.name FROM class c, modules m WHERE c.module_code = m.module_code AND c.classId = "
                        + classes.getId() + ";";
                //
                Statement query = db_conn.createStatement();
                //
                String mod_code = "";
                String mod_name = "";
                ResultSet module = query.executeQuery(sql2);
                while (module.next()) {
                    mod_code = module.getString(1);
                    mod_name = module.getString(2);
                }
                //
                ResultSet results = query.executeQuery(sql);
                ViewAttendancePage vp = new ViewAttendancePage(Variables.activeTheme, classes, attd, mod_code,
                        mod_name);
                while (results.next()) {
                    vp.getAttendanceBoard().getIds().add(results.getString(1));
                    vp.getAttendanceBoard().getNames().add(results.getString(2));
                    vp.getAttendanceBoard().getPresence().add(results.getString(3));
                }
                //
                vp.getAttendanceBoard().setUpDetails(Variables.activeTheme);
                vp.getAttendanceBoard().setUpListOfStudents(Variables.activeTheme);
                //
                AppFrame.mainPanel.add(vp, "view-specific-attendance");
                MainPanel.cl.show(AppFrame.mainPanel, "view-specific-attendance");
                Variables.pagesStack.push("view-specific-attendance");
                //
                query.close();
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

    public static void fetchDepartments() {
        dbConnect();
        if (db_conn != null) {
            try {
                String sql = "SELECT * FROM department;";
                Statement query = db_conn.createStatement();
                //
                ResultSet depts = query.executeQuery(sql);
                ListOfDepartments allDept = new ListOfDepartments(Variables.activeTheme);
                while (depts.next()) {
                    Department dp = new Department(depts.getInt(1), depts.getString(2));
                    allDept.getAllDepartments().getdeptList().add(dp);
                }
                //
                allDept.getAllDepartments().setUpView(Variables.activeTheme);
                AppFrame.mainPanel.add(allDept, "list-of-departments");
                MainPanel.cl.show(AppFrame.mainPanel, "list-of-departments");
                Variables.pagesStack.push("list-of-departments");
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

    public static void fetchPrograms(Department dept) {
        dbConnect();
        if (db_conn != null) {
            try {
                String sql = "SELECT * FROM programs WHERE deptId = " + dept.getId() + ";";
                Statement query = db_conn.createStatement();
                //
                ResultSet depts = query.executeQuery(sql);
                ListOfProgramPage allProg = new ListOfProgramPage(Variables.activeTheme, dept);
                while (depts.next()) {
                    Program prog = new Program(depts.getInt(1), depts.getString(2), depts.getString(3));
                    allProg.getallProgram().getprogList().add(prog);
                }
                //
                allProg.getallProgram().setUpView(Variables.activeTheme);
                AppFrame.mainPanel.add(allProg, "list-of-programs");
                MainPanel.cl.show(AppFrame.mainPanel, "list-of-programs");
                Variables.pagesStack.push("list-of-programs");
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

    public static void downloadReport(Classes cls) {
        dbConnect();
        if (db_conn != null) {
            try {
                String tableName = "attendance_" + cls.getId();
                String sql = "SELECT * FROM " + tableName + ";";
                String sql2 = "SELECT * FROM class WHERE classId = " + cls.getId() + ";";
                Statement query = db_conn.createStatement();
                //
                ResultSet attd = query.executeQuery(sql);
                ResultSetMetaData meta = attd.getMetaData();
                //
                String[] cols = new String[meta.getColumnCount() - 1];
                int start = 2;
                for (int i = 0; i < cols.length; i++) {
                    String[] id = meta.getColumnName(start).split("_");
                    cols[i] = id[1];
                    // System.out.println(cols[i]);
                    start++;
                }

                Attendance[] allAttd = new Attendance[cols.length];
                String sql3 = "SELECT * FROM attendance WHERE id = ";
                for (int i = 0; i < allAttd.length; i++) {
                    sql3 += cols[i] + ";";
                    // System.out.println(sql3);
                    ResultSet results = query.executeQuery(sql3);
                    while (results.next()) {
                        allAttd[i] = new Attendance(results.getInt(1), results.getString(2), results.getInt(4),
                                results.getInt(5), results.getString(6));
                    }
                    sql3 = "SELECT * FROM attendance WHERE id = ";
                }
                // code here
                ResultSet c = query.executeQuery(sql2);
                ResultSetMetaData m = c.getMetaData();
                String url = System.getProperty("user.home");
                Formatter writer = new Formatter(url + "\\downloaded_report.txt");
                url += "\\downloaded_report_csv.csv";
                Formatter writer2 = new Formatter(url);
                while (c.next()) {
                    writer.format(
                            "%s:%15s\n\n%s:%15s\n\n%s:%15s\n\n%s:%15s\n\n%s:%15s\n\n%s:%15s\n\n%s:%15s\n\n%s:%15s\n\n%s:%15s\n\n%s:%15s\n\n",
                            m.getColumnName(1), c.getString(1), m.getColumnName(2), c.getString(2), m.getColumnName(3),
                            c.getString(3), m.getColumnName(4), c.getString(4), m.getColumnName(5), c.getString(5),
                            m.getColumnName(6), c.getString(6), m.getColumnName(7), c.getString(7), m.getColumnName(8),
                            c.getString(8), m.getColumnName(9), c.getString(9), m.getColumnName(10), c.getString(10));
                    //
                    writer2.format(
                            "%s,%s\n%s,%15s\n\n%s,%s\n%s,%s\n%s,%s\n%s,%s\n%s,%s\n%s,%s\n%s,%s\n%s,%s\n",
                            m.getColumnName(1), c.getString(1), m.getColumnName(2), c.getString(2), m.getColumnName(3),
                            c.getString(3), m.getColumnName(4), c.getString(4), m.getColumnName(5), c.getString(5),
                            m.getColumnName(6), c.getString(6), m.getColumnName(7), c.getString(7), m.getColumnName(8),
                            c.getString(8), m.getColumnName(9), c.getString(9), m.getColumnName(10), c.getString(10));
                    //
                }
                writer.format("\n\n\n\nStudent ID");
                writer2.format("Student ID,");
                for (int i = 0; i < allAttd.length; i++) {
                    writer.format("%20s", allAttd[i].getDate());
                    writer2.format("%s,", allAttd[i].getDate());
                }
                writer2.format("\n");
                writer.format("\n");
                ResultSet attd2 = query.executeQuery(sql);
                while (attd2.next()) {
                    writer.format("%-8s", attd2.getString(1));
                    writer2.format("%s,", attd2.getString(1));
                    int index = 2;
                    for (int j = 0; j < allAttd.length; j++) {
                        writer.format("%20s", attd2.getString(index));
                        writer2.format("%s,", attd2.getString(index));
                        index++;
                    }
                    writer.format("\n");
                    writer2.format("\n");
                }
                //
                MainPanel.info
                        .setMyText(
                                "<html>Report downloaded Successfully<br />File path: " + url + "</html>");
                MainPanel.cl.show(AppFrame.mainPanel, "info");
                writer.close();
                writer2.close();
                url = url.replace('\\', '/');
                java.awt.Desktop.getDesktop().browse(new URI(url));

                //
                query.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    db_conn.close();
                } catch (Exception e) {

                }
            }
        }
    }

    public static void fetchTodayClass() {
        dbConnect();
        if (db_conn != null) {
            try {
                // code here
                String sql = "SELECT * FROM class c";
                //
                switch (Variables.userType) {
                    case "lecturer":
                        sql += " WHERE day_of_week = DATENAME(WEEKDAY, GETDATE()) AND module_code IN (SELECT module_code FROM room WHERE l_username = '"
                                + Variables.userLoggedIn.getUsername() + "');";
                        break;
                    case "student":
                        sql += " WHERE day_of_week = DATENAME(WEEKDAY, GETDATE()) AND module_code IN (SELECT module_code FROM enroll WHERE studId = "
                                + Variables.userLoggedIn.getUsername() + ");";
                        break;
                }
                Statement query = db_conn.createStatement();
                ResultSet results = query.executeQuery(sql);
                MainPanel.homePage.getAllClassesBtn().clear();
                while (results.next()) {
                    Classes c = new Classes(results.getInt(1), results.getString(2), results.getString(3),
                            results.getString(4), results.getString(5), results.getString(6));

                    MainPanel.homePage.getAllClassesBtn().add(new ClassButton(Variables.activeTheme, c));
                }

                //
                query.close();
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

    public static void addStudent(Student stud) {
        dbConnect();
        if (db_conn != null) {
            try {
                // code here
                String sql = "INSERT INTO students(fname, lname, gender, address, email, contact, progId, date_of_birth, grLevel, grName) VALUES(?,?,?,?,?,?,?,?,?,?);";
                PreparedStatement stmt = db_conn.prepareStatement(sql);
                stmt.setString(1, stud.getFirstName());
                stmt.setString(2, stud.getLastName());
                stmt.setString(3, Character.toString(stud.getGender()));
                stmt.setString(4, stud.getAddress());
                stmt.setString(5, stud.getEmail());
                stmt.setString(6, stud.getContactNo());
                // stmt.setString(7, stud.getType());
                stmt.setString(8, stud.getDateOfBirth());
                stmt.setString(9, stud.getDateOfBirth());
                //
                String password = PasswordManipulation.generatePassword();
                MainPanel.info.setMyText("<html>Insert Successful<br />Password generated: " + password + "</html>");
                MainPanel.cl.show(AppFrame.mainPanel, "info");
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

    public static void addLecturer(Lecturer lec) {
        dbConnect();
        if (db_conn != null) {
            try {
                // code here
                String sql = "INSERT INTO lecturer VALUES(?,?,?,?,?,?,?,?,?)";
                PreparedStatement stmt = db_conn.prepareStatement(sql);
                stmt.setString(1, lec.getUsername());
                stmt.setString(2, lec.getFirstName());
                stmt.setString(3, lec.getLastName());
                stmt.setString(4, Character.toString(lec.getGender()));
                stmt.setString(5, lec.getAddress());
                stmt.setString(6, lec.getEmail());
                stmt.setString(7, lec.getContactNo());
                stmt.setString(8, lec.getType());
                stmt.setString(9, lec.getDateOfBirth());
                //
                String password = PasswordManipulation.generatePassword();
                String sql2 = "INSERT INTO users VALUES(?,?,?)";
                PreparedStatement stmt2 = db_conn.prepareStatement(sql2);
                stmt2.setString(1, lec.getUsername());
                stmt2.setString(2, PasswordManipulation.hash(password));
                stmt2.setString(3, "lecturer");
                //
                // stmt2.execute();
                if (!stmt.execute()) {
                    if (!stmt2.execute()) {
                        MainPanel.info
                                .setMyText("<html>Insert Successful<br />Password generated: " + password + "</html>");
                        MainPanel.cl.show(AppFrame.mainPanel, "info");
                    }
                }
                //
                stmt.close();
                stmt2.close();
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

    public static void downloadDefaulterList(Classes cls) {
        dbConnect();
        if (db_conn != null) {
            try {
                int absenceLimitPercentage = 40;
                String tableName = "attendance_" + cls.getId();
                String sql = "SELECT * FROM " + tableName + ";";
                String sql2 = "SELECT * FROM class WHERE classId = " + cls.getId() + ";";
                Statement query = db_conn.createStatement();
                //
                ResultSet attd = query.executeQuery(sql);
                ResultSetMetaData meta = attd.getMetaData();
                //
                ResultSet attd3 = query.executeQuery(sql);
                int size = 0;
                while (attd3.next()) {
                    size++;
                }
                int[] ids = new int[size], absence = new int[size];
                //
                String[] cols = new String[meta.getColumnCount() - 1];
                int start = 2;
                for (int i = 0; i < cols.length; i++) {
                    String[] id = meta.getColumnName(start).split("_");
                    cols[i] = id[1];
                    // System.out.println(cols[i]);
                    start++;
                }

                ResultSet attd2 = query.executeQuery(sql);
                int index = 0;
                while (attd2.next()) {
                    ids[index] = attd2.getInt(1);
                    index++;
                }

                String sql3 = "SELECT studId FROM " + tableName + " WHERE attd_";
                for (int i = 0; i < cols.length; i++) {
                    sql3 += cols[i] + " = 'absent';";
                    // System.out.println(sql3);
                    ResultSet results = query.executeQuery(sql3);
                    while (results.next()) {
                        for (int j = 0; j < ids.length; j++) {
                            if (ids[j] == results.getInt(1)) {
                                absence[j]++;
                                break;
                            }
                        }
                    }
                    sql3 = "SELECT studId FROM " + tableName + " WHERE attd_";
                }
                // code here
                ResultSet c = query.executeQuery(sql2);
                ResultSetMetaData m = c.getMetaData();
                String url = System.getProperty("user.home") + "\\downloaded_defaulter_list_csv.csv";
                Formatter writer2 = new Formatter(url);
                while (c.next()) {
                    writer2.format(
                            "%s,%s\n%s,%15s\n\n%s,%s\n%s,%s\n%s,%s\n%s,%s\n%s,%s\n%s,%s\n%s,%s\n%s,%s\n",
                            m.getColumnName(1), c.getString(1), m.getColumnName(2), c.getString(2), m.getColumnName(3),
                            c.getString(3), m.getColumnName(4), c.getString(4), m.getColumnName(5), c.getString(5),
                            m.getColumnName(6), c.getString(6), m.getColumnName(7), c.getString(7), m.getColumnName(8),
                            c.getString(8), m.getColumnName(9), c.getString(9), m.getColumnName(10), c.getString(10));
                }
                ArrayList<ArrayList<Integer>> defaulterList = new ArrayList<ArrayList<Integer>>();

                for (int i = 0; i < ids.length; i++) {
                    // System.out.println();
                    if ((int) ((absence[i] / (float) cols.length) * 100) > absenceLimitPercentage) {
                        // System.out.println("hey");
                        ArrayList<Integer> badStud = new ArrayList<Integer>();
                        badStud.add(ids[i]);
                        badStud.add(absence[i]);
                        badStud.add((int) ((absence[i] / (float) cols.length) * 100));
                        defaulterList.add(badStud);
                    }
                }

                writer2.format("Student ID,absences,percentage_absences\n");
                for (int i = 0; i < defaulterList.size(); i++) {
                    writer2.format("%d,%d,%d\n", defaulterList.get(i).get(0), defaulterList.get(i).get(1),
                            defaulterList.get(i).get(2));
                }

                //
                MainPanel.info
                        .setMyText(
                                "<html>Report downloaded Successfully<br />File path: " + url + "</html>");
                MainPanel.cl.show(AppFrame.mainPanel, "info");

                writer2.close();
                url = url.replace('\\', '/');
                java.awt.Desktop.getDesktop().browse(new URI(url));

                //
                query.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    db_conn.close();
                } catch (Exception e) {

                }
            }
        }
    }

}
