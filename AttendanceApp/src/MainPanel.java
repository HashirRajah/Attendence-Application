import javax.swing.JPanel;
import java.awt.*;
import pages.*;
import variables.Variables;

public class MainPanel extends JPanel {
    //
    public static CardLayout cl = new CardLayout();
    // all pages/panels
    private StartPage startPage;

    public MainPanel(Color bg, Color fg) {
        super();
        // instantiating vars
        startPage = new StartPage(bg, fg);
        this.setLayout(cl);
        this.setBackground(bg);
        // adding all pages
        this.add(startPage, Variables.pages[0]);

        // show start page
        cl.show(this, Variables.pages[0]);
    }
}
