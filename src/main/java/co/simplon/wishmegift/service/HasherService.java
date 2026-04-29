package co.simplon.wishmegift.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class HasherService {
    public static String hash(String password) {

        // Increasing this value makes it more secure, but slower
        int logRounds = 12;

        // Generate the salt
        String salt = BCrypt.gensalt(logRounds);

        // Hash the password with the salt
        return BCrypt.hashpw(password, salt);

    }


   public static boolean isGoodPassword(String mdp, String passwordHashed){
       return BCrypt.checkpw(mdp, passwordHashed);
    }



}
