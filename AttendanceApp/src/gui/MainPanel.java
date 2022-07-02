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
    public static ClassesList classList;
    public static ListOfClasses classes;
    private Settings settings;
    public static LoginPage login;
    private ThemeSettingPage themeSettings;
    private FontSettingsPage fontSettings;
    public static AccountSettingsPage accountSettings;
    public static HomePage homePage;
    public static AttendancePage attendance;
    public static ViewAttendance viewAttd;
    public static AddAttendance addAttd;

    public MainPanel(Theme theme) {
        super();
        // instantiating vars
        startPage = new StartPage(theme);
        classList = new ClassesList(theme);
        settings = new Settings(theme);
        login = new LoginPage(theme);
        themeSettings = new ThemeSettingPage(theme);
        fontSettings = new FontSettingsPage(theme);
        homePage = new HomePage(theme);
        // attendance = new AttendancePage(theme);
        classes = new ListOfClasses(theme);
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
        this.add(homePage, "home");
        // this.add(attendance, "attendance");
        this.add(classes, "list-of-classes");

        // show start page
        cl.show(this, Variables.pages[0]);
    }

}
