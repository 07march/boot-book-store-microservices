package by.bookstore.userservice.user;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Data
@RequestMapping(path = "/user")
@Validated
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> save(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PostMapping(path = "/delete")
    public ResponseEntity<User> delete(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.delete(user), HttpStatus.OK);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<User> update(@Valid @RequestBody User user){
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
    }

    @GetMapping(path = "/find/all")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/find/id")
    public ResponseEntity<User> findById(@Min(value = 1) @RequestParam int id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/find/login")
    public ResponseEntity<User> findByLogin(@RequestParam String login) {
        return new ResponseEntity<>(userService.findByLogin(login), HttpStatus.OK);
    }

    @GetMapping(path = "/find/name")
    public ResponseEntity<List<User>> findAllByName(@RequestParam String name) {
        return new ResponseEntity<>(userService.findAllByName(name), HttpStatus.OK);
    }

    @GetMapping(path = "/checkUser")
    public ResponseEntity<String> checkUser(@RequestParam String login, @RequestParam String pass){
        User byLogin = userService.findByLogin(login);
        if (byLogin.getPassword().equals(pass)) {
            return new ResponseEntity<>("true", HttpStatus.OK);
        }
        return new ResponseEntity<>("false", HttpStatus.NOT_FOUND);
    }
}
