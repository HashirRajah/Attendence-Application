package backEnd;

import java.util.ArrayList;

public class StudentAttendance {
    private String presence;
    private Classes classes;
    private ArrayList<Attendance> listOfAttendance;

    // constructor
    public StudentAttendance(String presence) {
        this.presence = presence;
        this.classes = classes;

    }

    // presence
    public void setPresence(String presence) {
        this.presence = presence;
    }

    public String getPresence() {
        return this.presence;
    }

    // Classes
    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Classes getClasses() {
        return this.classes;
    }

}
