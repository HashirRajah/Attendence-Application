package backEnd;

public class Student extends User {
    // attributes
    private static int nextId;

    // methods
    public Student(String username, char gender, String email, String fName, String lName, String addr,
            String contactNo,
            String passwdHash, String dob) {
        super(username, gender, email, fName, lName, addr, contactNo, passwdHash, dob);
    }

    public int getNextId() {
        return nextId;
    }
}
