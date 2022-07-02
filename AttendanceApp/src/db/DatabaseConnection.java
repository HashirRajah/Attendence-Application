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
                        MainPanel.homePage.setUpLabel(Variables.activeTheme);
                        MainPanel.cl.show(AppFrame.mainPanel, "home");
                        Variables.pagesStack.push("home");
                    }
                    if (Variables.userType.equals("admin")) {
                        AdminDashBoard dashboard = new AdminDashBoard(Variables.activeTheme);
                        AppFrame.mainPanel.add(dashboard, "dashboard");
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
        if (db_conn != null && MainPanel.classList.getAllClasses().getClassButtons().isEmpty()) {
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

    public static void fetchStudents(Classes c) {
        dbConnect();
        if (db_conn != null && MainPanel.classes.getAllClassesList().getClassButtons().isEmpty()) {
            try {
                String sql = "SELECT * FROM class c";
                switch (Variables.userType) {
                    case "student":
                        sql += " WHERE c.module_code = '" + c.getMode() + "';";
                        break;
                    case "lecturer":
                        sql += ", room r WHERE r.classId = c.classId AND r.module_code = '" + c.getMode()
                                + "' AND r.l_username = '"
                                + Variables.userLoggedIn.getUsername() + "';";
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
}
