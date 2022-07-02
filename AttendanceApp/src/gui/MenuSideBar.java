package gui;

//imports
import javax.swing.JPanel;
import styles.SidebarButton;
import java.awt.*;
import variables.*;
import styles.*;
import java.util.ArrayList;
import event_handling.*;
import pages.AdminDashBoard;

import java.awt.event.*;
import app_version.*;
import javax.swing.JButton;
import java.util.HashMap;
import db.*;

public class MenuSideBar extends JPanel {
    //
    private final int WIDTH = 150, HEIGHT = Variables.MIN_HEIGHT;
    private ArrayList<SidebarButton> sideButton;
    private HashMap<String, MyActionListener> myListeners;

    public MenuSideBar(Theme theme) {
        super();
        //
        setUpMyListeners();
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
            sideButton.get(i).addActionListener(this.myListeners.get(Variables.activeMenu.get(i)));

        }
        this.revalidate();
        validate();
        this.repaint();
    }

    private void setUpMyListeners() {
        myListeners = new HashMap<String, MyActionListener>();
        //
        myListeners.put("Logout", new Logout());
        myListeners.put("Login", new Login());
        myListeners.put("Settings", new Settings());
        myListeners.put("Back", new Back());
        myListeners.put("Home", new Home());
        myListeners.put("Classes", new Classes());
        myListeners.put("Dashboard", new DashBoard());
    }

    private class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub

        }

    }

    private class Logout extends MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Variables.loggedIn = false;
            Variables.userLoggedIn = null;
            MainPanel.classList.getAllClasses().getClassButtons().clear();
            MainPanel.classList.getAllClasses().getListOfClasses().removeAll();
            MainPanel.classes.getAllClassesList().getClassButtons().clear();
            MainPanel.classes.getAllClassesList().getListOfClasses().removeAll();
            Configuration.menuConfiguration();
            MainPanel.cl.show(AppFrame.mainPanel, "start");
            setupSideButton(Variables.activeTheme);
        }

    }

    private class Classes extends MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            MainPanel.cl.show(AppFrame.mainPanel, "classes");
            Variables.pagesStack.push("classes");
            DatabaseConnection.fetchClasses();
        }

    }

    private class Login extends MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            MainPanel.cl.show(AppFrame.mainPanel, "login");
        }

    }

    private class Settings extends MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            MainPanel.cl.show(AppFrame.mainPanel, "settings");
            Variables.pagesStack.push("settings");
        }

    }

    private class Back extends MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!Variables.pagesStack.empty()) {
                Variables.pagesStack.pop();
            }
            if (!Variables.pagesStack.empty()) {
                MainPanel.cl.show(AppFrame.mainPanel, Variables.pagesStack.peek());
            }
        }

    }

    private class Home extends MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            MainPanel.cl.show(AppFrame.mainPanel, "home");
            Variables.pagesStack.push("home");
        }

    }

    private class DashBoard extends MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            MainPanel.cl.show(AppFrame.mainPanel, "dashboard");
            Variables.pagesStack.push("dashboard");
        }

    }
}
