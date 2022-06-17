package backEnd;

//imports
import java.util.ArrayList;

public class Program {

	private int id;
	private String name;
	private String type;
	private static int nextId;
	private ArrayList<Student> listOfStudents;
	private ArrayList<Module> listOfModules;
	private ArrayList<Group> listOfGroup;
	private Department department;

	public Program(int id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static int getNextId() {
		return nextId;
	}

	public boolean checkProgramName(String name) {

		if (this.name.equalsIgnoreCase(name))
			return true;
		return false;

	}

}