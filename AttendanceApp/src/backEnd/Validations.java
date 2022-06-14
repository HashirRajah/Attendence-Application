package backEnd;

//imports
import java.util.regex.*;

public class Validations {
    // methods for validation
    // date
    public static boolean validateDateFormat(String date) {
        return Pattern.matches("^[\\d]{2}/[\\d]{2}/[\\d]{4}$", date);
    }

    // email
    public static boolean validateEmail(String email) {
        return Pattern.matches("^[\\w\\._]+@[\\w&&[^0-9]_]+(\\.[\\w&&[^0-9]]*){1,3}$", email);
    }

    // contact number
    public static boolean validateContactNo(String contactNo) {
        return Pattern.matches("^[\\d\\+]+$", contactNo);
    }

    // password strength
    public static boolean passwordStrength(String password) {
        return Pattern.matches("^[^\n]{8,}$", "password");
    }
}
