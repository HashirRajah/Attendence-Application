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

        private JPanel topPanel, statisticsPanel, mainContainer;
       


        private ButtonStyle1 save;

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
            welcome =  new CenteredTextLabel("Welcome Admin", theme.getContentColor(), Variables.PAGES_TITLE);
            title = new CenteredTextLabel("A D M I N   D A S H B O A R D", theme.getContentColor(), Variables.PAGES_TITLE);


            totalStudents = new JLabel("No of Students");
            totalLecturers = new JLabel("No of Lecturers");
            totalClasses = new JLabel("No of Classes");

            totalStudents.setBorder(BorderFactory.createLineBorder(theme.getButtonColor(), 2));
            totalLecturers.setBorder(BorderFactory.createLineBorder(theme.getButtonColor(), 2));
            totalClasses.setBorder(BorderFactory.createLineBorder(theme.getButtonColor(), 2));

            statisticsPanel = new JPanel();
            statisticsPanel.setLayout(new GridLayout(1,3,10,10));
            statisticsPanel.add(totalStudents);
            statisticsPanel.add(totalLecturers);
            statisticsPanel.add(totalClasses);








            topPanel = new JPanel();
            topPanel = new JPanel();
            topPanel.setLayout(new BorderLayout());
            topPanel.add(title,  BorderLayout.NORTH);
            



            mainContainer = new JPanel();
            mainContainer.setLayout(new BorderLayout());
            mainContainer.add(statisticsPanel,BorderLayout.NORTH);


            this.add(topPanel, BorderLayout.NORTH);
            this.add(mainContainer, BorderLayout.CENTER);

        

    }
}

}