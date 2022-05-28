package pages;

//imports
import javax.swing.*;
import java.awt.*;
import styles.*;
import variables.Variables;

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

        public ClassPanel(Theme theme) {
            super();
            // instantiating vars
            infoLabel = new JLabel();
            //
            infoLabel.setText("Classes");
            infoLabel.setHorizontalAlignment(JLabel.CENTER);
            infoLabel.setVerticalAlignment(JLabel.CENTER);
            infoLabel.setVerticalTextPosition(JLabel.CENTER);
            infoLabel.setHorizontalTextPosition(JLabel.CENTER);
            infoLabel.setForeground(theme.getContentColor());
            infoLabel.setFont(Variables.DEFAULT_BUTTON_FONT);
            //
            this.setBackground(theme.getMainColor());
            this.setLayout(new BorderLayout());
            this.add(infoLabel, BorderLayout.NORTH);
        }
    }
}
