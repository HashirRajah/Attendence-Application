package backEnd;

//imports
import java.util.ArrayList;

public class Group {

    private int level;
    private String name;
    private ArrayList<Student> listOfStudents;
    private ArrayList<Classes> listOfClasses;
    private Program program;

    public Group(int level, String name) {
        this.level = level;
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
