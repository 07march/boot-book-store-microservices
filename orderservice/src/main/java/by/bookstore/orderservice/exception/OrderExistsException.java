package by.bookstore.orderservice.exception;

public class OrderExistsException extends RuntimeException {
    public OrderExistsException() {
        super();
    }

    public OrderExistsException(String message) {
        super(message);
    }

    public OrderExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderExistsException(Throwable cause) {
        super(cause);
    }

    protected OrderExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
