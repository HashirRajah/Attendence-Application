package pages;

//imports
import javax.swing.*;
import styles.ButtonStyle1;
import variables.Variables;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPage extends JPanel implements ActionListener {
    //
    private ImageIcon accountIcon, attendanceIcon, icon;
    private JLabel imageLabel, textLabel, imageLabel2, imageLabel3;
    private JPanel loginLabel;
    private ButtonStyle1 login;
    //
    private String message = new String("Login or Sign up");
    private String messageAnimation = new String("");
    private int position = 0;
    // timer
    private Timer timer;

    public StartPage(Color bg, Color fg) {
        super();
        // instantiating vars
        accountIcon = new ImageIcon("AttendanceApp/images/account.png");
        attendanceIcon = new ImageIcon("AttendanceApp/images/attendance.png");
        icon = new ImageIcon("AttendanceApp/images/immigration.png");
        imageLabel = new JLabel();
        textLabel = new JLabel();
        imageLabel2 = new JLabel();
        imageLabel3 = new JLabel();
        loginLabel = new JPanel();
        login = new ButtonStyle1(Variables.DEFAULT, Color.BLACK, 4, "Login", 100, 60);
        timer = new Timer(200, this);
        //
        timer.start();
        //
        imageLabel.setIcon(accountIcon);
        imageLabel.setForeground(Color.BLACK);
        imageLabel.setFont(new Font("Arial", Font.BOLD, 80));
        imageLabel.setText("Easy.");
        imageLabel.setHorizontalTextPosition(JLabel.CENTER);
        imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        //
        imageLabel2.setIcon(attendanceIcon);
        imageLabel2.setForeground(Color.BLACK);
        imageLabel2.setFont(new Font("Arial", Font.BOLD, 50));
        imageLabel2.setText("Fast.");
        imageLabel2.setHorizontalTextPosition(JLabel.CENTER);
        imageLabel2.setVerticalTextPosition(JLabel.BOTTOM);
        imageLabel2.setVerticalAlignment(JLabel.CENTER);
        imageLabel2.setHorizontalAlignment(JLabel.CENTER);
        //
        imageLabel3.setIcon(icon);
        imageLabel3.setForeground(Color.BLACK);
        imageLabel3.setFont(new Font("Arial", Font.BOLD, 50));
        imageLabel3.setText("Reliable.");
        imageLabel3.setHorizontalTextPosition(JLabel.CENTER);
        imageLabel3.setVerticalTextPosition(JLabel.BOTTOM);
        imageLabel3.setVerticalAlignment(JLabel.CENTER);
        imageLabel3.setHorizontalAlignment(JLabel.CENTER);
        //
        textLabel.setHorizontalTextPosition(JLabel.CENTER);
        textLabel.setVerticalTextPosition(JLabel.CENTER);
        textLabel.setVerticalAlignment(JLabel.CENTER);
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setForeground(fg);
        textLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        //
        this.setLayout(new BorderLayout());
        this.setBackground(bg);

        // login label
        loginLabel.setBackground(bg);
        loginLabel.setPreferredSize(new Dimension(this.getWidth(), 100));
        loginLabel.add(login);

        // adding components
        this.add(imageLabel, BorderLayout.CENTER);
        this.add(textLabel, BorderLayout.NORTH);
        this.add(loginLabel, BorderLayout.SOUTH);
        this.add(imageLabel2, BorderLayout.WEST);
        this.add(imageLabel3, BorderLayout.EAST);
    }

    private void typingAnimation() {
        if (position < message.length()) {
            messageAnimation += Character.toString(message.charAt(position));
            position++;
            textLabel.setText(messageAnimation + "_");
            textLabel.repaint();
            // System.out.print(messageAnimation);
        } else {
            timer.stop();
            // System.out.println("Done");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        typingAnimation();
    }
}
