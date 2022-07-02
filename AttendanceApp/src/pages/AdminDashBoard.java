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

        private JPanel topPanel, statisticsPanel, mainContainer, buttonContainer;

        private ButtonStyle1 save, manageUser, manageDept, attendance;

        //
        public AdminDashBoardPanel(Theme theme) {
            super();

            this.setLayout(new BorderLayout());
            this.setBackground(theme.getMainColor());

            topPanel = new JPanel();
            //
            save = new ButtonStyle1(theme, theme.getFontColor(), 2, "Save", 50, 50);

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
            buttonContainer = new JPanel();
            buttonContainer.setBackground(theme.getMainColor());
            buttonContainer.setLayout(new GridLayout(1, 3, 5, 0));
            attendance = new ButtonStyle1(theme, theme.getMenuColor(), 3, "Attendance");
            manageUser = new ButtonStyle1(theme, theme.getMenuColor(), 3, "Manage user");
            manageDept = new ButtonStyle1(theme, theme.getMenuColor(), 3, "Manage Department");
            buttonContainer.add(attendance);
            buttonContainer.add(manageUser);
            buttonContainer.add(manageDept);

            // Adding to main
            this.add(topPanel, BorderLayout.NORTH);
            this.add(mainContainer, BorderLayout.CENTER);
            this.add(buttonContainer, BorderLayout.SOUTH);
        }
    }

}