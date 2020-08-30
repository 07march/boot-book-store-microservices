package by.bookstore.bookservice.book;

import by.bookstore.bookservice.author.Author;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.List;

@Data
@RestController
@RequestMapping(path = "/book")
public class BookController {

    private final BookService bookService;

    @PostMapping(path = "/save")
    public ResponseEntity<Book> add(@RequestBody @Valid Book book) {
        return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
    }

    @PostMapping(path = "/delete/book")
    public ResponseEntity<Book> delete(@RequestBody @Valid Book book) {
        return new ResponseEntity<>(bookService.deleteBook(book), HttpStatus.OK);
    }

    @PostMapping(path = "/delete/id")
    public ResponseEntity<Book> deleteBookById(@Min(1) int id) {
        return new ResponseEntity<>(bookService.deleteBookById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/update/title")
    public ResponseEntity<String> updateBookTitle(@NotEmpty String title, @Min(1) int id) {
        return new ResponseEntity<>(bookService.updateBookTitle(title, id), HttpStatus.OK);
    }

    @PostMapping(path = "/update/description")
    public ResponseEntity<String> updateBookDescription(@NotEmpty String description, @Min(1) int id) {
        return new ResponseEntity<>(bookService.updateBookDescription(description, id), HttpStatus.OK);
    }

    @PostMapping(path = "/update/price")
    public ResponseEntity<BigDecimal> updateBookPrice(@NotEmpty BigDecimal price, @Min(1) int id) {
        return new ResponseEntity<>(bookService.updateBookPriceById(price, id), HttpStatus.OK);
    }

    @PostMapping(path = "/update/author")
    public ResponseEntity<Author> updateBookAuthor(@RequestBody @Valid Author author, @Min(1) int id) {
        return new ResponseEntity<>(bookService.updateBookByAuthor(author, id), HttpStatus.OK);
    }

    @GetMapping(path = "/find/all/books")
    public ResponseEntity<List<Book>> findAllBooks() {
        return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.OK);
    }

    @GetMapping(path = "/find/all/author")
    public ResponseEntity<List<Book>> findBooksByAuthor(@RequestBody @Valid Author author) {
        return new ResponseEntity<>(bookService.findBooksByAuthor(author), HttpStatus.OK);
    }

    @GetMapping(path = "/find/all/price")
    public ResponseEntity<List<Book>> findBooksByPrice(@Min(1) BigDecimal price) {
        return new ResponseEntity<>(bookService.findBooksByPrice(price), HttpStatus.OK);
    }

    @GetMapping(path = "/find/id")
    public ResponseEntity<Book> findById(@Min(1) int id) {
        return new ResponseEntity<>(bookService.findBookById(id), HttpStatus.OK);
    }
}
