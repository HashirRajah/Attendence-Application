package pages;

//imports
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import styles.*;
import variables.Variables;
import gui.*;

public class AdminAddStudent extends JPanel implements ActionListener {
    // attributes
    private JTextField studID, firstName, lastName, address, gender, email, ContactNumber, progID;
    private CenteredTextLabel studIDLabel, firstNameLabel, lastNameLabel, addressLabel, genderLabel, emailLabel, ContactNumberLabel, progIDLabel, title;
    private ButtonStyle1 save, cancel;
    private JPanel mainPanelContent, buttonPanels;

    // methods
    public AdminAddStudent(Theme theme) {
          super();
          this.setBackground(theme.getMainColor());
          this.setLayout(new BorderLayout());
          //

           //instantiating JLabels
           studIDLabel = new CenteredTextLabel("Student ID : ", theme.getContentColor());
           studIDLabel.setFont(new Font("consolas", Font.BOLD, 25));
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
           progIDLabel = new CenteredTextLabel("Program ID : ", theme.getContentColor());
           progIDLabel.setFont(new Font("consolas", Font.BOLD, 25));
           title = new CenteredTextLabel("Enter Details for Student", theme.getContentColor(), Variables.PAGES_TITLE);
           title.setPreferredSize(new Dimension(this.getWidth(), 150));         

           //instantiating JTextFields
           studID = new JTextField();
           firstName = new JTextField();
           lastName = new JTextField();
           address = new JTextField();
           gender = new JTextField();
           email = new JTextField();
           ContactNumber = new JTextField();
           progID = new JTextField();


           //border for text fields
           Border date_txt_border = BorderFactory.createLineBorder(Color.YELLOW, 0);      

           //Text Field design

           //address
           studID.setBackground(theme.getMenuColor());
           studID.setForeground(theme.getFontColor());
           studID.setFont(new Font("consolas", Font.BOLD, 20));
           studID.setCaretColor(theme.getFontColor());
           studID.setBorder(date_txt_border);     

          //first name
           firstName.setBackground(theme.getMenuColor());
           firstName.setForeground(theme.getFontColor());
           firstName.setFont(new Font("consolas", Font.BOLD, 20));
           firstName.setCaretColor(theme.getFontColor());
           firstName.setBorder(date_txt_border);      

           //last name
           lastName.setBackground(theme.getMenuColor());
           lastName.setForeground(theme.getFontColor());
           lastName.setFont(new Font("consolas", Font.BOLD, 20));
           lastName.setCaretColor(theme.getFontColor());
           lastName.setBorder(date_txt_border);

           //address
           address.setBackground(theme.getMenuColor());
           address.setForeground(theme.getFontColor());
           address.setFont(new Font("consolas", Font.BOLD, 20));
           address.setCaretColor(theme.getFontColor());
           address.setBorder(date_txt_border);
           
           //address
           gender.setBackground(theme.getMenuColor());
           gender.setForeground(theme.getFontColor());
           gender.setFont(new Font("consolas", Font.BOLD, 20));
           gender.setCaretColor(theme.getFontColor());
           gender.setBorder(date_txt_border);

           //address
           email.setBackground(theme.getMenuColor());
           email.setForeground(theme.getFontColor());
           email.setFont(new Font("consolas", Font.BOLD, 20));
           email.setCaretColor(theme.getFontColor());
           email.setBorder(date_txt_border);     

           //contact number
           ContactNumber.setBackground(theme.getMenuColor());
           ContactNumber.setForeground(theme.getFontColor());
           ContactNumber.setFont(new Font("consolas", Font.BOLD, 20));
           ContactNumber.setCaretColor(theme.getFontColor());
           ContactNumber.setBorder(date_txt_border);

           //address
           progID.setBackground(theme.getMenuColor());
           progID.setForeground(theme.getFontColor());
           progID.setFont(new Font("consolas", Font.BOLD, 20));
           progID.setCaretColor(theme.getFontColor());
           progID.setBorder(date_txt_border);     

           //instantiating JButtons
           cancel = new ButtonStyle1(theme, Color.GREEN, 0, "Cancel", 50, 50);
           cancel.setPreferredSize(new Dimension(100, 50));
           cancel.addActionListener(this);
           save = new ButtonStyle1(theme, Color.GREEN, 0, "Save", 50, 50);    
           save.setPreferredSize(new Dimension(100, 50));
           save.addActionListener(this);

           //instantiating main panel
           mainPanelContent = new JPanel();       

           //calling function to set up panel
           setUpMainPanel(theme);
           
           //adding components to panel
           this.add(title, BorderLayout.NORTH);
           this.add(mainPanelContent, BorderLayout.CENTER);  

          StylingPanel.setUpStylingPanels(theme, this, 50, 50);

    }

    private void setUpMainPanel(Theme theme) {

     this.mainPanelContent.setBackground(theme.getMainColor());
     this.mainPanelContent.setLayout(new GridLayout(8, 2, 0, 15));

     // addings components to login contents
     this.mainPanelContent.add(studIDLabel);
     this.mainPanelContent.add(studID);
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
     this.mainPanelContent.add(progIDLabel);
     this.mainPanelContent.add(progID);
     this.mainPanelContent.add(save);
     this.mainPanelContent.add(cancel);

 }

     public void actionPerformed(ActionEvent e) {
          if(e.getSource() == cancel) {

          }
          if(e.getSource() == save) {
               
          }


     }

}
