package week6.assignment;

public class InvalidExpressionException extends RuntimeException {

    public InvalidExpressionException() {
    }

    public InvalidExpressionException(String message) {
        super(message);
    }
}
