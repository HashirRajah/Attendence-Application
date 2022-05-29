package gui;

//imports
import javax.swing.JPanel;

import styles.SidebarButton;

import java.awt.*;
import variables.*;
import styles.*;
import java.util.ArrayList;
import event_handling.*;

public class MenuSideBar extends JPanel {
    //
    private final int WIDTH = 150, HEIGHT = Variables.MIN_HEIGHT;
    private ArrayList<SidebarButton> sideButton;
    private String[] buttonText = new String[] { "Home", "Attendance", "Classes", "Settings", "Back" };

    public MenuSideBar(Theme theme) {
        super();
        this.setLayout(new GridLayout(5, 1, 0, 10));
        this.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));
        this.setBackground(theme.getMenuColor());
        setupSideButton(theme);
    }

    private void setupSideButton(Theme theme) {
        this.sideButton = new ArrayList<SidebarButton>();
        for (int i = 0; i < 5; i++) {
            //
            sideButton.add(new SidebarButton(theme, this.buttonText[i], Variables.iconFilePath[i]));
            ButtonHover.HoverEffect(Variables.HoverColor, theme.getMenuColor(), sideButton.get(i));
            this.add(sideButton.get(i));
            // adding action listenners
        }

    }
}
