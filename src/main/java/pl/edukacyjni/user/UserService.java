package pl.edukacyjni.user;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static final List<User> USERS = new ArrayList<>(){{
        add(new User(1L,"michaelPaello"));
        add(new User(2L,"theGhostCasper"));
        add(new User(3L,"stNicolas"));
        add(new User(4L,"santiago"));
        add(new User(5L,"was-far"));
    }};

    public List<User> getAllUsers() {
        return USERS;
    }
}
