import javax.swing.JPanel;
import java.awt.*;
import variables.*;

public class MenuSideBar extends JPanel {
    //
    private final int WIDTH = 150, HEIGHT = Variables.MIN_HEIGHT;

    public MenuSideBar(Color bg) {
        super();
        // this.setLayout(new GridLayout());
        this.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));
        this.setBackground(bg);
    }
}
