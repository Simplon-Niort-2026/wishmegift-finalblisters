package co.simplon.wishmegift.errorsHandler;

public class WishListNotFoundException extends RuntimeException {
    public WishListNotFoundException(String message) {
        super(message);
    }
}
