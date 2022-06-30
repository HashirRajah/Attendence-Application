package pages;

//imports
import javax.swing.*;
import javax.swing.text.View;
import styles.*;
import java.awt.*;
import variables.*;
import gui.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import event_handling.*;
import javax.swing.JButton;

public class ListAttendance extends JPanel {
    //
    private JPanel allView;
    private ViewButton[] listBtn;
    private JLabel title;
    private String[] viewList = new String[] { "<html>Date: <br> Week: <br> Semester: <br> </html>", "yjrty " };

    public ListAttendance(Theme theme) {
        super();
        // instantiating vars
        allView = new JPanel();
        title = new JLabel();

        // title customization
        title.setPreferredSize(new Dimension(this.getWidth(), 150));
        title.setForeground(theme.getContentColor());
        title.setText("View Attendance");
        title.setFont(Variables.PAGES_TITLE);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);

        // all View
        allView.setBackground(theme.getMainColor());
        //
        this.setBackground(theme.getMainColor());
        this.setLayout(new BorderLayout());
        // add all View
        setUpView(theme);

        // adding components
        this.add(title, BorderLayout.NORTH);
        this.add(allView, BorderLayout.CENTER);
        StylingPanel.setUpStylingPanels(theme, this, 150, 150);
    }

    private void setUpView(Theme theme) {

        this.allView.setLayout(new GridLayout(2, 1, 0, 10));

        listBtn = new ViewButton[2];
        this.allView.setLayout(new GridLayout(listBtn.length, 1, 0, 10));
        //
        for (int i = 0; i < listBtn.length; i++) {
            //
            listBtn[i] = new ViewButton(theme, theme.getMenuColor(), 3, this.viewList[i]);
            this.allView.add(listBtn[i]);
        }

    }
}