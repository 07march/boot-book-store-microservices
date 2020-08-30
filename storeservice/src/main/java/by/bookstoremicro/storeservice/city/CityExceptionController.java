package by.bookstoremicro.storeservice.city;

import by.bookstoremicro.storeservice.city.exceptions.CityNotFoundException;
import by.bookstoremicro.storeservice.city.exceptions.ExistsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CityExceptionController extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(value = CityNotFoundException.class)
    public ResponseEntity<String> notFound(CityNotFoundException b) {
        return new ResponseEntity<>(b.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ExistsException.class)
    public ResponseEntity<String> existsExc(ExistsException s) {
        return new ResponseEntity<>(s.getMessage(), HttpStatus.NOT_FOUND);
    }
}
