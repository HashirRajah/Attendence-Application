package styles;

//imports
import java.awt.*;

public class Theme {
    //
    private Color menuColor, fontColor, mainColor, contentColor;
    private String name;

    public Theme(Color menu, Color font, Color main, Color content, String name) {
        this.menuColor = menu;
        this.fontColor = font;
        this.mainColor = main;
        this.contentColor = content;
        this.name = name;
    }

    public Color getMenuColor() {
        return this.menuColor;
    }

    public Color getFontColor() {
        return this.fontColor;
    }

    public Color getMainColor() {
        return this.mainColor;
    }

    public Color getContentColor() {
        return this.contentColor;
    }

    public String getName() {
        return this.name;
    }
}
