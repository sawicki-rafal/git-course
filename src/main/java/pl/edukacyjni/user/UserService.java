package pl.edukacyjni.user;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<User> getUserById(Long id) {
        for (User user : USERS) {
            if (id.equals(user.getId())) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public Optional<User> deactivateUserById(Long id) {
        Optional<User> userOptional = getUserById(id);
        if (userOptional.isPresent() && userOptional.get().getIsActive()) {
            User user = userOptional.get();
            user.setIsActive(false);
            return Optional.of(user);
        }
        else {
            return userOptional;
        }
    }
}
