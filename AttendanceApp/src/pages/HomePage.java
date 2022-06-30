package pages;

//imports
import javax.swing.*;
import java.awt.*;
import styles.*;
import gui.*;
import variables.*;

public class HomePage extends JPanel {
    // attributes
    private JLabel label;

    // methods
    public HomePage(Theme theme) {
        super();
        setUpTheme(theme);
        // setUpLabel(theme);
        this.setLayout(new BorderLayout());
        //
        StylingPanel.setUpStylingPanels(theme, this, 50, 50);
    }

    public void setUpLabel(Theme theme) {
        if (Variables.loggedIn && Variables.userLoggedIn != null) {
            this.label = new JLabel(
                    "<html>Hello " + Variables.userLoggedIn.getFirstName() + "<br />Welcome back</html>");
            label.setForeground(theme.getContentColor());
            label.setFont(Variables.PAGES_TITLE2);
            this.add(label, BorderLayout.NORTH);
        }
    }

    public void setUpTheme(Theme theme) {
        this.setBackground(theme.getMainColor());
    }
}
