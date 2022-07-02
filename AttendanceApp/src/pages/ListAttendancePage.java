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
import java.awt.event.*;
import db.*;
import backEnd.*;

public class ListAttendancePage extends JScrollPane {
    //
    private ListAttendance allAttendance;

    public ListAttendancePage(Theme theme, Classes cls) {
        super();
        // instantiate vars
        allAttendance = new ListAttendance(theme, cls);
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
        private Classes cls;

        public ListAttendance(Theme theme, Classes cls) {
            super();
            // instantiating vars
            allView = new JPanel();
            title = new JLabel();
            attdList = new ArrayList<Attendance>();
            this.cls = cls;
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
            //
            int stop = ((Variables.userType.equals("admin")) ? attdList.size() + 1 : attdList.size());
            //
            this.allView.setLayout(new GridLayout(stop, 1, 0, 10));
            //
            if (Variables.userType.equals("admin")) {
                ButtonStyle1 btn = new ButtonStyle1(theme, theme.getContentColor(), 3, "Download Report");
                btn.addActionListener(e -> {
                    DatabaseConnection.downloadReport();
                });
                this.allView.add(btn);
            }
            //
            for (int i = 0; i < attdList.size(); i++) {
                //
                listBtn.add(new ViewButton(theme, theme.getMenuColor(), 3,
                        "<html>Date: " + attdList.get(i).getDate() + "<br>Week: " + attdList.get(i).getWeek()
                                + "<br> Semester: "
                                + attdList.get(i).getSemester() + "<br></html>"));
                this.allView.add(listBtn.get(i));
                // add action listner
                listBtn.get(i).addActionListener(new MyActionListener(cls, attdList.get(i)));
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

        private class MyActionListener implements ActionListener {
            private Classes cls;
            private Attendance attd;

            public MyActionListener(Classes cls, Attendance attd) {
                this.cls = cls;
                this.attd = attd;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                DatabaseConnection.fetchAttendance(cls, attd);
            }

        }

    }
}
