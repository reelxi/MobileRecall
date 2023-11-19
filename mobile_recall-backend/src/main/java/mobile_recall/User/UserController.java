package mobile_recall.User;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserByID(@PathVariable UUID userId) {
        Optional<User> user = userService.getUserByID(userId);
        if (user.isPresent()) {
            return user.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such Element of " + getClass() + " with ID: " + userId);
    }

    @PostMapping
    public User saveCard(@Valid @RequestBody User user) {
        return userService.saveUser(user);
    }
}
