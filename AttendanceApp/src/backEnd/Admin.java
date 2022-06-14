package backEnd;

public class Admin extends User {
    // attributes

    // methods
    public Admin(String username, char gender, String email, String fName, String lName, String addr, String contactNo,
            String passwdHash, String dob) {
        //
        super(username, gender, email, fName, lName, addr, contactNo,
                passwdHash, dob);
    }
}
