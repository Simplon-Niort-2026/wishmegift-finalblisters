package co.simplon.wishmegift.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class HasherService {
    public static String hash(String password) {

        int logRounds = 12;  // Increasing this value makes it more secure, but slower

        // Generate the salt
        String salt = BCrypt.gensalt(logRounds);

        // Hash the password with the salt
        return BCrypt.hashpw(password, salt);

        /*MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(
                    password.getBytes(StandardCharsets.UTF_8));
            return new String(encodedhash, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";*/

    }


   public static boolean isGoodPassword(String mdp, String passwordHashed){
        System.out.println("mot de passe envoyé : "+mdp);
        System.out.println("passwordHashed = " + passwordHashed);
        System.out.println("password = " + hash(mdp));
        //return passwordHashed.equals(hash(mdp));
       return BCrypt.checkpw(mdp, passwordHashed);
    }



}
