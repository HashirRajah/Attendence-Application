package styles;

//imports
import javax.swing.*;
import java.awt.*;

public class CenteredTextLabel extends JLabel {
    //
    public CenteredTextLabel(String text, Color fg, Font font) {
        super();
        //
        this.setText(text);
        this.setForeground(fg);
        this.setFont(font);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
    }
}
