package styles;

//imports
import java.awt.*;

public class Theme {
    //
    private Color menuColor, fontColor, mainColor, contentColor, hoverColor, buttonColor,one,two,three;
    private String name;

    public Theme(Color menu, Color font, Color main, Color content, Color hover, String name) {
        this.menuColor = menu;
        this.fontColor = font;
        this.mainColor = main;
        this.contentColor = content;
        this.hoverColor = hover;
        this.name = name;
    }

    public Theme(Color menu, Color font, Color main, Color content, Color hover, String name, Color buttonColor) {
        this.menuColor = menu;
        this.fontColor = font;
        this.mainColor = main;
        this.contentColor = content;
        this.hoverColor = hover;
        this.name = name;
        this.buttonColor = buttonColor;
    }
    public Theme(Color menu, Color font, Color main, Color content, Color hover, String name, Color buttonColor, Color one, Color two, Color three) {
        this.menuColor = menu;
        this.fontColor = font;
        this.mainColor = main;
        this.contentColor = content;
        this.hoverColor = hover;
        this.name = name;
        this.buttonColor = buttonColor;
        this.one = one;
        this.two=two;
        this.three= three;
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

    public Color getHoverColor() {
        return this.hoverColor;
    }

    public Color getButtonColor() {
        return this.buttonColor;
    }

    public String getName() {
        return this.name;
    }
    public Color getOne() {
        return this.one;
    }
    public Color getTwo() {
        return this.two;
    }
    public Color getThree() {
        return this.three;
    }
}
