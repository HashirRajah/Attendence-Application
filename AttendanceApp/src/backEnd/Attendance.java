package backEnd;

public class Attendance {

    private int id;
    private String date;
    private int week;
    private int semester;

    public Attendance(int id, String date, int week, int semester) {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate(String date) {
        return this.date;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return this.week;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getSemester() {
        return this.semester;
    }
}
