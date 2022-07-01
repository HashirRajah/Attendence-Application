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

public class AttendancePage extends JScrollPane {
    //
    private AttendancePanel attendanceBoard;
    private Attendance attendance;
    private Classes c;
    // private ClassButton classButton;

    public AttendancePage(Theme theme, Classes cl, Attendance attd, String code, String name) {
        super();
        this.c = cl;
        this.attendance = attd;
        // instantiate vars
        attendanceBoard = new AttendancePanel(theme, code, name);
        this.setViewportView(attendanceBoard);

    }

    public AttendancePanel getAttendanceBoard() {
        return attendanceBoard;
    }

    public class AttendancePanel extends JPanel {
        //
        private JLabel title, noOfStud, moduleName, moduleCode, LecturerName, week, semester, date, nameOfStudents,
                attendanceStatus;
        private ArrayList<String> ids = new ArrayList<String>(), names = new ArrayList<String>();

        // private JLabel

        private JTextField titletxt, noOfStudtxt, moduleNametxt, moduleCodetxt, LecturerNametxt, searchtxt, weektxt,
                semestertxt, datetxt;

        private JPanel moduleDetails, titlePanel, attendanceTable, Container, TableCol, attendanceContainer;

        private JLabel studentID;

        private ModuleClass mod;
        private ArrayList<JCheckBox> presense;
        private ButtonStyle1 save;

        //
        public AttendancePanel(Theme theme, String module_name, String module_code) {
            super();
            this.setLayout(new BorderLayout());
            this.setBackground(theme.getMainColor());
            this.mod = new ModuleClass(module_code, module_name);

            //
            save = new ButtonStyle1(theme, theme.getFontColor(), 2, "Save", 50, 50);
            save.addActionListener(e -> {
                DatabaseConnection.saveAttendance(String.valueOf(c.getId()), String.valueOf(attendance.getId()));
            });

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
            moduleName.setForeground(theme.getFontColor());
            LecturerName.setForeground(theme.getFontColor());
            moduleCode.setForeground(theme.getFontColor());
            noOfStud.setForeground(theme.getFontColor());
            // search.setForeground(theme.getFontColor());

            week.setForeground(theme.getFontColor());
            semester.setForeground(theme.getFontColor());
            date.setForeground(theme.getFontColor());

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
            moduleDetails.setLayout(new GridLayout(8, 2, 5, 5));

            // ATTENDANCE TABLE
            attendanceContainer = new JPanel();
            attendanceContainer.setLayout(new BorderLayout());
            attendanceContainer.setBackground(theme.getMainColor());

            TableCol = new JPanel();
            TableCol.setLayout(new GridLayout(1, 3, 0, 5));
            TableCol.add(nameOfStudents);
            TableCol.add(studentID);
            TableCol.add(attendanceStatus);

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
            this.add(save, BorderLayout.SOUTH);

        }

        public ArrayList<String> getIds() {
            return this.ids;
        }

        public ArrayList<String> getNames() {
            return this.names;
        }

        public void setUpListOfStudents(Theme theme) {
            //
            presense = new ArrayList<JCheckBox>();
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
                id.setForeground(theme.getFontColor());
                //
                JLabel name = new JLabel(names.get(i));
                name.setForeground(theme.getFontColor());
                name.setBorder(idBorder);
                //
                JCheckBox box = new JCheckBox();
                presense.add(box);

                attendanceTable.add(id);
                attendanceTable.add(name);
                attendanceTable.add(box);
            }
            attendanceTable.revalidate();
            validate();
            attendanceTable.repaint();

        }

        public void setUpDetails(Theme theme) {
            moduleNametxt = new JTextField(mod.getName());
            LecturerNametxt = new JTextField(
                    Variables.userLoggedIn.getFirstName() + " " + Variables.userLoggedIn.getLastName());
            moduleCodetxt = new JTextField(mod.getModuleCode());
            noOfStudtxt = new JTextField(ids.size());
            searchtxt = new JTextField("Search");
            weektxt = new JTextField(attendance.getWeek());
            semestertxt = new JTextField(attendance.getSemester());
            datetxt = new JTextField(attendance.getDate());
            //
            moduleNametxt.setEditable(false);
            LecturerNametxt.setEditable(false);
            moduleCodetxt.setEditable(false);
            noOfStudtxt.setEditable(false);
            searchtxt.setEditable(false);
            weektxt.setEditable(false);
            semestertxt.setEditable(false);
            datetxt.setEditable(false);
            //
            // //textfield design
            moduleNametxt.setBackground(theme.getMainColor());
            LecturerNametxt.setBackground(theme.getMainColor());
            moduleCodetxt.setBackground(theme.getMainColor());
            noOfStudtxt.setBackground(theme.getMainColor());
            searchtxt.setBackground(theme.getMainColor());
            weektxt.setBackground(theme.getMainColor());
            semestertxt.setBackground(theme.getMainColor());
            datetxt.setBackground(theme.getMainColor());

            moduleNametxt.setForeground(theme.getContentColor());
            LecturerNametxt.setForeground(theme.getContentColor());
            moduleCodetxt.setForeground(theme.getContentColor());
            noOfStudtxt.setForeground(theme.getContentColor());
            searchtxt.setForeground(theme.getContentColor());
            weektxt.setForeground(theme.getContentColor());
            semestertxt.setForeground(theme.getContentColor());
            datetxt.setForeground(theme.getContentColor());
            //
            Border border = BorderFactory.createLineBorder(theme.getMainColor(), 2);
            moduleNametxt.setBorder(border);
            LecturerNametxt.setBorder(border);
            moduleCodetxt.setBorder(border);
            noOfStudtxt.setBorder(border);
            searchtxt.setBorder(border);
            weektxt.setBorder(border);
            semestertxt.setBorder(border);
            datetxt.setBorder(border);
            // add
            moduleDetails.add(moduleName);
            moduleDetails.add(moduleNametxt);
            moduleDetails.add(LecturerName);
            moduleDetails.add(LecturerNametxt);
            moduleDetails.add(moduleCode);
            moduleDetails.add(moduleCodetxt);
            moduleDetails.add(noOfStud);
            moduleDetails.add(noOfStudtxt);
            moduleDetails.add(semester);
            moduleDetails.add(semestertxt);
            moduleDetails.add(week);
            moduleDetails.add(weektxt);
            moduleDetails.add(date);
            moduleDetails.add(datetxt);
            //
            moduleDetails.revalidate();
            validate();
            moduleDetails.repaint();
        }

        public void setTheme(Theme theme) {

        }

        public ArrayList<JCheckBox> getPresence() {
            return this.presense;
        }

    }
}
