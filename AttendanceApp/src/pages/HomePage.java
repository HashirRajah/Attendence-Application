package pages;

//imports
import javax.swing.*;
import java.awt.*;
import styles.*;
import gui.*;
import variables.*;
import java.util.ArrayList;
import backEnd.*;
import java.awt.event.*;

public class HomePage extends JPanel {
    // attributes
    private JLabel title;
    private CenteredTextLabel statusClass;
    private JPanel woohoo, listOfClasses;
    private String classStatus;
    private ArrayList<Classes> allClasses;
    private ArrayList<ClassButton> classButtons;

    // methods
    public HomePage(Theme theme) {
        super();
        setUpTheme(theme);
        allClasses = new ArrayList<Classes>();
        statusClass = new CenteredTextLabel("", theme.getContentColor(), Variables.SETTINGS_FONT);
        listOfClasses = new JPanel();
        classButtons = new ArrayList<ClassButton>();
        // setUpLabel(theme);
        this.setLayout(new BorderLayout());
        //

    }

    public void setUpLabel(Theme theme) {
        if (Variables.loggedIn && Variables.userLoggedIn != null) {
            title = new JLabel();
            woohoo = new JPanel();
            classStatus = ((!classButtons.isEmpty()) ? "Todays Classes" : "Woohoo.. No Class");
            // title customization
            title.setPreferredSize(new Dimension(this.getWidth(), 150));
            title.setForeground(theme.getContentColor());
            title.setText("<html>Hello " + Variables.userLoggedIn.getFirstName() + "<br />Welcome Back</html>");
            title.setFont(Variables.PAGES_TITLE);
            title.setVerticalAlignment(JLabel.CENTER);
            title.setHorizontalAlignment(JLabel.CENTER);

            statusClass.setText(classStatus);
            //
            int rows = (classButtons.size() / 3) + 1;
            listOfClasses.setLayout(new GridLayout(rows, 3, 10, 10));
            listOfClasses.removeAll();
            woohoo.removeAll();
            this.removeAll();
            listOfClasses.setBackground(theme.getMainColor());
            for (int i = 0; i < classButtons.size(); i++) {
                classButtons.get(i).setPreferredSize(new Dimension(100, 100));
                listOfClasses.add(classButtons.get(i));
                // action listener
                classButtons.get(i).addActionListener(new ActionList(classButtons.get(i).getClasses()));
            }

            //
            woohoo.setLayout(new BorderLayout());
            woohoo.setBackground(theme.getMainColor());
            woohoo.add(statusClass, BorderLayout.NORTH);
            woohoo.add(listOfClasses, BorderLayout.CENTER);
            this.add(woohoo, BorderLayout.CENTER);
            this.add(title, BorderLayout.NORTH);
            StylingPanel.setUpStylingPanels(theme, this, 50, 50);
            //
            statusClass.revalidate();
            statusClass.repaint();
            title.revalidate();
            validate();
            title.repaint();
            listOfClasses.revalidate();
            validate();
            listOfClasses.repaint();

        }
    }

    public ArrayList<Classes> getAllClasses() {
        return this.allClasses;
    }

    public ArrayList<ClassButton> getAllClassesBtn() {
        return this.classButtons;
    }

    public void setUpTheme(Theme theme) {
        this.setBackground(theme.getMainColor());
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
