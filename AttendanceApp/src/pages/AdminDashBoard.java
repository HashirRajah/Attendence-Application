package pages;

//imports
import javax.swing.*;
import backEnd.Attendance;
import backEnd.BarGraphApp;
import backEnd.Classes;
import backEnd.ModuleClass;
import java.awt.*;
import styles.*;
import variables.Variables;
import gui.*;
import java.util.ArrayList;
import javax.print.AttributeException;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;

import db.*;
import java.awt.event.*;
import java.util.HashMap;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class AdminDashBoard extends JScrollPane {
    //
    private AdminDashBoardPanel adminDashBoard;

    // private ClassButton classButton;

    public AdminDashBoard(Theme theme) {
        super();

        // instantiate vars
        adminDashBoard = new AdminDashBoardPanel(theme);
        this.setViewportView(adminDashBoard);

    }

    public AdminDashBoardPanel getAttendanceBoard() {
        return adminDashBoard;
    }

    public class AdminDashBoardPanel extends JPanel {
        //
        private JPanel totalStudents, totalLecturers, totalClasses, totalAdmins;
        private JLabel totalStudentsIcon, totalLecturersIcon, totalClassesIcon, totalStudentsNo, totalLecturersNo,
                totalClassesNo, totalAdminsNo, totalAdminsIcon;

        private JLabel f1, f2, f3, f4, f5, f6;

        private CenteredTextLabel addStudent, addLecturer, addAdmin, addModule;

        private CenteredTextLabel viewAttendance, viewTimeTable, viewNotifications;

        private CenteredTextLabel title, welcome;

        private JPanel topPanel, statisticsPanel, mainContainer, buttonContainer, buttonContainer1;

        private ViewButton save, manageUser, manageDept, attendance;
        //
        private HashMap<String, MyActionListener> myListeners;

        public JPanel BarGraphPanel;
        private JPanel statisticsPanel2;

        private JPanel newsAndEvents, newsPanel1, newsPanel2, newsHeadingPanel, date;
        private JLabel news1, news2;
        private JLabel newsHeading;
        private JLabel currentDate, scheduleIcon, scheduletxt;
        private JPanel schedule;

        //
        public AdminDashBoardPanel(Theme theme) {
            super();

            this.setLayout(new BorderLayout());
            this.setBackground(theme.getTwo());

            topPanel = new JPanel();
            //
            // save = new ViewButton(theme, theme.getFontColor(), 2, "Save", 50, 50);
            //
            setUpMyListeners();
            // instantiating vars
            // attendance;
            welcome = new CenteredTextLabel("Welcome Admin", theme.getContentColor(), Variables.PAGES_TITLE);
            title = new CenteredTextLabel("A D M I N   D A S H B O A R D", theme.getContentColor(),
                    Variables.PAGES_TITLE);

            // Statistics

            // fillers
            f1 = new JLabel();
            f2 = new JLabel();
            f3 = new JLabel();
            f4 = new JLabel();
            f5 = new JLabel();
            f6 = new JLabel();

            ////////// students

            totalStudents = new JPanel();
            totalStudentsIcon = new JLabel();
            totalStudentsIcon.setHorizontalAlignment(JLabel.CENTER);
            totalStudentsIcon.setVerticalAlignment(JLabel.CENTER);

            totalStudentsNo = new JLabel("No of Students:      1567");
            totalStudentsNo.setHorizontalAlignment(JLabel.CENTER);
            totalStudentsNo.setVerticalAlignment(JLabel.CENTER);

            totalStudents.setLayout(new GridLayout(2, 1, 0, 5));
            ImageIcon studentsIcon = new ImageIcon(new ImageIcon("AttendanceApp/images/students.png").getImage()
                    .getScaledInstance(32, 32, Image.SCALE_DEFAULT));
            totalStudentsIcon.setIcon(studentsIcon);
            totalStudentsNo.setForeground(Color.WHITE);
            totalStudents.add(totalStudentsIcon);
            totalStudents.add(totalStudentsNo);
            totalStudents.setBackground(new Color(38, 156, 235));

            //////////// lecturers

            totalLecturers = new JPanel();
            totalLecturersIcon = new JLabel();

            totalLecturersIcon.setHorizontalAlignment(JLabel.CENTER);
            totalLecturersIcon.setVerticalAlignment(JLabel.CENTER);

            totalLecturersNo = new JLabel("No of Lecturers:      51 ");
            totalLecturersNo.setHorizontalAlignment(JLabel.CENTER);
            totalLecturersNo.setVerticalAlignment(JLabel.CENTER);

            totalLecturers.setLayout(new GridLayout(2, 1, 0, 5));
            ImageIcon lecturersIcon = new ImageIcon(new ImageIcon("AttendanceApp/images/teacher.png").getImage()
                    .getScaledInstance(32, 32, Image.SCALE_DEFAULT));
            totalLecturersIcon.setIcon(lecturersIcon);
            totalLecturersNo.setForeground(Color.WHITE);
            totalLecturers.add(totalLecturersIcon);
            totalLecturers.add(totalLecturersNo);
            totalLecturers.setBackground(new Color(255, 128, 0));

            //////// classes

            totalClasses = new JPanel();
            totalClassesIcon = new JLabel();
            totalClassesIcon.setHorizontalAlignment(JLabel.CENTER);
            totalClassesIcon.setVerticalAlignment(JLabel.CENTER);
            totalClassesNo = new JLabel("No of Classes:      612");
            totalClassesNo.setHorizontalAlignment(JLabel.CENTER);
            totalClassesNo.setVerticalAlignment(JLabel.CENTER);
            totalClasses.setLayout(new GridLayout(2, 1, 0, 5));
            ImageIcon classesIcon = new ImageIcon(new ImageIcon("AttendanceApp/images/classes.png").getImage()
                    .getScaledInstance(32, 32, Image.SCALE_DEFAULT));
            totalClassesIcon.setIcon(classesIcon);
            totalClassesNo.setForeground(Color.WHITE);
            totalClasses.add(totalClassesIcon);
            totalClasses.add(totalClassesNo);

            totalClasses.setBackground(new Color(255, 51, 51));

            ////////// admins

            totalAdmins = new JPanel();
            totalAdminsIcon = new JLabel();
            totalAdminsIcon.setHorizontalAlignment(JLabel.CENTER);
            totalAdminsIcon.setVerticalAlignment(JLabel.CENTER);
            totalAdminsNo = new JLabel("No of Admins:      5 ");
            totalAdminsNo.setHorizontalAlignment(JLabel.CENTER);
            totalAdminsNo.setVerticalAlignment(JLabel.CENTER);
            totalAdmins.setLayout(new GridLayout(2, 1, 0, 5));
            ImageIcon AdminsIcon = new ImageIcon(new ImageIcon("AttendanceApp/images/admin.png").getImage()
                    .getScaledInstance(32, 32, Image.SCALE_DEFAULT));
            totalAdminsIcon.setIcon(AdminsIcon);
            totalAdminsNo.setForeground(Color.WHITE);
            totalAdmins.add(totalAdminsIcon);
            totalAdmins.add(totalAdminsNo);
            totalAdmins.setBackground(new Color(14, 138, 51));

            //////////////////// stats panel
            statisticsPanel = new JPanel();
            // statisticsPanel.setBackground(theme.getMainColor());
            statisticsPanel.setBackground(theme.getTwo());
            statisticsPanel.setLayout(new GridLayout(1, 4, 10, 10));
            statisticsPanel.add(totalStudents);
            statisticsPanel.add(totalLecturers);
            statisticsPanel.add(totalClasses);
            statisticsPanel.add(totalAdmins);
            statisticsPanel.setBackground(theme.getTwo());
            statisticsPanel.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));

            topPanel = new JPanel();
            topPanel = new JPanel();
            topPanel.setLayout(new BorderLayout());
            topPanel.setBackground(theme.getMainColor());
            topPanel.add(title, BorderLayout.NORTH);

            //////////////// GRAPH

            statisticsPanel2 = new JPanel();
            statisticsPanel2.setBackground(theme.getTwo());
            statisticsPanel2.setLayout(new GridLayout(2, 2, 25, 25));
            statisticsPanel2.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 25));

            BarGraphPanel = new JPanel();
            BarGraphPanel.setLayout(new BorderLayout());
            BarGraphPanel.add(new BarGraphApp(theme), BorderLayout.CENTER);
            BarGraphPanel.setBackground(theme.getTwo());

            // statisticsPanel2.add(totalAdmins);
            // statisticsPanel2.add(totalAdmins);
            // statisticsPanel2.add(totalAdmins);

            ////////////// Others
            schedule = new JPanel();
            scheduleIcon = new JLabel();
            scheduletxt = new JLabel();
            schedule.setBackground(new Color(235, 68, 101));
            schedule.setBorder(BorderFactory.createEmptyBorder(10, 50, 15, 30));

            scheduleIcon.setHorizontalAlignment(JLabel.CENTER);
            scheduleIcon.setVerticalAlignment(JLabel.CENTER);

            scheduletxt = new JLabel("Schedule");
            scheduletxt.setHorizontalAlignment(JLabel.CENTER);
            scheduletxt.setVerticalAlignment(JLabel.CENTER);
            scheduletxt.setFont(new Font("Calibri", Font.BOLD, 30));

            schedule.setLayout(new GridLayout(1, 2, 0, 5));
            ImageIcon scheduleIcon1 = new ImageIcon(new ImageIcon("AttendanceApp/images/schedule.png").getImage()
                    .getScaledInstance(100, 100, Image.SCALE_DEFAULT));
            scheduleIcon.setIcon(scheduleIcon1);
            scheduletxt.setForeground(Color.WHITE);
            schedule.add(scheduleIcon);
            schedule.add(scheduletxt);

            date = new JPanel();
            currentDate = new JLabel("03  JULY  2020");
            currentDate.setFont(new Font("Calibri", Font.BOLD, 40));
            currentDate.setForeground(theme.getButtonColor());
            date.setBackground(theme.getTwo());
            date.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            date.add(currentDate);

            newsAndEvents = new JPanel();
            newsAndEvents.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));
            newsAndEvents.setBackground(theme.getTwo());
            newsAndEvents.setLayout(new GridLayout(3, 1, 5, 0));
            newsHeading = new JLabel("Latest Announcements");
            newsHeading.setBackground(new Color(194, 204, 198));
            // newsHeading.setForeground(fg);
            // newsHeading.setBackground(Color.BLACK);
            newsHeadingPanel = new JPanel();
            newsPanel1 = new JPanel();
            newsPanel2 = new JPanel();

            news1 = new JLabel("Semester 2 delayed by 2 weeks");
            // news1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            news2 = new JLabel("Classes resume face-to-face");
            // news2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            newsPanel1.add(news1);
            newsPanel2.add(news2);
            newsHeadingPanel.add(newsHeading);
            newsHeadingPanel.setBackground(new Color(84, 84, 83));
            newsPanel1.setBackground(new Color(250, 249, 240));
            newsPanel2.setBackground(new Color(250, 249, 240));
            newsPanel1.setBorder(BorderFactory.createLineBorder(new Color(163, 163, 163), 1));
            newsPanel2.setBorder(BorderFactory.createLineBorder(new Color(163, 163, 163), 1));
            // newsHeadingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

            newsAndEvents.add(newsHeadingPanel);
            newsAndEvents.add(newsPanel1);
            newsAndEvents.add(newsPanel2);

            statisticsPanel2.add(date);
            statisticsPanel2.add(BarGraphPanel);
            statisticsPanel2.add(newsAndEvents);
            statisticsPanel2.add(schedule);

            mainContainer = new JPanel();
            mainContainer.setLayout(new BorderLayout());
            mainContainer.setBackground(theme.getTwo());
            mainContainer.setBackground(theme.getTwo());
            mainContainer.add(statisticsPanel, BorderLayout.NORTH);

            mainContainer.add(statisticsPanel2, BorderLayout.CENTER);

            // manage buttons
            buttonContainer1 = new JPanel();
            buttonContainer1.setLayout(new BorderLayout());
            // StylingPanel.setUpStylingPanels(theme, buttonContainer1, 60, 20);
            buttonContainer = new JPanel();
            buttonContainer.setBackground(theme.getTwo());
            buttonContainer1.setBackground(theme.getTwo());
            buttonContainer.setSize(new Dimension(800, 200));
            buttonContainer.setLayout(new GridLayout(3, 1, 10, 15));
            attendance = new ViewButton(theme, theme.getMenuColor(), 0, "Student Attendance", new Color(116, 76, 156));
            attendance.addActionListener(myListeners.get(attendance.getText()));
            manageUser = new ViewButton(theme, theme.getMenuColor(), 0, "Manage users", new Color(255, 112, 56));
            manageUser.addActionListener(myListeners.get(manageUser.getText()));
            manageDept = new ViewButton(theme, theme.getMenuColor(), 0, "Manage Departments", new Color(56, 171, 89));
            manageDept.addActionListener(myListeners.get(manageDept.getText()));
            attendance.setFont(new Font("Calibri", Font.BOLD, 30));
            manageUser.setFont(new Font("Calibri", Font.BOLD, 30));
            manageDept.setFont(new Font("Calibri", Font.BOLD, 30));

            buttonContainer.add(attendance);
            buttonContainer.add(manageUser);
            buttonContainer.add(manageDept);
            buttonContainer1.add(buttonContainer, BorderLayout.CENTER);

            buttonContainer1.setBorder(BorderFactory.createEmptyBorder(0, 50, 15, 50));

            mainContainer.setBackground(theme.getTwo());
            topPanel.setBackground(theme.getOne());

            // Adding to main
            this.add(topPanel, BorderLayout.NORTH);
            this.add(mainContainer, BorderLayout.CENTER);

            this.add(buttonContainer1, BorderLayout.SOUTH);
        }

        private void setUpMyListeners() {
            myListeners = new HashMap<String, MyActionListener>();
            //
            myListeners.put("Student Attendance", new Attd());
            myListeners.put("Manage users", new ManageUsers());
            myListeners.put("Manage Departments", new ManageDepts());

        }

        private class MyActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }

        }

        private class Attd extends MyActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                DatabaseConnection.fetchDepartments();
            }

        }

        private class ManageUsers extends MyActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                ManageUserOptions op = new ManageUserOptions(Variables.activeTheme);
                AppFrame.mainPanel.add(op, "manage-users");
                MainPanel.cl.show(AppFrame.mainPanel, "manage-users");
                Variables.pagesStack.push("manage-users");
            }

        }

        private class ManageDepts extends MyActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel.cl.show(AppFrame.mainPanel, "font-settings");
                Variables.pagesStack.push("font-settings");
            }

        }
    }

}