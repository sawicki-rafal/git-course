package pl.edukacyjni.user;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static final List<User> USERS = new ArrayList<>(){{
        add(new User(1L, "michaelPaello", "kochamPierogi"));
        add(new User(2L, "theGhostCasper", "huliganJezusaSt0"));
        add(new User(3L, "stNicolas", "haslo123!"));
        add(new User(4L, "santiago", "deadline"));
        add(new User(5L, "was-far", "abcd"));
    }};

    public List<User> getAllUsers() {
        return USERS;
    }

    public User getUserById(long id) {
        return USERS
                .stream()
                .filter(user -> id == user.getId())
                .findFirst().orElse(null);
    }
}
