package by.bookstore.bookservice.author;

import by.bookstore.bookservice.author.exceptions.AuthorNotFoundException;
import by.bookstore.bookservice.author.exceptions.SuchAuthorAlreadyExistsException;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthorRepositoryImpl implements AuthorRepository {

    private List<Author> authors = new ArrayList<>();

    @Override
    public Author add(Author name) {
        if (authors.contains(name)){
            throw new SuchAuthorAlreadyExistsException("oops.. this author already exists!");
        }
        authors.add(name);
        return name;
    }

    @Override
    public Author deleteAuthor(Author name) {
        if (authors.contains(name)){
            authors.remove(name);
            return name;
        }
        throw new AuthorNotFoundException("oops.. this author not found!");
    }

    @Override
    public Author deleteAuthorById(int id) {
        Author old = null;
        int count = 0;
        for (Author author : authors) {
            if (author.getId() == id) {
                old = author;
                authors.remove(count);
                return old;
            }
            count++;
        }
        throw new AuthorNotFoundException("oops.. this author not found!");
    }

    @Override
    public Author updateAuthor(Author author) {
        Author old;
        for (Author author1 : authors) {
            if (author1.getId() == author.getId()) {
                old = author1;
                author1.setName(author.getName());
                return old;
            }
        }
        throw new AuthorNotFoundException("oops.. this author not found!");
    }

    @Override
    public List<Author> findAllAuthors() {
        return new ArrayList<>(authors);
    }

    @Override
    public Author findAuthorByName(String name) {
        for (Author author1 : authors) {
            if (author1.getName().equals(name)) {
                return author1;
            }
        }
        throw new AuthorNotFoundException("oops.. this author not found!");
    }

    @Override
    public Author findAuthorById(int id) {
        for (Author author1 : authors) {
            if (author1.getId() == id) {
                return author1;
            }
        }
        throw new AuthorNotFoundException("oops.. this author not found!");
    }
}
