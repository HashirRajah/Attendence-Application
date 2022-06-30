package pages;

//imports
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import styles.*;
import variables.Variables;
import gui.*;

public class AccountSettingsPage extends JPanel implements ActionListener {
    // attributes
    private JTextField address, firstName, lastName, ContactNumber;
    private CenteredTextLabel addressLabel, firstNameLabel, lastNameLabel, ContactNumberLabel, title;
    private ButtonStyle1 edit, save, close;
    private JPanel accountSettingContent, buttonPanels;

    // methods
    public AccountSettingsPage(Theme theme) {
          super();
          this.setBackground(theme.getMainColor());
          this.setLayout(new BorderLayout());
          //

           //instantiating JLabels
           addressLabel = new CenteredTextLabel("Address : ", theme.getContentColor());
           addressLabel.setFont(new Font("consolas", Font.BOLD, 25));
           firstNameLabel = new CenteredTextLabel("First Name : ", theme.getContentColor());
           firstNameLabel.setFont(new Font("consolas", Font.BOLD, 25));
           lastNameLabel = new CenteredTextLabel("Last Name : ", theme.getContentColor());
           lastNameLabel.setFont(new Font("consolas", Font.BOLD, 25));
           ContactNumberLabel = new CenteredTextLabel("Contact Number : ", theme.getContentColor());
           ContactNumberLabel.setFont(new Font("consolas", Font.BOLD, 25));
           title = new CenteredTextLabel("User Details", theme.getContentColor(), Variables.PAGES_TITLE);
           title.setPreferredSize(new Dimension(this.getWidth(), 150));         
           //instantiating JTextFields
           address = new JTextField();
           firstName = new JTextField();
           lastName = new JTextField();
           ContactNumber = new JTextField();      

           //border for text fields
           Border date_txt_border = BorderFactory.createLineBorder(Color.YELLOW, 0);      

           //Text Field design
           //address
           address.setBackground(theme.getMenuColor());
           address.setForeground(theme.getFontColor());
           address.setFont(new Font("consolas", Font.BOLD, 20));
           address.setCaretColor(theme.getFontColor());
           address.setBorder(date_txt_border);         

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

           //contact number
           ContactNumber.setBackground(theme.getMenuColor());
           ContactNumber.setForeground(theme.getFontColor());
           ContactNumber.setFont(new Font("consolas", Font.BOLD, 20));
           ContactNumber.setCaretColor(theme.getFontColor());
           ContactNumber.setBorder(date_txt_border);       

           //instantiating JButtons
           edit = new ButtonStyle1(theme, Color.GREEN, 0, "Edit", 50, 50);
           edit.setPreferredSize(new Dimension(100, 550));
           close = new ButtonStyle1(theme, Color.GREEN, 0, "Close", 50, 50);
           close.setPreferredSize(new Dimension(100, 50));
           save = new ButtonStyle1(theme, Color.GREEN, 0, "Save", 50, 50);    
           save.setPreferredSize(new Dimension(100, 50));

           //instantiating main panel
           accountSettingContent = new JPanel();       

           //calling function to set up panel
           setUpAccountSettingt(theme);
           
           //adding components to panel
           this.add(title, BorderLayout.NORTH);
           this.add(accountSettingContent, BorderLayout.CENTER);  

          StylingPanel.setUpStylingPanels(theme, this, 50, 50);

    }

    private void setUpAccountSettingt(Theme theme) {

     this.accountSettingContent.setBackground(theme.getMainColor());
     this.accountSettingContent.setLayout(new GridLayout(9, 1, 0, 15));

     // addings components to login contents
     this.accountSettingContent.add(addressLabel);
     this.accountSettingContent.add(address);
     this.accountSettingContent.add(firstNameLabel);
     this.accountSettingContent.add(firstName);
     this.accountSettingContent.add(lastNameLabel);
     this.accountSettingContent.add(lastName);
     this.accountSettingContent.add(ContactNumberLabel);
     this.accountSettingContent.add(ContactNumber);
     panelForButtons(theme);
     this.accountSettingContent.add(buttonPanels);
     // this.accountSettingContent.add(edit);
     // this.accountSettingContent.add(save);
     // this.accountSettingContent.add(close);
 }

 private void panelForButtons(Theme theme) {

     buttonPanels = new JPanel(new GridLayout(1, 3, 10, 0));
     buttonPanels.setBackground(theme.getMainColor());

     buttonPanels.add(edit);
     buttonPanels.add(save);
     buttonPanels.add(close);

 } 

     public void actionPerformed(ActionEvent e) {
          if(e.getSource() == close) {
               
          }
          if(e.getSource() == save) {
               
          }
          if(e.getSource() == edit) {
               
          }

     }

}
