package pages;

//imports
import javax.swing.*;
import backEnd.Attendance;
import backEnd.Classes;
import backEnd.ModuleClass;
import java.awt.*;
import styles.*;
import variables.Variables;
import gui.*;
import java.util.ArrayList;
import javax.print.AttributeException;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import db.*;
import java.awt.event.*;
import java.util.regex.*;

public class ViewAttendancePage extends JScrollPane {
    //
    private AttendancePanel attendanceBoard;
    private Attendance attendance;
    private Classes c;
    // private ClassButton classButton;

    public ViewAttendancePage(Theme theme, Classes cl, Attendance attd, String code, String name) {
        super();
        this.c = cl;
        this.attendance = attd;
        // instantiate vars
        attendanceBoard = new AttendancePanel(theme, name, code);
        this.setViewportView(attendanceBoard);

    }

    public AttendancePanel getAttendanceBoard() {
        return attendanceBoard;
    }

    public class AttendancePanel extends JPanel {
        //
        private JLabel title, noOfStud, moduleName, moduleCode, LecturerName, week, semester, date, search,
                nameOfStudents,
                attendanceStatus, filler;
        private ArrayList<String> ids = new ArrayList<String>(), names = new ArrayList<String>();

        // private JLabel

        private JTextField titletxt, noOfStudtxt, moduleNametxt, moduleCodetxt, LecturerNametxt, weektxt,
                semestertxt, datetxt, searchtxt;

        private JPanel moduleDetails, titlePanel, attendanceTable, Container, TableCol, attendanceContainer;

        private JLabel studentID;

        private ModuleClass mod;
        private ArrayList<String> presense;

        //
        public AttendancePanel(Theme theme, String module_name, String module_code) {
            super();
            this.setLayout(new BorderLayout());
            this.setBackground(theme.getMainColor());
            this.mod = new ModuleClass(module_code, module_name);
            presense = new ArrayList<String>();
            //

            // instantiating vars
            // attendance;

            title = new CenteredTextLabel("A T T E N D A N C E", theme.getContentColor(), Variables.PAGES_TITLE);

            moduleName = new JLabel("Module Name:");
            LecturerName = new JLabel("Lecturer Name:");
            moduleCode = new JLabel("Module Code: ");
            noOfStud = new JLabel("No of Students");

            week = new JLabel("Week");
            semester = new JLabel("Semester");
            date = new JLabel("Date");
            filler = new JLabel();

            nameOfStudents = new JLabel("Name of Students");
            attendanceStatus = new JLabel("Attendance");
            studentID = new JLabel("Student ID");

            nameOfStudents.setBorder(BorderFactory.createLineBorder(theme.getButtonColor(), 2));
            attendanceStatus.setBorder(BorderFactory.createLineBorder(theme.getButtonColor(), 2));
            studentID.setBorder(BorderFactory.createLineBorder(theme.getButtonColor(), 2));

            nameOfStudents.setForeground(theme.getContentColor());
            attendanceStatus.setForeground(theme.getContentColor());
            studentID.setForeground(theme.getContentColor());

            // TextField

            // COLORS

            // label desing
            // moduleName.setBackground(theme.getContentColor());
            // LecturerName.setBackground(theme.getContentColor());
            // moduleCode.setBackground(theme.getContentColor());
            // noOfStud.setBackground(theme.getContentColor());

            // week.setBackground(theme.getContentColor());
            // semester.setBackground(theme.getContentColor());
            // date.setBackground(theme.getContentColor());

            //

            // .setBackground(theme.getMainColor());
            moduleName.setForeground(theme.getContentColor());
            LecturerName.setForeground(theme.getContentColor());
            moduleCode.setForeground(theme.getContentColor());
            noOfStud.setForeground(theme.getContentColor());
            // search.setForeground(theme.getFontColor());

            week.setForeground(theme.getContentColor());
            semester.setForeground(theme.getContentColor());
            date.setForeground(theme.getContentColor());

            // Panels
            Container = new JPanel();
            moduleDetails = new JPanel();
            attendanceTable = new JPanel();
            titlePanel = new JPanel();
            // earch = new JPanel();

            titlePanel.add(title);
            titlePanel.setBackground(theme.getMainColor());

            // MODULE DETAILS PANEL
            moduleDetails.setBackground(theme.getMainColor());
            moduleDetails.setBorder(BorderFactory.createEmptyBorder(15, 300, 15, 300));
            moduleDetails.setLayout(new GridLayout(9, 2, 5, 5));

            // ATTENDANCE TABLE
            attendanceContainer = new JPanel();
            attendanceContainer.setLayout(new BorderLayout());
            attendanceContainer.setBackground(theme.getMainColor());

            TableCol = new JPanel();
            TableCol.setLayout(new GridLayout(1, 3, 0, 5));
            TableCol.add(studentID);
            TableCol.add(nameOfStudents);
            TableCol.add(attendanceStatus);
            studentID.setForeground(theme.getFontColor());
            nameOfStudents.setForeground(theme.getFontColor());
            attendanceStatus.setForeground(theme.getFontColor());

            TableCol.setBackground(theme.getMenuColor());
            TableCol.setForeground(theme.getFontColor());

            attendanceContainer.add(TableCol, BorderLayout.NORTH);
            attendanceContainer.add(attendanceTable, BorderLayout.CENTER);
            attendanceContainer.setBorder(BorderFactory.createLineBorder(theme.getButtonColor(), 2));
            attendanceContainer.setBackground(theme.getMainColor());

            attendanceContainer.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));

