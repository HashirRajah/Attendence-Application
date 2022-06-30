import app_version.Configuration;
import variables.Variables;
import db.*;
import gui.*;
import backEnd.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // run all setups
        Configuration.populateAppData();
        Configuration.runSetUp();
        Configuration.menuConfiguration();
        //
        AppFrame frame = new AppFrame(Variables.appData.get("Name"), Variables.JUNGLE_FURY);


    }
}
