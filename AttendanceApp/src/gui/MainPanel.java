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

    public MainPanel(Theme theme) {
        super();
        // instantiating vars
        startPage = new StartPage(theme);
        classList = new ClassesList(theme);
        settings = new Settings(theme);
        //
        this.setLayout(cl);
        this.setBackground(theme.getMainColor());
        // adding all pages
        this.add(startPage, Variables.pages[0]);
        this.add(classList, Variables.pages[1]);
        this.add(settings, Variables.pages[2]);

        // show start page
        cl.show(this, Variables.pages[0]);
    }
}
