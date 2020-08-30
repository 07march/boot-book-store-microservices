package by.bookstore.userservice.user;

import java.util.List;

public interface UserRepository {

    User save(User user);

    User delete(User user);

    User updateUser(User user);

    List<User> findAll();

    User findById(int id);

    User findByLogin(String login);

    List<User> findAllByName(String name);

}
