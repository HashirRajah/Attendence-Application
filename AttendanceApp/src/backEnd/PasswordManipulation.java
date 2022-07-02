package backEnd;

//imports
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.random.*;

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

    public static String generatePassword() {
        String password = "";
        //
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = upper.toLowerCase();
        String digits = "0123456789";
        String specials = "`¬!+=[]{}#~$%^&*()-_";
        String data = upper + lower + digits + specials;
        //
        int min = 8, max = 15, len, index, dataLen = data.length();
        Random rand = new Random();
        //
        len = rand.nextInt(min, max + 1);
        //
        for (int i = 0; i < len; i++) {
            index = rand.nextInt(dataLen);
            password += Character.toString(data.charAt(index));
        }

        return password;
    }
}
