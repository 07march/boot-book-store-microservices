package by.bookstore.bookservice.book;

import by.bookstore.bookservice.author.Author;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {

    Book save(Book book);
    Book deleteBook(Book book);
    Book deleteBookById(int id);
    String updateBookTitle(String title, int id);
    String updateBookDescription(String description, int id);
    BigDecimal updateBookPriceById(BigDecimal price, int id);
    Author updateBookByAuthor(Author author, int id);
    List<Book> findAllBooks();
    List<Book> findBooksByAuthor(Author author);
    List<Book> findBooksByPrice(BigDecimal price);
    Book findBookById(int id);

}
