package pages;

//imports
import javax.swing.*;
import java.awt.*;
import gui.*;
import styles.*;
import variables.*;

public class FontSettingsPage extends JPanel {
    // attributes
    private CenteredTextLabel message;

    // methods
    public FontSettingsPage(Theme theme) {
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(theme.getMainColor());
        // instantiating vars
        message = new CenteredTextLabel("In development:)", theme.getContentColor(), Variables.PAGES_TITLE2);
        // adding contents
        this.add(message, BorderLayout.CENTER);
        StylingPanel.setUpStylingPanels(theme, this, 50, 50);
    }
}
