package backEnd;

//imports
import java.util.ArrayList;

public class Lecturer extends User {

    private String type;
    private ArrayList<ModuleClass> listOfModuleTaught;
    private ArrayList<Classes> listOfClasses;
    private Department department;

    public Lecturer(String username, char gender, String email, String fName, String lName, String addr,
            String contactNo, String passwordHash, String dob, String type) {
        super(username, gender, email, fName, lName, addr, contactNo, passwordHash, dob);
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

}
