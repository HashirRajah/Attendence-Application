package app_version;

//imports
import variables.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Configuration {
    public static void runSetUp() {

    }

    public static void populateAppData() {
        Variables.appData.put("Name", "TheApp");
        Variables.appData.put("Version", "1.0");
    }
}
