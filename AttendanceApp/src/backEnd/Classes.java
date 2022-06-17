package backEnd;

//import
import java.util.ArrayList;

public class Classes {

     private int id;
     private String mode;
     private String type;
     private String startTime;
     private String duration;
     private static int nextId;
     private Module module;
     private ArrayList<Lecturer> lecturer;
     private StudentAttendance attendance;

     public Classes(int id, String mode, String type, String startTime, String duration) {
          this.id = id;
          this.mode = mode;
          this.type = type;
          this.startTime = startTime;
          this.duration = duration;
     }

     public void setId(int id) {
          this.id = id;
     }

     public int getId() {
          return this.id;
     }

     public void setMode(String mode) {
          this.mode = mode;
     }

     public String getMode() {
          return this.mode;
     }

     public void setType(String type) {
          this.type = type;
     }

     public String getType() {
          return this.type;
     }

     public void setStartTime(String startTime) {
          this.startTime = startTime;
     }

     public String getStartTime() {
          return this.startTime;
     }

     public void setDuration(String duration) {
          this.duration = duration;
     }

     public String getDuration() {
          return this.duration;
     }

}
