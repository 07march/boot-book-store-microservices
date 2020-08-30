package by.bookstoremicro.storeservice.address.exceptions;

public class AddressExistsException extends RuntimeException {
    public AddressExistsException() {
        super();
    }

    public AddressExistsException(String message) {
        super(message);
    }

    public AddressExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressExistsException(Throwable cause) {
        super(cause);
    }

    protected AddressExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
