package by.bookstoremicro.storeservice.store.exceptions;

public class StoreAddressNotFoundException extends RuntimeException {
    public StoreAddressNotFoundException() {
        super();
    }

    public StoreAddressNotFoundException(String message) {
        super(message);
    }

    public StoreAddressNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StoreAddressNotFoundException(Throwable cause) {
        super(cause);
    }

    protected StoreAddressNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
