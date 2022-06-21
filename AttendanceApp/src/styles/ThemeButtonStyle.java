package styles;

//imports
import javax.swing.*;
import java.awt.*;
import styles.*;
import variables.*;
import db.*;
import javax.swing.border.Border;
import event_handling.*;

public class ThemeButtonStyle extends JButton {
    // attributes
    private Border border, border2;
    private JPanel p1, p2, p3;
    private CenteredTextLabel name, menuText, mainText;

    // methods
    public ThemeButtonStyle(Theme theme, Theme appTheme) {
        super();
        //
        Color borderColor = appTheme.getHoverColor();
        //
        if (appTheme.getName().equals(theme.getName())) {
            borderColor = appTheme.getFontColor();
        }
        //
        border = BorderFactory.createLineBorder(appTheme.getContentColor(), 7, false);
        border2 = BorderFactory.createLineBorder(borderColor, 5, false);
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        name = new CenteredTextLabel(theme.getName(), appTheme.getContentColor(), Variables.THEME_BUTTON_FONT);
        menuText = new CenteredTextLabel("...", theme.getFontColor(), Variables.THEME_BUTTON_FONT2);
        mainText = new CenteredTextLabel("...", theme.getContentColor(), Variables.THEME_BUTTON_FONT2);
        //
        menuText.setVerticalAlignment(JLabel.CENTER);
        mainText.setVerticalAlignment(JLabel.CENTER);
        //
        p1.setBackground(theme.getMenuColor());
        p1.add(menuText);
        p2.setBackground(theme.getMainColor());
        p2.add(mainText);
        p3.setLayout(new GridLayout(1, 2, 0, 0));
        //
        p3.add(p1);
        p3.add(p2);
        //
        this.setBorder(border2);
        this.setFocusable(false);
        this.setLayout(new BorderLayout());
        this.setBackground(appTheme.getMainColor());
        //
        this.add(p3, BorderLayout.CENTER);
        this.add(name, BorderLayout.SOUTH);
        // adding action listener
        this.addActionListener(e -> {
            Variables.activeTheme = theme;
            DatabaseConnection.updateTheme(theme);
        });
        //
        ButtonHover.BorderHover(border, border2, this);
    }
}
