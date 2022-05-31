package pages;

//imports
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.*;
import variables.*;
import styles.*;
import java.util.ArrayList;
import event_handling.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoginPage extends JPanel {
    //
    private CenteredTextLabel username, password, title;
    //
    private JTextField user_text;
    private JPasswordField pass_text;
    //
    private JButton login_button, forgot_password;
    //
    private JPanel loginContents, stylingPanels[];
    //
    private String[] positions = new String[] { BorderLayout.EAST, BorderLayout.WEST, BorderLayout.SOUTH };

    public LoginPage(Theme theme) {
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(theme.getMainColor());
        // instantiating vars
        title = new CenteredTextLabel("Login", theme.getContentColor(), Variables.PAGES_TITLE);
        loginContents = new JPanel();
        this.username = new CenteredTextLabel("Username", theme.getContentColor(), Variables.PAGES_TITLE);
        this.password = new CenteredTextLabel("Password", theme.getContentColor(), Variables.PAGES_TITLE);
        this.user_text = new JTextField();
        this.pass_text = new JPasswordField();
        this.login_button = new JButton("Login");
        this.forgot_password = new JButton("Forgot Password");
        // title
        title.setPreferredSize(new Dimension(this.getWidth(), 100));
        // login contents
        setUpLoginContents(theme);
        // adding components
        this.add(title, BorderLayout.NORTH);
        this.add(loginContents, BorderLayout.CENTER);
        setUpStylingPanels(theme);
    }

    private void setUpLoginContents(Theme theme) {
        this.loginContents.setBackground(theme.getMainColor());
        this.loginContents.setLayout(new GridLayout(5, 1, 0, 10));
        // addings components to login contents
        this.loginContents.add(this.username);
        this.loginContents.add(user_text);
    }

    private void setUpStylingPanels(Theme theme) {
        this.stylingPanels = new JPanel[3];
        for (int i = 0; i < stylingPanels.length; i++) {
            stylingPanels[i] = new JPanel();
            stylingPanels[i].setBackground(theme.getMainColor());
        }

        // set size
        stylingPanels[0].setPreferredSize(new Dimension(100, this.getHeight()));
        stylingPanels[1].setPreferredSize(new Dimension(100, this.getHeight()));
        stylingPanels[2].setPreferredSize(new Dimension(this.getWidth(), 100));

        for (int i = 0; i < stylingPanels.length; i++) {
            this.add(stylingPanels[i], this.positions[i]);
        }
    }

}
