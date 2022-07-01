package pages;

import javax.print.AttributeException;
//imports
import javax.swing.*;

import backEnd.Attendance;

import java.awt.*;
import styles.*;
import variables.Variables;
import gui.*;

public class ViewAttendancePage extends JScrollPane {
    //
    private ViewAttendancePanel attendanceBoard;
    // private ClassButton classButton;

    public ViewAttendancePage(Theme theme) {
        super();
        // instantiate vars
        attendanceBoard = new ViewAttendancePanel(theme);
        this.setViewportView(attendanceBoard);

    }

    public class ViewAttendancePanel extends JPanel {
        //
        private JLabel title, noOfStud, moduleName, moduleCode, LecturerName, week, semester, date, nameOfStudents,
                attendanceStatus;

        // private JLabel

        private JTextField titletxt, noOfStudtxt, moduleNametxt, moduleCodetxt, LecturerNametxt, searchtxt, weektxt,
                semestertxt, datetxt;

        private JPanel moduleDetails, titlePanel, attendanceTable, Container, TableCol, attendanceContainer;

        private JPanel southPanel, northPanel, eastPanel, westPanel, centerPanel;

        // hardcoded label
        private JLabel stud1, stud2;
        private JLabel stud1Atd, stud2Atd;


        private JLabel studentID;
        private JLabel studID1, studID2;
        private JLabel studentAttendanceStatus1, studentAttendanceStatus2;

        private Attendance attendance;

        //
        public ViewAttendancePanel(Theme theme) {
            super();

            this.setLayout(new BorderLayout());
            this.setBackground(theme.getMainColor());

            // instantiating vars
            attendance = new Attendance(1, "13/02/2022", 3, 2, "present");

           
            title = new CenteredTextLabel(" V I E W   A T T E N D A N C E", theme.getContentColor(), Variables.PAGES_TITLE);

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

            stud1 = new JLabel("Divesh Nugessur");
            // stud1.setHorizontalAlignment();

            stud2 = new JLabel("Divesh Nugessur");

            studID1 = new JLabel("2012929");

            studID2 = new JLabel("2012929");
            // TextField
            moduleNametxt = new JTextField("Object Oriented Techniques ");
            LecturerNametxt = new JTextField("Bikash Sonak ");
            moduleCodetxt = new JTextField("1019Y ICR ");
            noOfStudtxt = new JTextField("120");
            searchtxt = new JTextField("Search");

            weektxt = new JTextField("7");
            semestertxt = new JTextField("2");
            datetxt = new JTextField("30-6-2022");

            // COLORS

            // label desing
            // moduleName.setBackground(theme.getContentColor());
            // LecturerName.setBackground(theme.getContentColor());
            // moduleCode.setBackground(theme.getContentColor());
            // noOfStud.setBackground(theme.getContentColor());

            // week.setBackground(theme.getContentColor());
            // semester.setBackground(theme.getContentColor());
            // date.setBackground(theme.getContentColor());
            moduleNametxt.setEditable(false);
            LecturerNametxt.setEditable(false);
            moduleCodetxt.setEditable(false);
            noOfStudtxt.setEditable(false);
            searchtxt.setEditable(false);
            weektxt.setEditable(false);
            semestertxt.setEditable(false);
            datetxt.setEditable(false);

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

            moduleNametxt.setBorder(BorderFactory.createLineBorder(theme.getMainColor(), 2));
            LecturerNametxt.setBorder(BorderFactory.createLineBorder(theme.getMainColor(), 2));
            moduleCodetxt.setBorder(BorderFactory.createLineBorder(theme.getMainColor(), 2));
            noOfStudtxt.setBorder(BorderFactory.createLineBorder(theme.getMainColor(), 2));
            searchtxt.setBorder(BorderFactory.createLineBorder(theme.getMainColor(), 2));
            weektxt.setBorder(BorderFactory.createLineBorder(theme.getMainColor(), 2));
            semestertxt.setBorder(BorderFactory.createLineBorder(theme.getMainColor(), 2));
            datetxt.setBorder(BorderFactory.createLineBorder(theme.getMainColor(), 2));

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

            attendanceTable.setLayout(new GridLayout(2, 3, 0, 0));
            attendanceTable.setBorder(BorderFactory.createLineBorder(theme.getButtonColor(), 2));
            attendanceTable.setBackground(theme.getMainColor());

            attendanceContainer.add(TableCol, BorderLayout.NORTH);
            attendanceContainer.add(attendanceTable, BorderLayout.CENTER);
            attendanceContainer.setBorder(BorderFactory.createLineBorder(theme.getButtonColor(), 2));
            attendanceContainer.setBackground(theme.getMainColor());

            attendanceContainer.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));

            // attendanceTable.add(nameOfStudents);
            // attendanceTable.add(attendanceStatus);

            stud1 = new JLabel("Divesh Nugessur");
            stud2 = new JLabel("Divesh Nugessur");

            stud1.setBorder(BorderFactory.createLineBorder(theme.getButtonColor(), 2));
            stud2.setBorder(BorderFactory.createLineBorder(theme.getButtonColor(), 2));

            studID1.setBorder(BorderFactory.createLineBorder(theme.getButtonColor(), 2));
            studID2.setBorder(BorderFactory.createLineBorder(theme.getButtonColor(), 2));
            


            stud1.setForeground(theme.getFontColor());
            stud2.setForeground(theme.getFontColor());

            studID1.setForeground(theme.getFontColor());
            studID2.setForeground(theme.getFontColor());

            

            studentAttendanceStatus1 = new JLabel("Present");
            studentAttendanceStatus1.setForeground(theme.getFontColor());
            studentAttendanceStatus1.setBackground(theme.getMainColor());
            studentAttendanceStatus1.setBorder(BorderFactory.createLineBorder(theme.getButtonColor(), 2));

            studentAttendanceStatus2= new JLabel("Present");
            studentAttendanceStatus2.setForeground(theme.getFontColor());
            studentAttendanceStatus2.setBackground(theme.getMainColor());
            studentAttendanceStatus2.setBorder(BorderFactory.createLineBorder(theme.getButtonColor(), 2));


            attendanceTable.add(stud1);
            attendanceTable.add(studID1);
            attendanceTable.add(studentAttendanceStatus1);
            

            attendanceTable.add(stud2);
            attendanceTable.add(studID2);
            attendanceTable.add(studentAttendanceStatus2);
            

            // attendanceTable.add(stud2);
            // attendanceTable.add(c1);

            Container.setLayout(new BorderLayout());

            Container.add(moduleDetails, BorderLayout.NORTH);
            Container.add(attendanceContainer, BorderLayout.CENTER);

            this.add(titlePanel, BorderLayout.NORTH);
            this.add(Container, BorderLayout.CENTER);

        }

    }
}