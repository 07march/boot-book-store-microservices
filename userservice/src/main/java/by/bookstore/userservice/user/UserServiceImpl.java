package by.bookstore.userservice.user;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
    @Override
    public User delete(User user) {
        return userRepository.delete(user);
    }
    @Override
    public User update(User user) { return userRepository.updateUser(user);}
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }
    @Override
    public List<User> findAllByName(String name) {
        return userRepository.findAllByName(name);
    }
}
