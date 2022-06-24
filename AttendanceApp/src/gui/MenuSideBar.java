package gui;

import javax.swing.JButton;
//imports
import javax.swing.JPanel;

import styles.SidebarButton;

import java.awt.*;
import variables.*;
import styles.*;
import java.util.ArrayList;
import event_handling.*;
import java.awt.event.*;
import app_version.*;

public class MenuSideBar extends JPanel {
    //
    private final int WIDTH = 150, HEIGHT = Variables.MIN_HEIGHT;
    private ArrayList<SidebarButton> sideButton;

    public MenuSideBar(Theme theme) {
        super();
        //
        this.setLayout(new GridLayout(5, 1, 0, 10));
        this.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));
        this.setBackground(theme.getMenuColor());
        setupSideButton(theme);
    }

    public void setupSideButton(Theme theme) {
        // remove all buttons before adding new;
        this.removeAll();
        // this.revalidate();
        // validate();
        this.sideButton = new ArrayList<SidebarButton>();
        for (int i = 0; i < Variables.activeMenu.size(); i++) {
            //
            sideButton.add(new SidebarButton(theme, Variables.activeMenu.get(i),
                    Variables.menuIcons.get(Variables.activeMenu.get(i))));
            this.add(sideButton.get(i));
            // System.out.println(sideButton.get(i).getText());
            // adding action listenners
            if (sideButton.get(i).getText().equals("Logout")) {
                sideButton.get(i).addActionListener(new Logout());
            }
        }
        this.revalidate();
        validate();
        this.repaint();
    }

    private class Logout implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Variables.loggedIn = false;
            Variables.userLoggedIn = null;
            Configuration.menuConfiguration();
            MainPanel.cl.show(AppFrame.mainPanel, "start");
            setupSideButton(Variables.activeTheme);
        }

    }
}
