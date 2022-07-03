package styles;

//imports
import javax.swing.JButton;
import java.awt.*;
import variables.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import event_handling.*;

public class ViewButton extends JButton {
    //
    private Border border;

    public ViewButton(Theme theme, Color borderColor, int borderThickness, String text) {
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
        // hover effect
        ButtonHover.HoverEffect(theme.getContentColor(), theme.getMainColor(), theme.getMainColor(),
                theme.getContentColor(), this);
    }

    public ViewButton(Theme theme, Color borderColor, int borderThickness, String text, Color buttoncolor) {
        super();
        // instantiating vars
        border = BorderFactory.createLineBorder(borderColor, borderThickness, false);
        //
        this.setText(text);
        this.setFocusable(false);
        this.setBorder(border);
        this.setBackground(buttoncolor);
        this.setForeground(theme.getFontColor());
        this.setFont(Variables.SETTINGS_FONT);
        // this.setHorizontalTextPosition(JButton.LEFT);
        // this.setVerticalTextPosition(JButton.CENTER);
        // hover effect
        //ButtonHover.BorderHover(new Border(theme.getMainColor()), theme.getMainColor(), this);
    }

    public ViewButton(Theme theme, String text) {
        super();
        // instantiating vars
        //
        this.setText(text);
        this.setFocusable(false);
        this.setBorder(border);
        this.setBackground(theme.getMainColor());
        this.setForeground(theme.getContentColor());
        this.setFont(Variables.SETTINGS_FONT);
        // this.setHorizontalTextPosition(JButton.LEFT);
        // this.setVerticalTextPosition(JButton.CENTER);
        // hover effect
        ButtonHover.HoverEffect(theme.getContentColor(), theme.getMainColor(), theme.getMainColor(),
                theme.getContentColor(), this);
    }

}
