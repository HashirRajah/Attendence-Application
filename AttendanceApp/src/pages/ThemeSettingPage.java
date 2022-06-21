package pages;

//imports
import javax.swing.*;
import gui.*;
import java.awt.*;
import styles.*;
import variables.*;

public class ThemeSettingPage extends JScrollPane {
    // attributes
    private ThemeSettingPagePanel content;

    // methods
    public ThemeSettingPage(Theme theme) {
        super();
        // instantiate vars
        content = new ThemeSettingPagePanel(theme);
        this.setViewportView(content);
    }

    public class ThemeSettingPagePanel extends JPanel {
        // attributes
        private CenteredTextLabel title;
        private JPanel allThemes;

        // methods
        public ThemeSettingPagePanel(Theme theme) {
            //
            super();
            this.setBackground(theme.getMainColor());
            this.setLayout(new BorderLayout());
            // instantiating vars
            title = new CenteredTextLabel("Settings > Theme", theme.getContentColor(), Variables.PAGES_TITLE2);
            title.setPreferredSize(new Dimension(this.getWidth(), 150));
            allThemes = new JPanel();
            // theme list
            allThemes.setBackground(theme.getMainColor());
            // calc rows and cols
            int rows = (Variables.themes.length / 3) + 1;
            allThemes.setLayout(new GridLayout(rows, 3, 10, 10));
            // add all themes
            addThemsList(allThemes, theme);
            // adding components
            this.add(title, BorderLayout.NORTH);
            this.add(allThemes, BorderLayout.CENTER);
            StylingPanel.setUpStylingPanels(theme, this, 150, 150);
        }

        private void addThemsList(JPanel panel, Theme theme) {
            for (int i = 0; i < Variables.themes.length; i++) {
                ThemeButtonStyle b = new ThemeButtonStyle(Variables.themes[i], theme);
                panel.add(b);
            }
        }
    }
}
