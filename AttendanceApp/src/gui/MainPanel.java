package gui;

//imports
import javax.swing.JPanel;
import java.awt.*;
import pages.*;
import variables.Variables;
import styles.*;

public class MainPanel extends JPanel {
    //
    public static CardLayout cl = new CardLayout();
    // all pages/panels
    private StartPage startPage;
    private ClassesList classList;
    private Settings settings;
    private LoginPage login;
    private ThemeSettingPage themeSettings;
    private FontSettingsPage fontSettings;
    private AccountSettingsPage accountSettings;

    public MainPanel(Theme theme) {
        super();
        // instantiating vars
        startPage = new StartPage(theme);
        classList = new ClassesList(theme);
        settings = new Settings(theme);
        login = new LoginPage(theme);
        themeSettings = new ThemeSettingPage(theme);
        fontSettings = new FontSettingsPage(theme);
        accountSettings = new AccountSettingsPage(theme);
        //
        this.setLayout(cl);
        this.setBackground(theme.getMainColor());
        // adding all pages
        this.add(startPage, Variables.pages[0]);
        this.add(classList, Variables.pages[1]);
        this.add(settings, Variables.pages[2]);
        this.add(login, Variables.pages[3]);
        this.add(themeSettings, Variables.pages[4]);
        this.add(fontSettings, Variables.pages[5]);
        this.add(accountSettings, Variables.pages[6]);

        // show start page
        cl.show(this, Variables.pages[0]);
    }
}
