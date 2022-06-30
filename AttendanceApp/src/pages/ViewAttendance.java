package pages;

//imports
import javax.swing.*;
import javax.swing.text.View;

import styles.*;
import java.awt.*;
import variables.*;
import gui.*;

public class ViewAttendance extends JPanel {
    //
    private JPanel allView;
    private ViewButton[] viewBtn;
    private JLabel title;
    private String[] viewList = new String[] { "View Attendance", "Add Attendance" };

    public ViewAttendance(Theme theme) {
        super();
        // instantiating vars
        allView = new JPanel();
        title = new JLabel();

        // title customization
        title.setPreferredSize(new Dimension(this.getWidth(), 150));
        title.setForeground(theme.getContentColor());
        title.setText("View/Add Attendance");
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
        viewBtn = new ViewButton[2];
        this.allView.setLayout(new GridLayout(viewBtn.length, 1, 0, 10));
        //
        for (int i = 0; i < viewBtn.length; i++) {
            //
            viewBtn[i] = new ViewButton(theme, theme.getMenuColor(), 3, this.viewList[i]);
            this.allView.add(viewBtn[i]);
        }
    }
}
