import variables.Variables;
import App_Version.Configuration;

public class Main {
    public static void main(String[] args) throws Exception {
        // run all setups
        Configuration.populateAppData();
        //
        AppFrame frame = new AppFrame(Variables.appData.get("Name"), Variables.DEFAULT);
    }
}
