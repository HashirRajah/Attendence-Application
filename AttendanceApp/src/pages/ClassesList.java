package pages;

//imports
import javax.swing.*;
import java.awt.*;
import styles.*;
import variables.Variables;
import gui.*;
import java.util.ArrayList;
import java.awt.event.*;
import db.*;

public class ClassesList extends JScrollPane {
    //
    private ClassPanel allClasses;

    public ClassesList(Theme theme) {
        super();
        // instantiate vars
        allClasses = new ClassPanel(theme);
        this.setViewportView(allClasses);
    }

    public ClassPanel getAllClasses() {
        return this.allClasses;
    }

    public class ClassPanel extends JPanel {
        //
        private JLabel infoLabel;
        private JPanel listOfClasses;
        private ArrayList<ClassButton> classButtons;

        //
        public ClassPanel(Theme theme) {
            super();
            // instantiating vars
            infoLabel = new JLabel();
            listOfClasses = new JPanel();
            // list of classes
            listOfClasses.setBackground(theme.getMainColor());
            //
            classButtons = new ArrayList<ClassButton>();
            //
            infoLabel.setText("Modules");
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
                // adding action listeners
                classButtons.get(i).addActionListener(new ActionList(classButtons.get(i).getString()));
            }
            this.revalidate();
            validate();
            this.repaint();
        }

        private class ActionList implements ActionListener {
            private String module_code;

            public ActionList(String module_code) {
                super();
                this.module_code = module_code;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                AppFrame.mainPanel.classes.getAllClassesList().getClassButtons().clear();
                DatabaseConnection.fetchClassesList(module_code);
                MainPanel.cl.show(AppFrame.mainPanel, "list-of-classes");
                Variables.pagesStack.push("list-of-classes");
            }

        }
    }
}
