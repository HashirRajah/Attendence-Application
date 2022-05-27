package pages;

//imports
import javax.swing.*;
import styles.*;

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

        public ClassPanel(Theme theme) {
            super();
            this.setBackground(theme.getMainColor());
        }
    }
}
