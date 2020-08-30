package by.bookstore.bookservice.book;

import by.bookstore.bookservice.author.exceptions.SuchAuthorAlreadyExistsException;
import by.bookstore.bookservice.book.exceptions.BookNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BookExceptionController extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(value = BookNotFoundException.class)
    public ResponseEntity<String> notFound(BookNotFoundException b){
        return new ResponseEntity<>(b.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = SuchAuthorAlreadyExistsException.class)
    public ResponseEntity<String> existsExc(SuchAuthorAlreadyExistsException s){
        return new ResponseEntity<>(s.getMessage(), HttpStatus.NOT_FOUND);
    }
}