            // attendanceTable.add(nameOfStudents);
            // attendanceTable.add(attendanceStatus);

            Container.setLayout(new BorderLayout());

            Container.add(moduleDetails, BorderLayout.NORTH);
            Container.add(attendanceContainer, BorderLayout.CENTER);

            this.add(titlePanel, BorderLayout.NORTH);
            this.add(Container, BorderLayout.CENTER);

        }

        public ArrayList<String> getIds() {
            return this.ids;
        }

        public ArrayList<String> getNames() {
            return this.names;
        }

        public void setUpListOfStudents(Theme theme) {
            attendanceTable.removeAll();
            //
            //
            Border idBorder = BorderFactory.createLineBorder(theme.getButtonColor(), 2);
            Border tableBorder = BorderFactory.createLineBorder(theme.getButtonColor(), 2);
            //
            attendanceTable.setLayout(new GridLayout(ids.size(), 3, 0, 0));
            attendanceTable.setBorder(tableBorder);
            attendanceTable.setBackground(theme.getMainColor());
            for (int i = 0; i < ids.size(); i++) {
                JLabel id = new JLabel(ids.get(i));
                id.setBorder(idBorder);
                id.setForeground(theme.getContentColor());
                id.setFont(new Font("consolas", Font.PLAIN, 25));
                //
                JLabel name = new JLabel(names.get(i));
                name.setForeground(theme.getContentColor());
                name.setBorder(idBorder);
                name.setFont(new Font("consolas", Font.PLAIN, 25));
                //
                JLabel presenceStatus = new JLabel(presense.get(i));
                presenceStatus.setFont(new Font("consolas", Font.PLAIN, 25));
                presenceStatus.setForeground(theme.getContentColor());
                presenceStatus.setBorder(idBorder);

                attendanceTable.add(id);
                attendanceTable.add(name);
                attendanceTable.add(presenceStatus);
            }
            attendanceTable.revalidate();
            validate();
            attendanceTable.repaint();

        }

        public void setUpDetails(Theme theme) {
            //
            moduleDetails.removeAll();
            //
            moduleNametxt = new JTextField(mod.getName());
            LecturerNametxt = new JTextField(
                    Variables.userLoggedIn.getFirstName() + " " + Variables.userLoggedIn.getLastName());
            moduleCodetxt = new JTextField(mod.getModuleCode());
            noOfStudtxt = new JTextField(String.valueOf(ids.size()));
            weektxt = new JTextField(String.valueOf(attendance.getWeek()));
            semestertxt = new JTextField(String.valueOf(attendance.getSemester()));
            datetxt = new JTextField(attendance.getDate());
            searchtxt = new JTextField("Search Student here");
            //
            // System.out.println(ids.size());
            // System.out.println(attendance.getWeek());
            // System.out.println(attendance.getSemester());
            //
            moduleNametxt.setEditable(false);
            LecturerNametxt.setEditable(false);
            moduleCodetxt.setEditable(false);
            noOfStudtxt.setEditable(false);
            weektxt.setEditable(false);
            semestertxt.setEditable(false);
            datetxt.setEditable(false);
            //
            // //textfield design
            moduleNametxt.setBackground(theme.getMainColor());
            LecturerNametxt.setBackground(theme.getMainColor());
            moduleCodetxt.setBackground(theme.getMainColor());
            noOfStudtxt.setBackground(theme.getMainColor());
            weektxt.setBackground(theme.getMainColor());
            semestertxt.setBackground(theme.getMainColor());
            datetxt.setBackground(theme.getMainColor());
            searchtxt.setBackground(theme.getMainColor());

            moduleNametxt.setForeground(theme.getContentColor());
            LecturerNametxt.setForeground(theme.getContentColor());
            moduleCodetxt.setForeground(theme.getContentColor());
            noOfStudtxt.setForeground(theme.getContentColor());
            weektxt.setForeground(theme.getContentColor());
            semestertxt.setForeground(theme.getContentColor());
            datetxt.setForeground(theme.getContentColor());
            searchtxt.setForeground(theme.getContentColor());
            //
            Border border = BorderFactory.createLineBorder(theme.getMainColor(), 2);
            moduleNametxt.setBorder(border);
            LecturerNametxt.setBorder(border);
            moduleCodetxt.setBorder(border);
            noOfStudtxt.setBorder(border);
            weektxt.setBorder(border);
            semestertxt.setBorder(border);
            datetxt.setBorder(border);
            searchtxt.setBorder(BorderFactory.createLineBorder(theme.getContentColor(), 3));
            searchtxt.addKeyListener(new KeyHandler());

            // add
            moduleDetails.add(moduleCode);
            moduleDetails.add(moduleCodetxt);
            moduleDetails.add(moduleName);
            moduleDetails.add(moduleNametxt);
            moduleDetails.add(LecturerName);
            moduleDetails.add(LecturerNametxt);
            moduleDetails.add(noOfStud);
            moduleDetails.add(noOfStudtxt);
            moduleDetails.add(semester);
            moduleDetails.add(semestertxt);
            moduleDetails.add(week);
            moduleDetails.add(weektxt);
            moduleDetails.add(date);
            moduleDetails.add(datetxt);
            moduleDetails.add(searchtxt);
            moduleDetails.add(filler);
            //
            moduleDetails.revalidate();
            validate();
            moduleDetails.repaint();
        }

        public void setTheme(Theme theme) {

        }

        public ArrayList<String> getPresence() {
            return this.presense;
        }

        public void clearAll() {
            presense.clear();
            ids.clear();
            names.clear();
        }

        private void searchStud(String nameText, Theme theme) {
            nameText = nameText.toLowerCase();
            String regex = "\\.*" + nameText + "\\.*";
            for (int i = 0; i < names.size(); i++) {
                if (Pattern.matches(regex, names.get(i).toLowerCase())) {
                    setUpListOfStudents(theme);
                    int n = (1 + (2 * i)) + i;
                    attendanceTable.getComponent(n - 1).setForeground(Color.RED);
                    attendanceTable.getComponent(n).setForeground(Color.RED);
                    attendanceTable.getComponent(n + 1).setForeground(Color.RED);
                    // System.out.println("works");
                    break;
                }
            }
        }

        private class KeyHandler implements KeyListener {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    searchStud(searchtxt.getText(), Variables.activeTheme);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub

            }

        }
    }
}
