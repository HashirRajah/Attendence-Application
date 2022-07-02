package pages;

//imports
import javax.swing.*;
import java.awt.*;
import styles.*;
import variables.Variables;
import gui.*;
import java.util.ArrayList;
import db.*;
import java.awt.event.*;
import backEnd.*;

public class ListOfClasses extends JScrollPane {
    //
    private ClassListPanel allClasses;

    public ListOfClasses(Theme theme) {
        super();
        // instantiate vars
        allClasses = new ClassListPanel(theme);
        this.setViewportView(allClasses);
    }

    public ClassListPanel getAllClassesList() {
        return this.allClasses;
    }

    public class ClassListPanel extends JPanel {
        //
        private JLabel infoLabel;
        private JPanel listOfClasses;
        private ArrayList<ClassButton> classButtons;

        //
        public ClassListPanel(Theme theme) {
            super();
            // instantiating vars
            infoLabel = new JLabel();
            listOfClasses = new JPanel();
            // list of classes
            listOfClasses.setBackground(theme.getMainColor());
            //
            classButtons = new ArrayList<ClassButton>();
            //
            infoLabel.setText("Classes");
            infoLabel.setPreferredSize(new Dimension(this.getWidth(), 150));
            infoLabel.setHorizontalAlignment(JLabel.CENTER);
            infoLabel.setVerticalAlignment(JLabel.CENTER);
            infoLabel.setForeground(theme.getContentColor());
            infoLabel.setFont(Variables.PAGES_TITLE);
            //
            this.setBackground(theme.getMainColor());
            this.setLayout(new BorderLayout());
            this.add(infoLabel, BorderLayout.NORTH);
            this.add(listOfClasses, BorderLayout.CENTER);
            StylingPanel.setUpStylingPanels(theme, this, 100, 100);
        }

        public JPanel getListOfClasses() {
            return listOfClasses;
        }

        public ArrayList<ClassButton> getClassButtons() {
            return this.classButtons;
        }

        public void addClasses(Theme theme) {
            listOfClasses.removeAll();
            int rows = (classButtons.size() / 3) + 1;
            listOfClasses.setLayout(new GridLayout(rows, 3, 10, 10));
            for (int i = 0; i < classButtons.size(); i++) {
                // classButtons = new ClassButton(theme, Variables.classText[i]);
                classButtons.get(i).setPreferredSize(new Dimension(100, 100));
                listOfClasses.add(classButtons.get(i));
                // action listener
                classButtons.get(i).addActionListener(new ActionList(classButtons.get(i).getClasses()));
            }
            this.revalidate();
            validate();
            this.repaint();
        }

        private class ActionList implements ActionListener {
            private Classes c;

            public ActionList(Classes c) {
                super();
                this.c = c;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                MainPanel.viewAttd = new ViewAttendance(Variables.activeTheme, c);
                AppFrame.mainPanel.add(MainPanel.viewAttd, "attendance-choice");
                MainPanel.cl.show(AppFrame.mainPanel, "attendance-choice");
                Variables.pagesStack.push("attendance-choice");

            }

        }
    }
}
