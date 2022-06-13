package styles;

//imports
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import variables.*;
import javax.swing.border.Border;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import event_handling.*;

public class ClassButton extends JButton {

    private JLabel bannerLabel;
    private ImageIcon banner;

    public ClassButton(Theme theme, String text) {
        super();
        // instantiating vars
        // bannerLabel = new JLabel();
        banner = new ImageIcon("AttendanceApp/images/class.jpg");
        // this.setPreferredSize(new Dimension(width, height));

        this.setText(text);
        this.setFocusable(false);
        this.setBackground(theme.getMenuColor());
        this.setForeground(theme.getFontColor());
        this.setFont(Variables.SIDE_BUTTON_FONT);
        this.setBorder(null);
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.BOTTOM);

        // this.add(bannerLabel);
        // icon
        this.setIcon(banner);
        // bannerLabel.setIcon(banner);
        // hover effect
        ButtonHover.HoverEffect(theme.getHoverColor(), theme.getMenuColor(), theme.getFontColor(),
                theme.getFontColor(), this);

    }

}
