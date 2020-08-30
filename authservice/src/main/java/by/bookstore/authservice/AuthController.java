package by.bookstore.authservice;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(path = "/auth")
@AllArgsConstructor
public class AuthController {

    private List<UUID> uuidList;
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<UUID> auth(String login, String pass) {
        Map<String, String> param = new HashMap<>();
        param.put("login", login);
        param.put("pass", pass);
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8094/user/checkUser?login={login}&pass={pass}", String.class, param);
        if (forEntity.getBody().equals("true")) {
            UUID uuid = UUID.randomUUID();
            uuidList.add(uuid);
            return new ResponseEntity<>(uuid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/check")
    public ResponseEntity<String> check(String token) {
        UUID uuid = UUID.fromString(token);
        if (uuidList.contains(uuid)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
