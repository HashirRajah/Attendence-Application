package backEnd;

//imports
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class PasswordManipulation {
    // hash a string
    public static String hash(String passwd) {
        // algo- SHA-256
        String algo = new String("SHA-256");
        String passwordHash = "";

        try {
            MessageDigest md = MessageDigest.getInstance(algo);
            BigInteger number = new BigInteger(1, md.digest(passwd.getBytes(StandardCharsets.UTF_8)));
            // convert number to hex
            StringBuilder hexString = new StringBuilder(number.toString(16));
            //
            passwordHash = hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            System.out.printf("Hash Algorithm(\s) not found!\n", algo);
        }

        return passwordHash;
    }

    public static boolean validatePassword(String passwd, String passwdHash) {
        return hash(passwd).equals(passwdHash);
    }
}
