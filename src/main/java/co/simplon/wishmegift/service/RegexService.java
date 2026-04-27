package co.simplon.wishmegift.service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegexService {
    private static final String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[@$!%*?])[a-zA-Z\\d@$!%*?]{12,}$";
    private static final String emailRegex = "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$";

    private static final Pattern passwordPattern = Pattern.compile(passwordRegex);
    private static final Pattern emailPattern = Pattern.compile(emailRegex);

    public static boolean isValidPassword(String password) {
        if(password == null) return false;
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }

    public static boolean isValidEmail(String email) {
        if(email == null) return false;
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }


}
