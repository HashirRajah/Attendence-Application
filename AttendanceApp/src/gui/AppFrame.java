package gui;

//imports
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import styles.Theme;
import variables.*;

public class AppFrame extends JFrame {
    // main components
    public static MenuSideBar menu;
    public static MainPanel mainPanel;
    private ImageIcon logo;

    public AppFrame(String title, Theme theme) {
        super();
        // instantiate variables
        menu = new MenuSideBar(theme);
        mainPanel = new MainPanel(theme);
        logo = new ImageIcon("AttendanceApp/images/logo.png");
        //
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setIconImage(logo.getImage());
        // this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setTitle(title);
        this.setResizable(true);
        this.setMinimumSize(new Dimension(Variables.MIN_WIDTH, Variables.MIN_HEIGHT));
        // this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.getContentPane().setBackground(Variables.FRAME_BG);
        this.add(this.menu, BorderLayout.WEST);
        this.add(mainPanel, BorderLayout.CENTER);
    }

}
