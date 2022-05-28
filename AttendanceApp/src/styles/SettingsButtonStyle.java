package styles;

//imports
import javax.swing.JButton;
import java.awt.*;
import variables.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class SettingsButtonStyle extends JButton {
    //
    private Border border;

    public SettingsButtonStyle(Theme theme, Color borderColor, int borderThickness, String text) {
        super();
        // instantiating vars
        border = BorderFactory.createLineBorder(borderColor, borderThickness, false);
        //
        this.setText(text);
        this.setFocusable(false);
        this.setBorder(border);
        this.setBackground(theme.getMainColor());
        this.setForeground(theme.getContentColor());
        this.setFont(Variables.SETTINGS_FONT);
        // this.setHorizontalTextPosition(JButton.LEFT);
        // this.setVerticalTextPosition(JButton.CENTER);
    }
}
