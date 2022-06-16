package backEnd;

public class Group {

    private int level;
    private String name;

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