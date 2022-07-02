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
import db.*;
import java.awt.event.*;
import java.util.HashMap;

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
        private JLabel totalStudents, totalLecturers, totalClasses;

        private CenteredTextLabel addStudent, addLecturer, addAdmin, addModule;

        private CenteredTextLabel viewAttendance, viewTimeTable, viewNotifications;

        private CenteredTextLabel title, welcome;

        private JPanel topPanel, statisticsPanel, mainContainer, buttonContainer, buttonContainer1;

        private ViewButton save, manageUser, manageDept, attendance;
        //
        private HashMap<String, MyActionListener> myListeners;

        //
        public AdminDashBoardPanel(Theme theme) {
            super();

            this.setLayout(new BorderLayout());
            this.setBackground(theme.getMainColor());

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

            totalStudents = new JLabel("No of Students");
            totalLecturers = new JLabel("No of Lecturers");
            totalClasses = new JLabel("No of Classes");

            totalStudents.setBorder(BorderFactory.createLineBorder(theme.getButtonColor(), 2));
            totalStudents.setForeground(theme.getFontColor());
            totalLecturers.setBorder(BorderFactory.createLineBorder(theme.getButtonColor(), 2));
            totalLecturers.setForeground(theme.getFontColor());
            totalClasses.setBorder(BorderFactory.createLineBorder(theme.getButtonColor(), 2));
            totalClasses.setForeground(theme.getFontColor());

            statisticsPanel = new JPanel();
            statisticsPanel.setLayout(new GridLayout(1, 3, 10, 10));
            statisticsPanel.add(totalStudents);
            statisticsPanel.add(totalLecturers);
            statisticsPanel.add(totalClasses);
            statisticsPanel.setBackground(theme.getMainColor());

            topPanel = new JPanel();
            topPanel = new JPanel();
            topPanel.setLayout(new BorderLayout());
            topPanel.setBackground(theme.getMainColor());
            topPanel.add(title, BorderLayout.NORTH);

            mainContainer = new JPanel();
            mainContainer.setLayout(new BorderLayout());
            mainContainer.setBackground(theme.getMainColor());
            mainContainer.add(statisticsPanel, BorderLayout.NORTH);

            // manage buttons
            buttonContainer1 = new JPanel();
            buttonContainer1.setLayout(new BorderLayout());
            StylingPanel.setUpStylingPanels(theme, buttonContainer1, 60, 20);
            buttonContainer = new JPanel();
            buttonContainer.setBackground(theme.getMainColor());
            buttonContainer.setSize(new Dimension(800, 200));
            buttonContainer.setLayout(new GridLayout(3, 1, 10, 15));
            attendance = new ViewButton(theme, theme.getMenuColor(), 3, "Attendance");
            attendance.addActionListener(myListeners.get(attendance.getText()));
            manageUser = new ViewButton(theme, theme.getMenuColor(), 3, "Manage user");
            manageUser.addActionListener(myListeners.get(manageUser.getText()));
            manageDept = new ViewButton(theme, theme.getMenuColor(), 3, "Manage Department");
            manageDept.addActionListener(myListeners.get(manageDept.getText()));

            buttonContainer.add(attendance);
            buttonContainer.add(manageUser);
            buttonContainer.add(manageDept);
            buttonContainer1.add(buttonContainer, BorderLayout.CENTER);

            // Adding to main
            this.add(topPanel, BorderLayout.NORTH);
            this.add(mainContainer, BorderLayout.CENTER);
            this.add(buttonContainer1, BorderLayout.SOUTH);
        }

        private void setUpMyListeners() {
            myListeners = new HashMap<String, MyActionListener>();
            //
            myListeners.put("Attendance", new Attd());
            myListeners.put("Manage user", new ManageUsers());
            myListeners.put("Manage Department", new ManageDepts());

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

            }

        }

        private class ManageDepts extends MyActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

            }

        }
    }
}