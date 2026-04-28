package co.simplon.wishmegift.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class HasherService {
    public static String hash(String password) {

        int logRounds = 12;  // Increasing this value makes it more secure, but slower

        // Generate the salt
        String salt = BCrypt.gensalt(logRounds);

        // Hash the password with the salt
        return BCrypt.hashpw(password, salt);

    }


   public static boolean isGoodPassword(String mdp, String passwordHashed){
        System.out.println("mot de passe envoyé : " + mdp);
        System.out.println("passwordHashed = " + passwordHashed);
        System.out.println("password = " + hash(mdp));

       return BCrypt.checkpw(mdp, passwordHashed);
    }



}
