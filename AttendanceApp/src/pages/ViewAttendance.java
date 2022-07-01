package pages;

//imports
import javax.swing.*;
import javax.swing.text.View;
import styles.*;
import java.awt.*;
import variables.*;
import gui.*;
import java.awt.event.*;
import backEnd.*;
import db.*;

public class ViewAttendance extends JPanel {
    //
    private JPanel allView;
    private ViewButton[] viewBtn;
    private JLabel title;
    private String[] viewList = new String[] { "View Attendance", "Add Attendance" };
    private Classes theClass;

    public ViewAttendance(Theme theme, Classes c) {
        super();
        // instantiating vars
        allView = new JPanel();
        title = new JLabel();
        theClass = c;

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
            // add action listener
            viewBtn[i].addActionListener(new ActionList(viewBtn[i].getText(), theClass));
        }
    }

    private class ActionList implements ActionListener {
        private String target;
        private Classes c;

        public ActionList(String target, Classes c) {
            super();
            this.target = target;
            this.c = c;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if (Variables.userType.equals("lecturer") && target.equals("Add Attendance")) {
                MainPanel.addAttd = new AddAttendance(Variables.activeTheme, c);
                AppFrame.mainPanel.add(MainPanel.addAttd, "add-attendance");
                MainPanel.cl.show(AppFrame.mainPanel, "add-attendance");
            } else if (Variables.userType.equals("lecturer") && target.equals("View Attendance")) {
                DatabaseConnection.fetchAllAttendance(String.valueOf(c.getId()), c);
            }
        }

    }
}
