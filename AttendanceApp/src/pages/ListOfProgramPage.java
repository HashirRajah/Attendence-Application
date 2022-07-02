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

public class ListOfProgramPage extends JScrollPane {
    //
    private ListProgram allProgram;

    public ListOfProgramPage(Theme theme, Department dept) {
        super();
        // instantiate vars
        allProgram = new ListProgram(theme, dept);
        this.setViewportView(allProgram);
    }

    public ListProgram getallProgram() {
        return allProgram;
    }

    public class ListProgram extends JPanel {
        //
        private JPanel allView;
        private ArrayList<ViewButton> listBtn;
        private ArrayList<Program> progList;
        private JLabel title;
        private Department dept;

        public ListProgram(Theme theme, Department dept) {
            super();
            // instantiating vars
            allView = new JPanel();
            title = new JLabel();
            progList = new ArrayList<Program>();
            this.dept = dept;
            // title customization
            title.setPreferredSize(new Dimension(this.getWidth(), 150));
            title.setForeground(theme.getContentColor());
            title.setText("Programs");
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
            this.allView.setLayout(new GridLayout(progList.size(), 1, 0, 10));
            //
            for (int i = 0; i < progList.size(); i++) {
                //
                listBtn.add(new ViewButton(theme, theme.getMenuColor(), 3, progList.get(i).getName()));
                this.allView.add(listBtn.get(i));
                // add action listner
                listBtn.get(i).addActionListener(new MyActionListener(progList.get(i)));
            }
            this.allView.revalidate();
            validate();
            this.allView.repaint();
        }

        public ArrayList<ViewButton> getListBtn() {
            return listBtn;
        }

        public ArrayList<Program> getprogList() {
            return progList;
        }

        private class MyActionListener implements ActionListener {
            private Program prog;

            public MyActionListener(Program prog) {
                this.prog = prog;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Variables.programId = prog.getId();
                DatabaseConnection.fetchClasses();
            }

        }

    }
}
