package pages;

//imports
import javax.swing.*;
import java.awt.*;
import styles.*;
import variables.Variables;
import gui.*;

public class ClassesList extends JScrollPane {
    //
    private ClassPanel allClasses;

    public ClassesList(Theme theme) {
        super();
        // instantiate vars
        allClasses = new ClassPanel(theme);
        this.setViewportView(allClasses);
    }

    public class ClassPanel extends JPanel {
        //
        private JLabel infoLabel;
        private JPanel listOfClasses;

        //
        public ClassPanel(Theme theme) {
            super();
            // instantiating vars
            infoLabel = new JLabel();
            listOfClasses = new JPanel();
            // list of classes
            listOfClasses.setLayout(new GridLayout(3, 3, 20, 20));
            listOfClasses.setBackground(theme.getMainColor());
            //
            infoLabel.setText("Classes");
            infoLabel.setPreferredSize(new Dimension(this.getWidth(), 150));
            infoLabel.setHorizontalAlignment(JLabel.CENTER);
            infoLabel.setVerticalAlignment(JLabel.CENTER);
            infoLabel.setForeground(theme.getContentColor());
            infoLabel.setFont(Variables.PAGES_TITLE);
            //
            this.setBackground(theme.getMainColor());
            this.setLayout(new BorderLayout());
            this.add(infoLabel, BorderLayout.NORTH);
            this.add(listOfClasses, BorderLayout.CENTER);
            StylingPanel.setUpStylingPanels(theme, this, 50, 50);
            addClasses(listOfClasses);
        }

        private void addClasses(JPanel panel) {
            for (int i = 0; i < 9; i++) {
                JButton button = new JButton("Class" + i);
                button.setPreferredSize(new Dimension(100, 100));
                panel.add(button);
            }
        }
    }
}
