package pages;

//imports
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import styles.*;
import variables.Variables;
import gui.*;

public class ManageUserOptions extends JPanel implements ActionListener {
    // attributes
    private CenteredTextLabel title;
    private ButtonStyle1 add, remove;
    private JPanel buttonPanels;

    // methods
    public ManageUserOptions(Theme theme) {
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
        add = new ButtonStyle1(theme, Color.GREEN, 0, "<html>+<br />Add</html>", 50, 50);
        // add.setPreferredSize(new Dimension(100, 550));
        add.addActionListener(this);
        remove = new ButtonStyle1(theme, Color.GREEN, 0, "<html>-<br />Remove</html>", 50, 50);
        // remove.setPreferredSize(new Dimension(100, 50));
        remove.addActionListener(this);

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

        buttonPanels.add(add);
        buttonPanels.add(remove);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {
            AdminMain am = new AdminMain(Variables.activeTheme);
            AppFrame.mainPanel.add(am, "add-user");
            Variables.pagesStack.push("add-user");
            MainPanel.cl.show(AppFrame.mainPanel, "add-user");
        }

        if (e.getSource() == remove) {

        }

    }

}
