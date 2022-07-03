package pages;

//imports
import javax.swing.*;
import java.awt.*;
import gui.*;
import styles.*;
import variables.*;

public class InfoPanel extends JPanel {
    // attributes
    private CenteredTextLabel message;
    private JPanel okLabel;
    private ButtonStyle1 ok;

    // methods
    public InfoPanel(Theme theme) {
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(theme.getMainColor());
        // instantiating vars
        message = new CenteredTextLabel("", theme.getContentColor(), Variables.PAGES_TITLE2);
        okLabel = new JPanel();
        ok = new ButtonStyle1(theme, Color.BLACK, 4, "ok", 100, 60);
        // login label
        okLabel.setBackground(theme.getMainColor());
        okLabel.setPreferredSize(new Dimension(this.getWidth(), 100));
        okLabel.add(ok);

        // login button
        ok.addActionListener(e -> {
            if (!Variables.pagesStack.empty()) {
                Variables.pagesStack.pop();
            }
            if (!Variables.pagesStack.empty()) {
                MainPanel.cl.show(AppFrame.mainPanel, Variables.pagesStack.peek());
            }
        });
        // adding contents
        this.add(message, BorderLayout.CENTER);
        StylingPanel.setUpStylingPanels(theme, this, 50, 50);
        this.add(okLabel, BorderLayout.SOUTH);
    }

    public void setMyText(String text) {
        message.setText(text);
        message.repaint();
    }
}
