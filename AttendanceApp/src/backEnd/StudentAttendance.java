package backEnd;

import java.util.ArrayList;

public class StudentAttendance {
    private String presence;
    private Classes classes;
    private ArrayList<Attendance> listAttendance;

    // constructor
    public StudentAttendance(String presence) {

    }

    // presence
    public void setPresence(String presence) {
        this.presence = presence;
    }

    public String getPresence() {
        return this.presence;
    }
}
