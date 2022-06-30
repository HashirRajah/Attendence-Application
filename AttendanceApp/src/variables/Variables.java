package variables;

//imports
import java.awt.*;
import styles.Theme;
import java.util.HashMap;
import backEnd.*;
import java.util.ArrayList;
import java.util.Stack;

public class Variables {
        // application data
        public static HashMap<String, String> appData = new HashMap<String, String>();

        // frame attributes
        // dimensions
        public static final int MIN_WIDTH = 1200, MIN_HEIGHT = 675;// 16:9 aspect ratio
        // colors
        public static final Color FRAME_BG = new Color(202, 239, 209);

        // all themes
        // public Theme(Color menu, Color font, Color main, Color content, Color hover,
        // String name)
        // default theme
        public static final Theme DEFAULT = new Theme(Color.DARK_GRAY, Color.WHITE, new Color(245, 245, 245),
                        Color.BLACK, new Color(28, 28, 27),
                        "Default", Color.BLACK);

        // Theme 1
        public static final Theme BUMBLEBEE = new Theme(new Color(13, 14, 15),
                        new Color(244, 180, 10),
                        new Color(26, 27, 31),
                        Color.WHITE,
                        new Color(28, 28, 27),
                        "Bumblebee",
                        new Color(244, 180, 10));

        public static final Theme LAVENDER = new Theme(new Color(74, 56, 115),
                        Color.WHITE,
                        new Color(42, 28, 73),
                        Color.WHITE,
                        new Color(22, 10, 68),
                        "Lavender",
                        new Color(12, 5, 35));

        public static final Theme JUNGLE_FURY = new Theme(new Color(38, 58, 71),
                        new Color(35, 173, 86),
                        new Color(24, 37, 46),
                        Color.WHITE,
                        new Color(0, 48, 40),
                        "Jungle_fury",
                        new Color(35, 173, 86));

        public static final Theme BLUEBERRY = new Theme(new Color(13, 25, 51),
                        new Color(156, 195, 255),
                        new Color(26, 49, 97),
                        Color.WHITE,
                        new Color(38, 69, 135),
                        "Blueberry",
                        new Color(52, 100, 201));

        public static final Theme CANDY = new Theme(new Color(64, 62, 64),
                        new Color(230, 78, 139),
                        new Color(33, 32, 33),
                        Color.WHITE,
                        new Color(51, 40, 43),
                        "Candy",
                        new Color(230, 78, 139));

        public static final Theme MIDNIGHT_RED = new Theme(new Color(48, 3, 3),
                        new Color(245, 245, 245),
                        new Color(97, 31, 31),
                        Color.WHITE,
                        new Color(130, 59, 59),
                        "Midnight_red",
                        new Color(130, 59, 59));

        public static final Theme GREEN = new Theme(new Color(32, 145, 122),
                        new Color(3, 28, 23),
                        new Color(16, 156, 112),
                        Color.WHITE,
                        new Color(84, 240, 216),
                        "Green",
                        new Color(84, 240, 216));

        public static final Theme DEVESH_SPECIAL_THEME = new Theme(new Color(69, 12, 37),
                        new Color(78, 140, 89),
                        new Color(120, 20, 15),
                        Color.WHITE,
                        new Color(200, 10, 100),
                        "Devesh_Special_Theme",
                        new Color(210, 90, 100));

        // array and hashmap of themes
        public static Theme[] themes = new Theme[] { DEFAULT, MIDNIGHT_RED, CANDY, BLUEBERRY, JUNGLE_FURY, LAVENDER,
                        BUMBLEBEE, GREEN, DEVESH_SPECIAL_THEME };
        public static HashMap<String, Theme> allThemes = new HashMap<String, Theme>();
        // active theme
        public static Theme activeTheme = DEFAULT;
        // fonts
        // button fonts
        public static final Font DEFAULT_BUTTON_FONT = new Font("consolas", Font.BOLD, 20);
        public static final Font PAGES_TITLE = new Font("consolas", Font.PLAIN, 60);
        public static final Font PAGES_TITLE2 = new Font("consolas", Font.PLAIN, 40);
        public static final Font SETTINGS_FONT = new Font("consolas", Font.PLAIN, 30);
        public static final Font THEME_BUTTON_FONT = new Font("consolas", Font.PLAIN, 20);
        public static final Font THEME_BUTTON_FONT2 = new Font("consolas", Font.BOLD, 25);
        public static final Font SIDE_BUTTON_FONT = new Font("consolas", Font.BOLD, 15);

        // LOGIN
        public static final Font LOGIN = new Font("consolas", Font.PLAIN, 30);

        // main pages
        public static String[] pages = new String[] { "start", "classes", "settings", "login", "theme-settings",
                        "font-settings", "account-settings" };

        // menu icons
        public static String[] iconFilePath = new String[] { "AttendanceApp/images/settingsIcon/home.png",
                        "AttendanceApp/images/settingsIcon/dashboard.png",
                        "AttendanceApp/images/settingsIcon/classes.png",
                        "AttendanceApp/images/settingsIcon/setting.png",
                        "AttendanceApp/images/settingsIcon/back.png", "AttendanceApp/images/settingsIcon/login.png",
                        "AttendanceApp/images/settingsIcon/logout.png" };
        public static HashMap<String, String> menuIcons = new HashMap<String, String>();
        public static String[] allMenu = new String[] { "Home", "Dashboard", "Classes", "Settings", "Back", "Login",
                        "Logout" };

        // Class Text
        public static String[] classText = new String[] { "Algorithm & Complexities", "Object Oriented Programming",
                        "Operating System", "Web-Centric Computing", "Computer Graphics", "Software Engineering",
                        "Programming", "Database Design", "Formal System" };

        // menu
        public static String[] studentMenu = new String[] { "Home", "Classes", "Settings", "Logout", "Back" };
        public static String[] lecturerMenu = new String[] { "Home", "Classes", "Settings", "Logout", "Back" };
        public static String[] adminMenu = new String[] { "Dashboard", "Settings", "Logout", "Back" };
        public static ArrayList<String> activeMenu;

        // login
        public static boolean loggedIn = false;
        public static User userLoggedIn;
        public static String userType = "";

        // pages stack
        public static Stack<String> pagesStack = new Stack<String>();
}
