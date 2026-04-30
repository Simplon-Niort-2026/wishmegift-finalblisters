package co.simplon.wishmegift.errorsHandler;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
