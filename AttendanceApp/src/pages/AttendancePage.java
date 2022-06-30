package pages;

import javax.print.AttributeException;
//imports
import javax.swing.*;

import backEnd.Attendance;

import java.awt.*;
import styles.*;
import variables.Variables;
import gui.*;

public class AttendancePage extends JScrollPane {
    //
    private AttendancePanel attendanceBoard;
    // private ClassButton classButton;

    public AttendancePage(Theme theme) {
        super();
        // instantiate vars
        attendanceBoard = new AttendancePanel(theme);
        this.setViewportView(attendanceBoard);

    }

    public class AttendancePanel extends JPanel {
        //
        private JLabel title, noOfStud, moduleName, moduleCode, LecturerName;

        private JPanel moduleDetails;

        private JPanel attendanceTable;

        // private JPanel Search;

        // private JLabel

        private Attendance attendance;

        //
        public AttendancePanel(Theme theme) {
            super();
            // instantiating vars
            attendance = new Attendance(1, "13/02/2022", 3, 2, "present");

            title = new JLabel("Attendance");

            attendanceTable = new JPanel();
            attendanceTable.setLayout(new GridLayout(10, 10, 5, 5));
            // attendanceTable.set

            this.add(title);

        }

    }
}
