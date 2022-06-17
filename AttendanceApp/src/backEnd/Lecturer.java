package backEnd;

//imports
import java.util.ArrayList;

public class Lecturer extends User {

    private String type;
    private ArrayList<Module> listOfModuleTaught;
    private ArrayList<Classes> listOfClasses;
    private Department department;

    public Lecturer(char gender, String email, String fName, String lName, String addr, String contactNo, String dob) {
        super(gender, email, fName, lName, addr, contactNo, dob);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

}
