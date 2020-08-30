package by.bookstore.bookservice.author;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Author add(Author name) {
        return authorRepository.add(name);
    }

    @Override
    public Author deleteAuthor(Author name) {
        return authorRepository.deleteAuthor(name);
    }

    @Override
    public Author deleteAuthorById(int id) {
        return authorRepository.deleteAuthorById(id);
    }

    @Override
    public Author updateAuthor(Author author) {
        return authorRepository.updateAuthor(author);
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.findAllAuthors();
    }

    @Override
    public Author findAuthorByName(String name) {
        return authorRepository.findAuthorByName(name);
    }

    @Override
    public Author findAuthorById(int id) {
        return authorRepository.findAuthorById(id);
    }
}
