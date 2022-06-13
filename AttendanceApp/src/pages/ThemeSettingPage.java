package pages;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class ThemeSettingPage extends JPanel {

    // private String[] tNames = new String[] {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
    ThemeSettingPage() {

        // JLabel[] themeName = new JLabel[9];

        // for(int j = 1; j < 10; j++) {
        //     themeName[j].setText(tNames[j]);
        //     this.add(themeName[j]);
        // }

        this.setLayout(new GridLayout(3, 3, 20, 40));

        JButton buttonTheme;

        for(int i = 0; i < 9; i++) {

            JPanel color1 = new JPanel();
            JPanel color2 = new JPanel();

            color1.setBackground(new Color(255, 0, 0));
            color2.setBackground(new Color(0, 0, 255));

            // this.add(new JButton("color" + (i+1)));
            buttonTheme = new JButton();
            buttonTheme.setLayout(new GridLayout(1,2));

            buttonTheme.add(color1);
            buttonTheme.add(color2);

            buttonTheme.setBackground(Color.BLACK);

            this.add(buttonTheme);
        }

    }

}
