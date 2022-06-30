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
import backEnd.*;

public class ClassButton extends JButton {

    private CenteredTextLabel className, classCode;
    private ImageIcon banner;
    private JPanel p1, p2, p3, p4;
    private Border border, border2;
    private Classes cls;

    public ClassButton(Theme theme, ModuleClass mod) {
        super();
        // instantiating vars
        // bannerLabel = new JLabel();
        // banner = new ImageIcon("AttendanceApp/images/class.jpg");
        // this.setPreferredSize(new Dimension(width, height));
        //
        border = BorderFactory.createLineBorder(theme.getFontColor(), 3, false);
        border2 = BorderFactory.createLineBorder(theme.getContentColor(), 5, false);
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        className = new CenteredTextLabel(mod.getName(), theme.getFontColor(), Variables.THEME_BUTTON_FONT);
        classCode = new CenteredTextLabel(mod.getModuleCode(), theme.getFontColor(), Variables.THEME_BUTTON_FONT);
        //
        p1.setBackground(theme.getMenuColor());
        p2.setBackground(theme.getContentColor());
        p3.setBackground(theme.getContentColor());
        p4.setBackground(theme.getContentColor());
        //
        className.setHorizontalAlignment(JLabel.LEFT);
        className.setVerticalAlignment(JLabel.BOTTOM);
        p1.add(classCode);
        p3.add(className);

        this.setText(mod.getName());
        this.setFocusable(false);
        this.setBackground(theme.getMenuColor());
        this.setLayout(new GridLayout(4, 1, 0, 0));
        // this.setForeground(theme.getFontColor());
        // this.setFont(Variables.SIDE_BUTTON_FONT);
        this.setBorder(border);
        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        // this.setHorizontalTextPosition(JButton.CENTER);
        // this.setVerticalTextPosition(JButton.BOTTOM);

        // this.add(bannerLabel);
        // icon
        // this.setIcon(banner);
        // bannerLabel.setIcon(banner);
        // hover effect
        // ButtonHover.HoverEffect(theme.getHoverColor(), theme.getMenuColor(),
        // theme.getFontColor(),
        // theme.getFontColor(), this);

        // event handling
        ButtonHover.BorderHover(border2, border, this);

    }

    public ClassButton(Theme theme, Classes c) {
        super();
        cls = c;
        // instantiating vars
        // bannerLabel = new JLabel();
        // banner = new ImageIcon("AttendanceApp/images/class.jpg");
        // this.setPreferredSize(new Dimension(width, height));
        //
        border = BorderFactory.createLineBorder(theme.getFontColor(), 3, false);
        border2 = BorderFactory.createLineBorder(theme.getContentColor(), 5, false);
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        className = new CenteredTextLabel(c.getStartTime(), theme.getFontColor(), Variables.THEME_BUTTON_FONT);
        classCode = new CenteredTextLabel(c.getType(), theme.getFontColor(), Variables.THEME_BUTTON_FONT);
        //
        p1.setBackground(theme.getMenuColor());
        p2.setBackground(theme.getContentColor());
        p3.setBackground(theme.getContentColor());
        p4.setBackground(theme.getContentColor());
        //
        className.setHorizontalAlignment(JLabel.LEFT);
        className.setVerticalAlignment(JLabel.BOTTOM);
        p1.add(classCode);
        p3.add(className);

        this.setText(c.getMode());
        this.setFocusable(false);
        this.setBackground(theme.getMenuColor());
        this.setLayout(new GridLayout(4, 1, 0, 0));
        // this.setForeground(theme.getFontColor());
        // this.setFont(Variables.SIDE_BUTTON_FONT);
        this.setBorder(border);
        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        // this.setHorizontalTextPosition(JButton.CENTER);
        // this.setVerticalTextPosition(JButton.BOTTOM);

        // this.add(bannerLabel);
        // icon
        // this.setIcon(banner);
        // bannerLabel.setIcon(banner);
        // hover effect
        // ButtonHover.HoverEffect(theme.getHoverColor(), theme.getMenuColor(),
        // theme.getFontColor(),
        // theme.getFontColor(), this);

        // event handling
        ButtonHover.BorderHover(border2, border, this);

    }

    public String getString() {
        return classCode.getText();
    }

    public Classes getClasses() {
        return this.cls;
    }
}
