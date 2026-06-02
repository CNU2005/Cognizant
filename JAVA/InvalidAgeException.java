// Exercise 21 (supporting file): Custom checked exception.
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
