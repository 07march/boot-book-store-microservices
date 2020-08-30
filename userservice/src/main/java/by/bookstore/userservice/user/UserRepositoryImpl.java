package by.bookstore.userservice.user;

import by.bookstore.userservice.user.exception.UserExistsException;
import by.bookstore.userservice.user.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserRepositoryImpl implements UserRepository{

    private List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        if (users.contains(user)){
            throw new UserExistsException("user already exists!");
        }
        users.add(user);
        return user;
    }

    @Override
    public User delete(User user){
        for (User user1 : users) {
            if (user1.equals(user)){
                users.remove(user1);
                return user;
            }
        }
        throw new UserNotFoundException("user not found!");
    }

    @Override
    public User updateUser(User user) {
        User old;
        for (User user1 : users) {
            if (user1.getId() == user.getId()){
                old = user1;
                user1.setName(user.getName());
                return old;
        }
            }
        throw new UserNotFoundException("user not found!");
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        throw new UserNotFoundException("user not found!");
    }

    @Override
    public User findByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException("user not found!");
    }

    @Override
    public List<User> findAllByName(String name) {
        List<User> byName = new ArrayList<>();
        for (User user : users) {
            if (user.getName().equals(name)) {
                byName.add(user);
                return byName;
            }
        }
        throw new UserNotFoundException("user not found!");
    }
}
