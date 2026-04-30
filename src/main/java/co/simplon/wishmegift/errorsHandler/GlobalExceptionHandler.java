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

        String message = ex.getMessage();
        String regex = "« (.*?) » existe déjà";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(message);
        if(matcher.find()) {
            String resultat = matcher.group(1) + " » existe déjà.";
            System.out.println(resultat);
            return new ResponseEntity<>(resultat, HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @ExceptionHandler(WishListNotFoundException.class)
    public ResponseEntity<String> handleWishListNotFound(WishListNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
