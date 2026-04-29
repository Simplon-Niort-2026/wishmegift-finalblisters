package co.simplon.wishmegift.errorsHandler;


import org.jspecify.annotations.NonNull;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<@NonNull String> handleBadRequestException(HttpMessageNotReadableException ex) {
        String[] messageSplitted = ex.getMessage().split(":");
        String exceptionMessage = messageSplitted[1].trim();
        return new ResponseEntity<>( exceptionMessage, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<@NonNull String> handleInternalServerErrorException(HttpServerErrorException ex) {
        System.err.println(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<@NonNull String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {

        /* JE GARDE POUR ESSAYER DE RECUPERER LA PARTIE UTIL DU MESSAGE PLUS TARD

        String message = ex.getMessage();
        System.err.println("message");
        System.err.println(message);
        String[] messageSplitted = message.split("Détail : La clé ");
        System.err.println("premier split");
        System.err.println(messageSplitted[0]);
        System.err.println(messageSplitted[1]);
        String[] messageUtilSplitted = messageSplitted[1].split("]");
        System.err.println("partie 1 du second split");
        String messageUtil = messageUtilSplitted[0].trim();
        System.err.println(messageUtil);
        String message = ex.getMessage();
        String regex = "La clé(.*)]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(message);
        if(matcher.find()) {
            System.err.println(matcher.group(1));
        }*/
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
