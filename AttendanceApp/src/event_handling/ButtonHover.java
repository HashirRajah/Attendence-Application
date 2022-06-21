package event_handling;

//imports
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.border.Border;
import styles.SidebarButton;
import java.awt.*;

public class ButtonHover {

    public static void HoverEffect(Color entered, Color exited, Color fgEntered, Color fgExited, JButton b) {
        b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                evt.getComponent().setBackground(entered);
                evt.getComponent().setForeground(fgEntered);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                evt.getComponent().setBackground(exited);
                evt.getComponent().setForeground(fgExited);
            }

        });
    }

    /*
     * static void Button1(JButton b) {
     * b.addMouseListener(new java.awt.event.MouseAdapter() {
     * 
     * public void mouseClicked(java.awt.event.MouseEvent evt) {
     * evt.getComponent().setBackground(Color.ORANGE);
     * setActive(SidebarButton.buttons);
     * }
     * 
     * });
     * 
     * }
     */

    public static void BorderHover(Border entered, Border exited, JButton b) {
        b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ((JComponent) evt.getComponent()).setBorder(entered);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                ((JComponent) evt.getComponent()).setBorder(exited);
            }
        });
    }

    /*
     * public static void setActive(ToolbarButton[] t) {
     * for (int i = 0; i < t.length; i++) {
     * if (t[i].getText() != Variables.playing) {
     * t[i].setBackground(Variables.LEATHER);
     * }
     * }
     * }
     */
}