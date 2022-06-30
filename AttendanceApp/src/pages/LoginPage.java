package pages;

//imports
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.*;
import variables.*;
import styles.*;
import java.util.ArrayList;
import event_handling.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import gui.*;
import db.*;

public class LoginPage extends JPanel {
    //
    private ImageIcon profileIcon, lockIcon;
    //
    private JLabel forget;
    public static JLabel errorMsg;
    //
    private CenteredTextLabel title;
    private CenteredTextLabel username, password;

    private JTextField user_text;
    private JPasswordField pass_text;
    //
    private ButtonStyle1 login_button;
    //
    private JPanel loginContents;

    //
    public LoginPage(Theme theme) {

        super();
        this.setLayout(new BorderLayout());
        this.setBackground(theme.getMainColor());
        // this.setBackground(Color.DARK_GRAY);
        // instantiating vars
        title = new CenteredTextLabel("L O G I N", theme.getContentColor(), Variables.PAGES_TITLE);
        // title
        title.setPreferredSize(new Dimension(this.getWidth(), 150));
        // image
        // profileIcon = new ImageIcon("AttendanceApp/images/user2.png");

        ImageIcon profileIcon = new ImageIcon(new ImageIcon("AttendanceApp/images/user2.png").getImage()
                .getScaledInstance(32, 32, Image.SCALE_DEFAULT));

        lockIcon = new ImageIcon("AttendanceApp/images/lock1.png");

        loginContents = new JPanel();

        this.username = new CenteredTextLabel("USERNAME", theme.getContentColor(), Variables.LOGIN, profileIcon);
        this.password = new CenteredTextLabel("PASSWORD", theme.getContentColor(), Variables.LOGIN, lockIcon);

        // text field
        this.user_text = new JTextField();
        this.pass_text = new JPasswordField();

        // textfield design
        user_text.setBackground(theme.getMenuColor());
        user_text.setForeground(theme.getFontColor());
        user_text.setFont(new Font("consolas", Font.BOLD, 20));
        user_text.setCaretColor(theme.getFontColor());
        user_text.setText("JohnDoe99");

        Border user_text_border = BorderFactory.createLineBorder(Color.YELLOW, 0);

        user_text.setBorder(user_text_border);

        pass_text.setBackground(theme.getMenuColor());
        pass_text.setForeground(theme.getFontColor());
        pass_text.setFont(new Font("consolas", Font.PLAIN, 15));
        pass_text.setCaretColor(theme.getFontColor());
        pass_text.setBorder(user_text_border);
        //
        errorMsg = new JLabel("Your Cridentials seems to wrong:(");
        errorMsg.setHorizontalAlignment(JLabel.CENTER);
        errorMsg.setVerticalAlignment(JLabel.CENTER);
        errorMsg.setFont(new Font("consolas", Font.BOLD, 20));
        errorMsg.setForeground(theme.getContentColor());
        errorMsg.setVisible(false);

        this.login_button = new ButtonStyle1(theme, Color.GREEN, 0, "Login", 50, 50);
        login_button.addActionListener(e -> {
            DatabaseConnection.login(user_text.getText(), String.valueOf(pass_text.getPassword()));
        });
        // login_button.setBorder(new RoundBtn(15));
        this.forget = new JLabel("Forgot Password?");
        forget.setForeground(theme.getContentColor());
        // forget.setAlignmentX(CENTER_ALIGNMENT);
        forget.setHorizontalAlignment(JLabel.CENTER);
        // login contents
        setUpLoginContents(theme);
        // adding components
        this.add(title, BorderLayout.NORTH);
        this.add(loginContents, BorderLayout.CENTER);
        StylingPanel.setUpStylingPanels(theme, this, 300, 100);
        // adding icon images

    }

    private void setUpLoginContents(Theme theme) {

        this.loginContents.setBackground(theme.getMainColor());
        // this.loginContents.setBackground(Color.DARK_GRAY);
        this.loginContents.setLayout(new GridLayout(8, 1, 0, 20));

        // addings components to login contents
        this.loginContents.add(this.username);

        this.loginContents.add(user_text);
        this.loginContents.add(this.password);
        this.loginContents.add(pass_text);
        this.loginContents.add(login_button);
        this.loginContents.add(forget);
        this.loginContents.add(errorMsg);
    }

}
