package by.bookstore.orderservice;

import by.bookstore.orderservice.exception.NotFoundException;
import by.bookstore.orderservice.exception.OrderExistsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<String> notFound(NotFoundException n){
        return new ResponseEntity<>(n.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = OrderExistsException.class)
    public ResponseEntity<String> existsExc(OrderExistsException o){
        return new ResponseEntity<>(o.getMessage(), HttpStatus.NOT_FOUND);
    }
}
