package pl.edukacyjni.user;


import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    private static final List<User> USERS = new ArrayList<>(){{
        add(new User(1L, "michaelPaello", "kochamPierogi", false));
        add(new User(2L, "theGhostCasper", "huliganJezusaSt0", true));
        add(new User(3L, "stNicolas", "haslo123!", false));
        add(new User(4L, "santiago", "deadline", true));
        add(new User(5L, "was-far", "abcd", true));
    }};

    public List<User> getAllUsers() {
        return USERS;
    }

    public User getUserById(long id) {
        return USERS
                .stream()
                .filter(user -> id == user.getId())
                .findFirst().orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
    }


    public void deactivateUserById(Long id) throws ResponseStatusException {
        User user = getUserById(id);
        user.setIsActive(false);
    }
}
