package pages;

//imports
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.*;
import variables.*;
import styles.*;
import java.util.ArrayList;
import event_handling.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import gui.*;
import db.*;

public class AddAttendance extends JPanel {
    //
    private CenteredTextLabel title;
    private CenteredTextLabel date, classId, week, semester;

    private JTextField date_txt, class_txt, week_txt, semester_txt;
    //
    private ButtonStyle1 addButton;
    //
    private JPanel AttendanceContent;

    //
    public AddAttendance(Theme theme) {

        super();
        this.setLayout(new BorderLayout());
        this.setBackground(theme.getMainColor());
        // this.setBackground(Color.DARK_GRAY);
        // instantiating vars
        title = new CenteredTextLabel("ADD ATTENDANCE", theme.getContentColor(), Variables.PAGES_TITLE);
        // title
        title.setPreferredSize(new Dimension(this.getWidth(), 150));
        AttendanceContent = new JPanel();

        // text labels
        this.date = new CenteredTextLabel("Date:", theme.getContentColor());
        this.classId = new CenteredTextLabel("Class ID:", theme.getContentColor());
        this.week = new CenteredTextLabel("Week:", theme.getContentColor());
        this.semester = new CenteredTextLabel("Semester:", theme.getContentColor());

        // text field
        this.date_txt = new JTextField();
        this.class_txt = new JTextField();
        this.week_txt = new JTextField();
        this.semester_txt = new JTextField();

        // textfield design
        // Date
        date_txt.setBackground(theme.getMenuColor());
        date_txt.setForeground(theme.getFontColor());
        date_txt.setFont(new Font("consolas", Font.BOLD, 15));
        date_txt.setCaretColor(theme.getFontColor());
        date_txt.setText("08/09/2022");
        Border date_txt_border = BorderFactory.createLineBorder(Color.YELLOW, 0);
        date_txt.setBorder(date_txt_border);

        // Class
        class_txt.setBackground(theme.getMenuColor());
        class_txt.setForeground(theme.getFontColor());
        class_txt.setFont(new Font("consolas", Font.PLAIN, 15));
        class_txt.setCaretColor(theme.getFontColor());
        class_txt.setBorder(date_txt_border);

        // Week
        week_txt.setBackground(theme.getMenuColor());
        week_txt.setForeground(theme.getFontColor());
        week_txt.setFont(new Font("consolas", Font.PLAIN, 15));
        week_txt.setCaretColor(theme.getFontColor());
        week_txt.setBorder(date_txt_border);

        // semester
        semester_txt.setBackground(theme.getMenuColor());
        semester_txt.setForeground(theme.getFontColor());
        semester_txt.setFont(new Font("consolas", Font.PLAIN, 15));
        semester_txt.setCaretColor(theme.getFontColor());
        semester_txt.setBorder(date_txt_border);

        this.addButton = new ButtonStyle1(theme, Color.GREEN, 0, "Add", 50, 50);
        /*
         * addButton.addActionListener(e -> {
         * DatabaseConnection.login(date_txt.getText(),
         * String.valueOf(class_txt.getPassword()));
         * });
         */ // login_button.setBorder(new RoundBtn(15));

        // Attendance contents
        setUpAttendanceContent(theme);
        // adding components
        this.add(title, BorderLayout.NORTH);
        this.add(AttendanceContent, BorderLayout.CENTER);
        StylingPanel.setUpStylingPanels(theme, this, 300, 100);
        // adding icon images

    }

    private void setUpAttendanceContent(Theme theme) {

        this.AttendanceContent.setBackground(theme.getMainColor());
        // this.AttendanceContent.setBackground(Color.DARK_GRAY);
        this.AttendanceContent.setLayout(new GridLayout(9, 1, 0, 10));

        // addings components to login contents
        this.AttendanceContent.add(this.date);
        this.AttendanceContent.add(date_txt);
        this.AttendanceContent.add(this.classId);
        this.AttendanceContent.add(class_txt);
        this.AttendanceContent.add(this.week);
        this.AttendanceContent.add(week_txt);
        this.AttendanceContent.add(this.semester);
        this.AttendanceContent.add(semester_txt);
        this.AttendanceContent.add(addButton);
    }

}
