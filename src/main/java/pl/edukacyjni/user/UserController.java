package pl.edukacyjni.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found for id: " + id));
    }

    @PutMapping("/{id}/deactivate")
    public User deactivateUserById(@PathVariable Long id) {
        Optional<User> user = userService.deactivateUserById(id);
        return user.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found for id: " + id));
    }

}
