package pages;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//imports
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.*;
import variables.*;
import styles.*;
import java.util.ArrayList;
import event_handling.*;

public class LoginPage extends JPanel{
    

    private final int LOGIN_HEIGHT =  Variables. MIN_HEIGHT;
    private final int LOGIN_WIDTH =   Variables. MIN_WIDTH - 150;

    JLabel username;
    JLabel password;

    JTextField user_text;
    JPasswordField pass_text;

    JButton login_button;
    JButton forgot_password;
    


    public LoginPage(Theme theme){
        super();
        //this.setLayout(new GridLayout(5, 1, 0, 10));
    
        //this.setPreferredSize(new Dimension(this.LOGIN_WIDTH, this.LOGIN_HEIGHT));
        this.setBackground(theme.getMainColor());


        //this.setLayout(new GridLayout(3, 1, 0, 10));

        this.username = new JLabel("Username");
        this.password = new JLabel("Password");

        this.user_text = new JTextField();
        this.pass_text = new JPasswordField();

        this.login_button = new JButton("Login");
        this.forgot_password = new JButton("Forgot Password");

        this.setVisible(true);

        this.add(username);
        this.add(password);
        this.add(user_text);
        this.add(pass_text);
        this.add(login_button);
        this.add(forgot_password);

    }

  
}
