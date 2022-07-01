package backEnd;

public class Attendance {

    private int id;
    private String date;
    private int week;
    private int semester;
    private String status;

    public Attendance(int id, String date, int week, int semester, String status) {
        this.id = id;
        this.date = date;
        this.week = week;
        this.semester = semester;
        this.status = status;
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

    public String getDate() {
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

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
