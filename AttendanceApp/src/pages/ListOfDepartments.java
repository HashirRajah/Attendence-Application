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

public class ListOfDepartments extends JScrollPane {
    //
    private ListDepartment allDepartments;

    public ListOfDepartments(Theme theme) {
        super();
        // instantiate vars
        allDepartments = new ListDepartment(theme);
        this.setViewportView(allDepartments);
    }

    public ListDepartment getAllDepartments() {
        return allDepartments;
    }

    public class ListDepartment extends JPanel {
        //
        private JPanel allView;
        private ArrayList<ViewButton> listBtn;
        private ArrayList<Department> deptList;
        private JLabel title;

        public ListDepartment(Theme theme) {
            super();
            // instantiating vars
            allView = new JPanel();
            title = new JLabel();
            deptList = new ArrayList<Department>();
            // title customization
            title.setPreferredSize(new Dimension(this.getWidth(), 150));
            title.setForeground(theme.getContentColor());
            title.setText("Departments");
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
            this.allView.setLayout(new GridLayout(deptList.size(), 1, 0, 10));
            //
            for (int i = 0; i < deptList.size(); i++) {
                //
                listBtn.add(new ViewButton(theme, theme.getMenuColor(), 3, deptList.get(i).getName()));
                this.allView.add(listBtn.get(i));
                // add action listner
                listBtn.get(i).addActionListener(new MyActionListener(deptList.get(i)));
            }
            this.allView.revalidate();
            validate();
            this.allView.repaint();
        }

        public ArrayList<ViewButton> getListBtn() {
            return listBtn;
        }

        public ArrayList<Department> getdeptList() {
            return deptList;
        }

        private class MyActionListener implements ActionListener {
            private Department dept;

            public MyActionListener(Department dept) {
                this.dept = dept;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                DatabaseConnection.fetchPrograms(dept);
            }

        }

    }
}
