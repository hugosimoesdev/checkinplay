package app.checkinplay.exception;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(String resource) {
        super("User with email " + resource + " already exists");
    }
}
