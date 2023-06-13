package lt.codeacademy.restapiexample.exceptions;

public class InvalidPersonalCodeException extends RuntimeException {
    public InvalidPersonalCodeException(String details) {
        super(String.format("Invalid personal code: %s", details));
    }
}
