package variables;

//imports
import java.awt.*;
import styles.Theme;
import java.util.HashMap;

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
        public static final Theme DEFAULT = new Theme(Color.DARK_GRAY, Color.WHITE, new Color(245, 245, 245),
                        Color.BLACK, new Color(28, 28, 27),
                        "Default");

        // fonts
        // button fonts
        public static final Font DEFAULT_BUTTON_FONT = new Font("consolas", Font.BOLD, 20);
        public static final Font PAGES_TITLE = new Font("consolas", Font.PLAIN, 50);
        public static final Font SETTINGS_FONT = new Font("consolas", Font.PLAIN, 30);
        public static final Font SIDE_BUTTON_FONT = new Font("consolas", Font.BOLD, 15);

        // main pages
        public static String[] pages = new String[] { "start", "classes", "settings", "login" };

        // menu icons
        public static String[] iconFilePath = new String[] { "AttendanceApp/images/settingsIcon/home.png",
                        "AttendanceApp/images/settingsIcon/Attendance.png",
                        "AttendanceApp/images/settingsIcon/classes.png",
                        "AttendanceApp/images/settingsIcon/setting.png", "AttendanceApp/images/settingsIcon/back.png" };
}