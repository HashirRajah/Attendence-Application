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
    private String[] buttonText = new String[] { "Login", "Home", "Attendance", "Classes", "Settings", "Back" };

    public MenuSideBar(Theme theme) {
        super();
        //
        this.sideButton = new ArrayList<SidebarButton>();
        this.setLayout(new GridLayout(6, 1, 0, 10));
        this.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));
        this.setBackground(theme.getMenuColor());
        setupSideButton(theme);
    }

    private void setupSideButton(Theme theme) {
        for (int i = 0; i < buttonText.length; i++) {
            //
            sideButton.add(new SidebarButton(theme, this.buttonText[i], Variables.iconFilePath[i]));
            this.add(sideButton.get(i));
            // adding action listenners
        }

    }
}
