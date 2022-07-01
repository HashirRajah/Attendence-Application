package pages;

//imports
import javax.swing.*;
import java.awt.*;
import styles.*;
import gui.*;
import variables.*;

public class HomePage extends JPanel {
    // attributes
    private JLabel title;
    private JPanel woohoo;
    private ButtonStyle1 classBtn;
    private String classStatus;

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
            title = new JLabel();
            woohoo = new JPanel();
            classStatus = "Woohoo.. No Class";
            // title customization
            title.setPreferredSize(new Dimension(this.getWidth(), 150));
            title.setForeground(theme.getContentColor());
            title.setText("<html>Hello " + Variables.userLoggedIn.getFirstName() + "<br />Welcome Back</html>");
            title.setFont(Variables.PAGES_TITLE);
            title.setVerticalAlignment(JLabel.CENTER);
            title.setHorizontalAlignment(JLabel.CENTER);
            this.add(title, BorderLayout.NORTH);

            woohoo.setLayout(new GridLayout(1, 1));
            woohoo.setBackground(theme.getMainColor());
            classBtn = new ButtonStyle1(theme, theme.getMenuColor(), 3, classStatus);
            woohoo.add(classBtn);
            this.add(woohoo);

        }
    }

    public void setUpTheme(Theme theme) {
        this.setBackground(theme.getMainColor());
    }
}
