package by.bookstore.bookservice.author;

import java.util.List;

public interface AuthorRepository {

    Author add(Author name);
    Author deleteAuthor(Author name);
    Author deleteAuthorById(int id);
    Author updateAuthor(Author author);
    List<Author> findAllAuthors();
    Author findAuthorByName(String name);
    Author findAuthorById(int id);

}
