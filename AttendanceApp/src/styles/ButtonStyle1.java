package styles;

//imports
import javax.swing.JButton;
import java.awt.*;
import variables.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class ButtonStyle1 extends JButton {
    //
    private Border border;

    public ButtonStyle1(Theme theme, Color borderColor, int borderThickness, String text, int width, int height) {
        super();
        // instantiating vars
        border = BorderFactory.createLineBorder(borderColor, borderThickness, true);
        //
        this.setPreferredSize(new Dimension(width, height));
        this.setText(text);
        this.setFocusable(false);
        this.setBorder(border);
        this.setBackground(theme.getMenuColor());
        this.setForeground(theme.getFontColor());
        this.setFont(Variables.DEFAULT_BUTTON_FONT);
        // this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.CENTER);

    }
}
