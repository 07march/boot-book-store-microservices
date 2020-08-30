package by.bookstoremicro.storeservice.store;

import by.bookstoremicro.storeservice.store.exceptions.StoreAddressNotFoundException;
import by.bookstoremicro.storeservice.store.exceptions.StoreCityNotFoundException;
import by.bookstoremicro.storeservice.store.exceptions.StoreExistsException;
import by.bookstoremicro.storeservice.store.exceptions.StoreNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class StoreExceptionController extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }


    @ExceptionHandler(value = StoreNotFoundException.class)
    public ResponseEntity<String> notFound(StoreNotFoundException b) {
        return new ResponseEntity<>(b.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = StoreExistsException.class)
    public ResponseEntity<String> existsExc(StoreExistsException s) {
        return new ResponseEntity<>(s.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = StoreAddressNotFoundException.class)
    public ResponseEntity<String> addressNotFoundExc(StoreAddressNotFoundException sa) {
        return new ResponseEntity<>(sa.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = StoreCityNotFoundException.class)
    public ResponseEntity<String> cityNotFoundExc(StoreCityNotFoundException sc) {
        return new ResponseEntity<>(sc.getMessage(), HttpStatus.NOT_FOUND);
    }
}
