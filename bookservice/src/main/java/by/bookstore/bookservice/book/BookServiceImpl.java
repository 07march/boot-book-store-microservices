package by.bookstore.bookservice.book;

import by.bookstore.bookservice.author.Author;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Data
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book deleteBook(Book book) {
        return bookRepository.deleteBook(book);
    }

    @Override
    public Book deleteBookById(int id) {
        return bookRepository.deleteBookById(id);
    }

    @Override
    public String updateBookTitle(String title, int id) {
        return bookRepository.updateBookTitle(title, id);
    }

    @Override
    public String updateBookDescription(String description, int id) {
        return bookRepository.updateBookDescription(description, id);
    }

    @Override
    public BigDecimal updateBookPriceById(BigDecimal price, int id) {
        return bookRepository.updateBookPriceById(price, id);
    }

    @Override
    public Author updateBookByAuthor(Author author, int id) {
        return bookRepository.updateBookByAuthor(author, id);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAllBooks();
    }

    @Override
    public List<Book> findBooksByAuthor(Author author) {
        return bookRepository.findBooksByAuthor(author);
    }

    @Override
    public List<Book> findBooksByPrice(BigDecimal price) {
        return bookRepository.findBooksByPrice(price);
    }

    @Override
    public Book findBookById(int id) {
        return bookRepository.findBookById(id);
    }
}
