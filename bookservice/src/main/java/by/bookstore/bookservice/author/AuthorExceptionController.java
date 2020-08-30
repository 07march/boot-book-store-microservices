package by.bookstore.bookservice.author;

import by.bookstore.bookservice.author.exceptions.AuthorNotFoundException;
import by.bookstore.bookservice.author.exceptions.SuchAuthorAlreadyExistsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AuthorExceptionController extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(value = AuthorNotFoundException.class)
    public ResponseEntity<String> notFound(AuthorNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = SuchAuthorAlreadyExistsException.class)
    public ResponseEntity<String> existsException(SuchAuthorAlreadyExistsException s){
        return new ResponseEntity<>(s.getMessage(), HttpStatus.NOT_FOUND);
    }
}
