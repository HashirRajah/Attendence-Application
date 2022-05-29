package styles;

//imports
import javax.swing.JButton;
import java.awt.*;
import variables.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class SidebarButton extends JButton {

    private ImageIcon icon;

    public SidebarButton(Theme theme, String text, String iconPath) {
        super();
        // instantiating vars
        icon = new ImageIcon(iconPath);
        //
        // this.setPreferredSize(new Dimension(width, height));
        this.setText(text);
        this.setFocusable(false);
        this.setBackground(theme.getMenuColor());
        this.setForeground(theme.getFontColor());
        this.setFont(Variables.SIDE_BUTTON_FONT);
        this.setBorder(null);
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.BOTTOM);
        // icon
        this.setIcon(icon);

    }

}
