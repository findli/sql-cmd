package auth;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * @author Cyril Kadomsky
 */
public class DigestDemo {
    public static void main(String[] args) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            md.update(new String("user1").getBytes());

//            while (someExpr) {
//                md.update(new byte[] {});
//            }

            byte[] hashedPassword = md.digest();
            String hashString = DatatypeConverter.printHexBinary(hashedPassword);
            System.out.println(hashString);

            md.reset();


            // salting
            // md5(password + salt)  // Joomla
            // md5 (md5(password) + salt)

            Random random = new SecureRandom();
            byte[] salt = new byte[64];
            random.nextBytes(salt);

            md.update(hashedPassword);
            md.update(salt);

            byte[] saltedPassword = md.digest();
            String saltedString = DatatypeConverter.printHexBinary(saltedPassword);
            System.out.println(saltedString);

            // store in DB : login VARCHAR, pass TINYBLOB, salt TINYBLOB


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
