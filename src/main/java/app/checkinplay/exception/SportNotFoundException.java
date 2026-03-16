package app.checkinplay.exception;

public class SportNotFoundException extends RuntimeException {
    public SportNotFoundException(Long id) {
        super("Sport with id " + id + " not found.");
    }
}
