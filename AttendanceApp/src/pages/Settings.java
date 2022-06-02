package pages;

//imports
import javax.swing.*;
import styles.*;
import java.awt.*;
import variables.*;
import gui.*;

public class Settings extends JPanel {
    //
    private JLabel title;
    private JPanel allSettings;
    private SettingsButtonStyle[] settingsBtn;
    private String[] settingsList = new String[] { "Themes >", "Fonts >", "Account >" };

    public Settings(Theme theme) {
        super();
        // instantiating vars
        title = new JLabel();
        allSettings = new JPanel();

        // all settings
        allSettings.setBackground(theme.getMainColor());

        // title customization
        title.setPreferredSize(new Dimension(this.getWidth(), 150));
        title.setForeground(theme.getContentColor());
        title.setText("Settings");
        title.setFont(Variables.PAGES_TITLE);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);
        //
        this.setBackground(theme.getMainColor());
        this.setLayout(new BorderLayout());
        // add all settings
        setUpSettings(theme);

        // adding components
        this.add(title, BorderLayout.NORTH);
        this.add(allSettings, BorderLayout.CENTER);
        StylingPanel.setUpStylingPanels(theme, this, 150, 150);
    }

    private void setUpSettings(Theme theme) {
        settingsBtn = new SettingsButtonStyle[3];
        this.allSettings.setLayout(new GridLayout(settingsBtn.length, 1, 0, 10));
        //
        for (int i = 0; i < settingsBtn.length; i++) {
            //
            settingsBtn[i] = new SettingsButtonStyle(theme, theme.getMenuColor(), 3, this.settingsList[i]);
            this.allSettings.add(settingsBtn[i]);
            // adding action listenners
        }
    }
}
