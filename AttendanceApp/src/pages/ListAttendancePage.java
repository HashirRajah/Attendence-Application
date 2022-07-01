package pages;

//imports
import javax.swing.*;
import javax.swing.text.View;

import backEnd.Attendance;
import styles.*;
import java.awt.*;
import variables.*;
import gui.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import event_handling.*;
import javax.swing.JButton;
import java.util.ArrayList;

public class ListAttendancePage extends JScrollPane {
    //
    private ListAttendance allAttendance;

    public ListAttendancePage(Theme theme) {
        super();
        // instantiate vars
        allAttendance = new ListAttendance(theme);
        this.setViewportView(allAttendance);
    }

    public ListAttendance getAllAttendance() {
        return allAttendance;
    }

    public class ListAttendance extends JPanel {
        //
        private JPanel allView;
        private ArrayList<ViewButton> listBtn;
        private ArrayList<Attendance> attdList;
        private JLabel title;

        public ListAttendance(Theme theme) {
            super();
            // instantiating vars
            allView = new JPanel();
            title = new JLabel();
            attdList = new ArrayList<Attendance>();
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

            // adding components
            this.add(title, BorderLayout.NORTH);
            this.add(allView, BorderLayout.CENTER);
            StylingPanel.setUpStylingPanels(theme, this, 150, 150);
        }

        public void setUpView(Theme theme) {
            this.allView.removeAll();
            listBtn = new ArrayList<ViewButton>();
            this.allView.setLayout(new GridLayout(attdList.size(), 1, 0, 10));
            //
            for (int i = 0; i < attdList.size(); i++) {
                //
                listBtn.add(new ViewButton(theme, theme.getMenuColor(), 3,
                        "<html>Date: " + attdList.get(i).getDate() + "<br>Week: " + attdList.get(i).getWeek()
                                + "<br> Semester: "
                                + attdList.get(i).getSemester() + "<br></html>"));
                this.allView.add(listBtn.get(i));
            }
            this.allView.revalidate();
            validate();
            this.allView.repaint();
        }

        public ArrayList<ViewButton> getListBtn() {
            return listBtn;
        }

        public ArrayList<Attendance> getattdList() {
            return attdList;
        }
    }
}
