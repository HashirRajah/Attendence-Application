import java.awt.*;
import javax.swing.JFrame;
import styles.Theme;
import variables.*;

public class AppFrame extends JFrame {
    // main components
    private MenuSideBar menu;
    private MainPanel mainPanel;

    public AppFrame(String title, Theme theme) {
        super();
        // instantiate variables
        menu = new MenuSideBar(theme.getMenuColor());
        mainPanel = new MainPanel(theme.getMainColor(), theme.getContentColor());
        //
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        // this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setTitle(title);
        this.setResizable(true);
        this.setMinimumSize(new Dimension(Variables.MIN_WIDTH, Variables.MIN_HEIGHT));
        // this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.getContentPane().setBackground(Variables.FRAME_BG);
        this.add(this.menu, BorderLayout.WEST);
        this.add(this.mainPanel, BorderLayout.CENTER);
    }
}
