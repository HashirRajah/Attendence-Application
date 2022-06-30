package pages;

//imports
import javax.swing.*;
import styles.*;
import java.awt.*;
import variables.*;
import gui.*;
import java.awt.event.*;
import java.util.HashMap;

public class Settings extends JPanel {
    //
    private JLabel title;
    private JPanel allSettings;
    private SettingsButtonStyle[] settingsBtn;
    private String[] settingsList = new String[] { "Themes >", "Fonts >", "Account >" };
    private HashMap<String, MyActionListeners> listOfListeners;

    public Settings(Theme theme) {
        super();
        // instantiating vars
        title = new JLabel();
        allSettings = new JPanel();

        // all settings
        allSettings.setBackground(theme.getMainColor());
        //
        this.setUpMyActionListeners();

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
            settingsBtn[i].addActionListener(listOfListeners.get(this.settingsList[i]));

        }
    }

    private void setUpMyActionListeners() {
        listOfListeners = new HashMap<String, MyActionListeners>();
        //
        listOfListeners.put(settingsList[0], new ShowThemeSettings());
        listOfListeners.put(settingsList[1], new ShowFontSettings());
        listOfListeners.put(settingsList[2], new ShowAccountSettings());
    }

    private class MyActionListeners implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub

        }

    }

    private class ShowThemeSettings extends MyActionListeners implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            MainPanel.cl.show(AppFrame.mainPanel, "theme-settings");
            Variables.pagesStack.push("theme-settings");
        }

    }

    private class ShowFontSettings extends MyActionListeners implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            MainPanel.cl.show(AppFrame.mainPanel, "font-settings");
            Variables.pagesStack.push("font-settings");
        }

    }

    private class ShowAccountSettings extends MyActionListeners implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            MainPanel.cl.show(AppFrame.mainPanel, "account-settings");
            Variables.pagesStack.push("account-settings");
        }

    }
}
