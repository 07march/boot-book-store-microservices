package by.bookstore.userservice.user;

import java.util.List;

public interface UserService {

    User save(User user);

    User delete(User user);

    User update(User user);

    List<User> findAll();

    User findById(int id);

    User findByLogin(String login);

    List<User> findAllByName(String name);

}
