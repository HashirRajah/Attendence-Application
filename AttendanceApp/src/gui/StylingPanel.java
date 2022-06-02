package gui;

//imports
import javax.swing.*;
import styles.*;
import java.awt.*;

public class StylingPanel {
    //
    public static JPanel stylingPanels[];
    public static String[] positions = new String[] { BorderLayout.EAST, BorderLayout.WEST, BorderLayout.SOUTH };

    //
    public static void setUpStylingPanels(Theme theme, JPanel panel, int width, int height) {
        stylingPanels = new JPanel[3];
        for (int i = 0; i < stylingPanels.length; i++) {
            stylingPanels[i] = new JPanel();
            stylingPanels[i].setBackground(theme.getMainColor());
        }

        // set size
        stylingPanels[0].setPreferredSize(new Dimension(width, panel.getHeight()));
        stylingPanels[1].setPreferredSize(new Dimension(width, panel.getHeight()));
        stylingPanels[2].setPreferredSize(new Dimension(panel.getWidth(), height));

        for (int i = 0; i < stylingPanels.length; i++) {
            panel.add(stylingPanels[i], positions[i]);
        }
    }
}
