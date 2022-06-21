import app_version.Configuration;
import variables.Variables;
import db.*;
import gui.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // run all setups
        Configuration.populateAppData();
        Configuration.runSetUp();
        //
        AppFrame frame = new AppFrame(Variables.appData.get("Name"), Variables.activeTheme);

    }
}
