package variables;

//imports
import java.awt.*;
import styles.Theme;
import java.util.HashMap;

import app_version.Configuration;

public class Variables {
    // application data
    public static HashMap<String, String> appData = new HashMap<String, String>();

    // frame attributes
    // dimensions
    public static final int MIN_WIDTH = 1200, MIN_HEIGHT = 675;// 16:9 aspect ratio
    // colors
    public static final Color FRAME_BG = new Color(202, 239, 209);

    // all themes
    // default theme
    public static final Theme DEFAULT = new Theme(Color.DARK_GRAY, Color.WHITE, new Color(245, 245, 245), Color.BLACK,
            "Default");

    // fonts
    // button fonts
    public static final Font DEFAULT_BUTTON_FONT = new Font("Arial", Font.BOLD, 20);

    // main pages
    public static String[] pages = new String[] { "start", "classes" };
}