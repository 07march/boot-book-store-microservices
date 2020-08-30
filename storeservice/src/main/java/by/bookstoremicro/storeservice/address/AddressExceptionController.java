package by.bookstoremicro.storeservice.address;

import by.bookstoremicro.storeservice.address.exceptions.AddressExistsException;
import by.bookstoremicro.storeservice.address.exceptions.AddressNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AddressExceptionController extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(value = AddressNotFoundException.class)
    public ResponseEntity<String> notFound(AddressNotFoundException b){
        return new ResponseEntity<>(b.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = AddressExistsException.class)
    public ResponseEntity<String> existsExc(AddressExistsException s){
        return new ResponseEntity<>(s.getMessage(), HttpStatus.NOT_FOUND);
    }
}
