package pages;

//imports
import javax.swing.*;
import java.awt.*;
import styles.*;
import gui.*;

public class AccountSettingsPage extends JPanel {
    // attributes

    // methods
    public AccountSettingsPage(Theme theme) {
        super();
        this.setBackground(theme.getMainColor());
        //
        StylingPanel.setUpStylingPanels(theme, this, 50, 50);
    }
}
