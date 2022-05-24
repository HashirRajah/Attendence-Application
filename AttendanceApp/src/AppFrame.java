import java.awt.*;
import javax.swing.JFrame;
import variables.*;

public class AppFrame extends JFrame {
    //
    public AppFrame(String title) {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle(title);
        this.setResizable(true);
        this.setMinimumSize(new Dimension(Variables.MIN_WIDTH, Variables.MIN_HEIGHT));
        // this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.getContentPane().setBackground(Variables.FRAME_BG);
    }
}
