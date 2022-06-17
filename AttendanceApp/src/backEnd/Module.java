package backEnd;

//imports
import java.util.ArrayList;

public class Module {

     private String moduleCode;
     private String name;
     private ArrayList<Student> studentsEnrolled;
     private ArrayList<Program> listOfPrograms;
     private ArrayList<Lecturer> listOfLectures;
     private ArrayList<Classes> listOfClasses;

     public Module(String moduleCode, String name) {
          this.moduleCode = moduleCode;
          this.name = name;
     }

     public void setModuleCode(String moduleCode) {
          this.moduleCode = moduleCode;
     }

     public String getModuleCode() {
          return this.moduleCode;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getName() {
          return this.name;
     }

     public boolean checkName(String name) {

          boolean isSame = false;

          // codes to check names

          return isSame;
     }
}
