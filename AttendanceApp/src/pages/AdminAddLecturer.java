package pages;

//imports
import javax.swing.*;
import javax.swing.border.*;

import backEnd.Lecturer;

import java.awt.*;
import java.awt.event.*;
import styles.*;
import variables.Variables;
import gui.*;
import db.*;

public class AdminAddLecturer extends JPanel implements ActionListener {
    // attributes
    private JTextField userName, firstName, lastName, address, gender, email, ContactNumber, type;
    private CenteredTextLabel userNameLabel, firstNameLabel, lastNameLabel, addressLabel, genderLabel, emailLabel,
            ContactNumberLabel, typeLabel, title;
    private ButtonStyle1 save, cancel;
    private JPanel mainPanelContent, buttonPanels;

    // methods
    public AdminAddLecturer(Theme theme) {
        super();
        this.setBackground(theme.getMainColor());
        this.setLayout(new BorderLayout());
        //

        // instantiating JLabels
        userNameLabel = new CenteredTextLabel("User Name : ", theme.getContentColor());
        userNameLabel.setFont(new Font("consolas", Font.BOLD, 25));
        firstNameLabel = new CenteredTextLabel("First Name : ", theme.getContentColor());
        firstNameLabel.setFont(new Font("consolas", Font.BOLD, 25));
        lastNameLabel = new CenteredTextLabel("Last Name : ", theme.getContentColor());
        lastNameLabel.setFont(new Font("consolas", Font.BOLD, 25));
        addressLabel = new CenteredTextLabel("Address : ", theme.getContentColor());
        addressLabel.setFont(new Font("consolas", Font.BOLD, 25));
        genderLabel = new CenteredTextLabel("Gender : ", theme.getContentColor());
        genderLabel.setFont(new Font("consolas", Font.BOLD, 25));
        emailLabel = new CenteredTextLabel("Email Address : ", theme.getContentColor());
        emailLabel.setFont(new Font("consolas", Font.BOLD, 25));
        ContactNumberLabel = new CenteredTextLabel("Contact Number : ", theme.getContentColor());
        ContactNumberLabel.setFont(new Font("consolas", Font.BOLD, 25));
        typeLabel = new CenteredTextLabel("Type : ", theme.getContentColor());
        typeLabel.setFont(new Font("consolas", Font.BOLD, 25));
        title = new CenteredTextLabel("Enter Details for Lecturer", theme.getContentColor(), Variables.PAGES_TITLE);
        title.setPreferredSize(new Dimension(this.getWidth(), 150));

        // instantiating JTextFields
        userName = new JTextField();
        firstName = new JTextField();
        lastName = new JTextField();
        address = new JTextField();
        gender = new JTextField();
        email = new JTextField();
        ContactNumber = new JTextField();
        type = new JTextField();

        // border for text fields
        Border date_txt_border = BorderFactory.createLineBorder(Color.YELLOW, 0);

        // Text Field design

        // address
        userName.setBackground(theme.getMenuColor());
        userName.setForeground(theme.getFontColor());
        userName.setFont(new Font("consolas", Font.BOLD, 20));
        userName.setCaretColor(theme.getFontColor());
        userName.setBorder(date_txt_border);

        // first name
        firstName.setBackground(theme.getMenuColor());
        firstName.setForeground(theme.getFontColor());
        firstName.setFont(new Font("consolas", Font.BOLD, 20));
        firstName.setCaretColor(theme.getFontColor());
        firstName.setBorder(date_txt_border);

        // last name
        lastName.setBackground(theme.getMenuColor());
        lastName.setForeground(theme.getFontColor());
        lastName.setFont(new Font("consolas", Font.BOLD, 20));
        lastName.setCaretColor(theme.getFontColor());
        lastName.setBorder(date_txt_border);

        // address
        address.setBackground(theme.getMenuColor());
        address.setForeground(theme.getFontColor());
        address.setFont(new Font("consolas", Font.BOLD, 20));
        address.setCaretColor(theme.getFontColor());
        address.setBorder(date_txt_border);

        // address
        gender.setBackground(theme.getMenuColor());
        gender.setForeground(theme.getFontColor());
        gender.setFont(new Font("consolas", Font.BOLD, 20));
        gender.setCaretColor(theme.getFontColor());
        gender.setBorder(date_txt_border);

        // address
        email.setBackground(theme.getMenuColor());
        email.setForeground(theme.getFontColor());
        email.setFont(new Font("consolas", Font.BOLD, 20));
        email.setCaretColor(theme.getFontColor());
        email.setBorder(date_txt_border);

        // contact number
        ContactNumber.setBackground(theme.getMenuColor());
        ContactNumber.setForeground(theme.getFontColor());
        ContactNumber.setFont(new Font("consolas", Font.BOLD, 20));
        ContactNumber.setCaretColor(theme.getFontColor());
        ContactNumber.setBorder(date_txt_border);

        // address
        type.setBackground(theme.getMenuColor());
        type.setForeground(theme.getFontColor());
        type.setFont(new Font("consolas", Font.BOLD, 20));
        type.setCaretColor(theme.getFontColor());
        type.setBorder(date_txt_border);

        // instantiating JButtons
        cancel = new ButtonStyle1(theme, Color.GREEN, 0, "Cancel", 50, 50);
        cancel.setPreferredSize(new Dimension(100, 50));
        cancel.addActionListener(this);
        save = new ButtonStyle1(theme, Color.GREEN, 0, "Save", 50, 50);
        save.setPreferredSize(new Dimension(100, 50));
        save.addActionListener(this);

        // instantiating main panel
        mainPanelContent = new JPanel();

        // calling function to set up panel
        setUpMainPanel(theme);

        // adding components to panel
        this.add(title, BorderLayout.NORTH);
        this.add(mainPanelContent, BorderLayout.CENTER);

        StylingPanel.setUpStylingPanels(theme, this, 50, 50);

    }

    private void setUpMainPanel(Theme theme) {

        this.mainPanelContent.setBackground(theme.getMainColor());
        this.mainPanelContent.setLayout(new GridLayout(9, 2, 10, 15));

        // addings components to login contents
        this.mainPanelContent.add(userNameLabel);
        this.mainPanelContent.add(userName);
        this.mainPanelContent.add(firstNameLabel);
        this.mainPanelContent.add(firstName);
        this.mainPanelContent.add(lastNameLabel);
        this.mainPanelContent.add(lastName);
        this.mainPanelContent.add(addressLabel);
        this.mainPanelContent.add(address);
        this.mainPanelContent.add(genderLabel);
        this.mainPanelContent.add(gender);
        this.mainPanelContent.add(emailLabel);
        this.mainPanelContent.add(email);
        this.mainPanelContent.add(ContactNumberLabel);
        this.mainPanelContent.add(ContactNumber);
        this.mainPanelContent.add(typeLabel);
        this.mainPanelContent.add(type);
        this.mainPanelContent.add(save);
        this.mainPanelContent.add(cancel);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {

        }
        if (e.getSource() == save) {
            // Lecturer lec = new Lecturer(username, gender, email, fName, lName, addr,
            // contactNo, passwordHash, dob, type)
            // DatabaseConnection.addLecturer(lec);
        }

    }

}
