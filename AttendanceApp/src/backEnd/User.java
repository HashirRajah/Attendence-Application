package backEnd;

//imports

public abstract class User {
    // attributes
    protected String username, email, firstName, lastName, address, contactNo, passwordHash, dateOfBirth;
    protected char gender;

    // methods
    public User(String username, char gender, String email, String fName, String lName, String addr, String contactNo,
            String passwdHash, String dob) {
        this.username = username;
        this.gender = gender;
        this.email = email;
        this.firstName = fName;
        this.lastName = lName;
        this.address = addr;
        this.contactNo = contactNo;
        this.passwordHash = passwdHash;
        this.dateOfBirth = dob;
    }

    // overloaded constructor
    public User(char gender, String email, String fName, String lName, String addr, String contactNo,
            String dob) {

    }

    // setters and getters
    // username
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    // gender
    public void setGender(char gender) {
        this.gender = gender;
    }

    public char getGender() {
        return this.gender;
    }

    // email
    public void setEmail(String email) {
        if (Validations.validateEmail(email)) {
            this.email = email;
        } else {

        }
    }

    public String getEmail() {
        return this.email;
    }

    // firstName
    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    // lastName
    public void setLastName(String lName) {
        this.lastName = lName;
    }

    public String getLastName() {
        return this.lastName;
    }

    // address
    public void setAddress(String addr) {
        this.address = addr;
    }

    public String getAddress() {
        return this.address;
    }

    // contactNo
    public void setContactNo(String contactNo) {
        if (Validations.validateContactNo(contactNo)) {
            this.contactNo = contactNo;
        } else {

        }
    }

    public String getContactNo() {
        return this.contactNo;
    }

    // passwordHash
    public void updatePasswd(String passwd, String newPasswd) {
        // check password
        if (PasswordManipulation.validatePassword(passwd, this.passwordHash)) {
            // check strength of password
            if (Validations.passwordStrength(newPasswd)) {
                this.passwordHash = PasswordManipulation.hash(newPasswd);
                // update in db
            } else {

            }
        } else {

        }
    }

    private void setPassword(String passwd) {
        if (Validations.passwordStrength(passwd)) {
            this.passwordHash = PasswordManipulation.hash(passwd);
            // insert in db
        } else {

        }
    }

    public String getPasswordHash() {
        return this.passwordHash;
    }

    // dateOfBirth
    public void setDateOfBirth(String dob) {
        if (Validations.validateDateFormat(dob)) {
            this.dateOfBirth = dob;
        } else {

        }
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

}
