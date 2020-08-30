package by.bookstoremicro.storeservice.store.exceptions;

public class StoreCityNotFoundException extends RuntimeException {
    public StoreCityNotFoundException() {
        super();
    }

    public StoreCityNotFoundException(String message) {
        super(message);
    }

    public StoreCityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StoreCityNotFoundException(Throwable cause) {
        super(cause);
    }

    protected StoreCityNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
