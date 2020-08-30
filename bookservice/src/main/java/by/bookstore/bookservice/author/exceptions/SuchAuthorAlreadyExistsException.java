package by.bookstore.bookservice.author.exceptions;

public class SuchAuthorAlreadyExistsException extends RuntimeException {
    public SuchAuthorAlreadyExistsException() {
        super();
    }

    public SuchAuthorAlreadyExistsException(String message) {
        super(message);
    }

    public SuchAuthorAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public SuchAuthorAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    protected SuchAuthorAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
