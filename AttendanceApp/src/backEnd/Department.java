package backEnd;

//imports
import java.util.ArrayList;

public class Department {

	private int id;
	private String name;
	private static int nextId;
	private ArrayList<Student> listOfStudents;
	private ArrayList<Lecturer> listOfLecturer;
	private ArrayList<Department> listOfDepartment;

	public Department(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int getNextId() {
		return nextId;
	}

	public boolean checkDepartmentName(String name) {

		if (this.name.equalsIgnoreCase(name))
			return true;
		return false;

	}

}