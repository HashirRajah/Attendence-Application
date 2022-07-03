package pages;

//imports
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import styles.*;
import variables.Variables;
import gui.*;

public class AdminMain extends JPanel implements ActionListener {
    // attributes
    private CenteredTextLabel title;
    private ButtonStyle1 addLecturer, addStudent;
    private JPanel buttonPanels;

    // methods
    public AdminMain(Theme theme) {
        super();
        this.setBackground(theme.getMainColor());
        this.setLayout(new BorderLayout());
        //

        // instantiating title
        title = new CenteredTextLabel("Add Lecturer OR Student", theme.getContentColor(), Variables.PAGES_TITLE);
        title.setPreferredSize(new Dimension(this.getWidth(), 150));

        // border for text fields
        Border date_txt_border = BorderFactory.createLineBorder(Color.YELLOW, 0);

        // instantiating JButtons
        addLecturer = new ButtonStyle1(theme, Color.GREEN, 0, "<Add Lecturer>", 50, 50);
        // addLecturer.setPreferredSize(new Dimension(100, 550));
        addLecturer.addActionListener(this);
        addStudent = new ButtonStyle1(theme, Color.GREEN, 0, "<Add Student>", 50, 50);
        // addStudent.setPreferredSize(new Dimension(100, 50));
        addStudent.addActionListener(this);

        // instantiating main panel
        buttonPanels = new JPanel();

        // calling function to set up panel
        setUpButtonPanel(theme);

        // adding components to panel
        this.add(title, BorderLayout.NORTH);
        this.add(buttonPanels, BorderLayout.CENTER);

        StylingPanel.setUpStylingPanels(theme, this, 50, 50);

    }

    private void setUpButtonPanel(Theme theme) {

        buttonPanels = new JPanel(new GridLayout(2, 1, 0, 30));
        buttonPanels.setBackground(theme.getMainColor());

        buttonPanels.add(addLecturer);
        buttonPanels.add(addStudent);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addLecturer) {
            AdminAddLecturer al = new AdminAddLecturer(Variables.activeTheme);
            AppFrame.mainPanel.add(al, "add-lec");
            Variables.pagesStack.push("add-lec");
            MainPanel.cl.show(AppFrame.mainPanel, "add-lec");
        }

        if (e.getSource() == addStudent) {
            AdminAddStudent as = new AdminAddStudent(Variables.activeTheme);
            AppFrame.mainPanel.add(as, "add-stud");
            Variables.pagesStack.push("add-stud");
            MainPanel.cl.show(AppFrame.mainPanel, "add-stud");
        }

    }

}
