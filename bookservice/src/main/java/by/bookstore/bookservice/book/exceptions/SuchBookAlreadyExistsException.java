package by.bookstore.bookservice.book.exceptions;

public class SuchBookAlreadyExistsException extends RuntimeException {
    public SuchBookAlreadyExistsException() {
        super();
    }

    public SuchBookAlreadyExistsException(String message) {
        super(message);
    }

    public SuchBookAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public SuchBookAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public SuchBookAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
