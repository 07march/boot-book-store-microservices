package by.bookstoremicro.storeservice.store.exceptions;

public class StoreExistsException extends RuntimeException {
    public StoreExistsException() {
        super();
    }

    public StoreExistsException(String message) {
        super(message);
    }

    public StoreExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public StoreExistsException(Throwable cause) {
        super(cause);
    }

    protected StoreExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
