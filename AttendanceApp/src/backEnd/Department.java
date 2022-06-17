package backEnd;

public class Department {

    private int id;
    private String name;
    private static int nextId;
     
	
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

    public boolean checkDepartmentName(String name){

        if(this.name.equalsIgnoreCase(name))
          return true;
        return false;

    }


    
}