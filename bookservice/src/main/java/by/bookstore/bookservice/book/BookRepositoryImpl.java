package by.bookstore.bookservice.book;

import by.bookstore.bookservice.author.Author;
import by.bookstore.bookservice.book.exceptions.BookNotFoundException;
import by.bookstore.bookservice.book.exceptions.SuchBookAlreadyExistsException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookRepositoryImpl implements BookRepository{

    private List<Book> books = new ArrayList<>();

    @Override
    public Book save(Book book) {
        if (books.contains(book)) {
            throw new SuchBookAlreadyExistsException("such book already exists!");
        }
        books.add(book);
        return book;
    }

    @Override
    public Book deleteBook(Book book) {
        if (books.contains(book)) {
            books.remove(book);
            return book;
        }
        throw new BookNotFoundException("this book not found!");
    }

    @Override
    public Book deleteBookById(int id) {
        Book old;
        int count = 0;
        for (Book book1 : books) {
            if (book1.getId() == id) {
                old = book1;
                books.remove(count);
                return old;
            }
            count++;
        }
        throw new BookNotFoundException("this book not found!");
    }

    @Override
    public String updateBookTitle(String title, int id) {
        String oldBook = null;
        int count = 0;
        for (Book book1 : books) {
            if (book1.getId() == id) {
                oldBook = book1.getTitle();
                book1.setTitle(title);
                return oldBook;
            }
            count++;
        }
        throw new BookNotFoundException("this book not found!");
    }

    @Override
    public String updateBookDescription(String description, int id) {
        String oldBook = null;
        int count = 0;
        for (Book book1 : books) {
            if (book1.getId() == id) {
                oldBook = book1.getDescription();
                book1.setTitle(description);
                return oldBook;
            }
            count++;
        }
        throw new BookNotFoundException("this book not found!");
    }

    @Override
    public BigDecimal updateBookPriceById(BigDecimal price, int id) {
        BigDecimal oldBook;
        int count = 0;
        for (Book book1 : books) {
            if (book1.getId() == id) {
                oldBook = book1.getPrice();
                book1.setPrice(price);
                return oldBook;
            }
            count++;
        }
        throw new BookNotFoundException("this book not found!");
    }

    @Override
    public Author updateBookByAuthor(Author author, int id) {
        Author oldAuthor;
        int count = 0;
        for (Book book : books) {
            if (book.getId() == id) {
                oldAuthor = book.getAuthor();
                book.setAuthor(author);
                return oldAuthor;
            }
            count++;
        }
        throw new BookNotFoundException("this book not found!");
    }

    @Override
    public List<Book> findAllBooks() {
        return new ArrayList<>(books);
    }

    @Override
    public List<Book> findBooksByAuthor(Author author) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                booksByAuthor.add(book);
                return booksByAuthor;
            }
        }
        throw new BookNotFoundException("this book not found!");
    }

    @Override
    public List<Book> findBooksByPrice(BigDecimal price) {
        List<Book> booksByPrice = new ArrayList<>();
        for (Book book : books) {
            if (book.getPrice().equals(price)) {
                booksByPrice.add(book);
                return booksByPrice;
            }
        }
        throw new BookNotFoundException("this book not found!");
    }

    @Override
    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        throw new BookNotFoundException("this book not found!");
    }
}
