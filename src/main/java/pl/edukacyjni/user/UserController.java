package pl.edukacyjni.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
     public UserDTO getUserById(@PathVariable Long id) {
        UserDTO result = userService.getUserById(id);
        if(result != null)
            return  result;
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Resource not found for this id: "+id);

    }

}
