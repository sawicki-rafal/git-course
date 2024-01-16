package pl.edukacyjni.user;

import org.springframework.stereotype.Service;
import pl.edukacyjni.emailAddresses.EmailAddresses;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static final List<User> USERS = new ArrayList<>() {{
        add(new User(1L, "michaelPaello", "kochamPierogi", new EmailAddresses("micheal@gmail.com")));
        add(new User(2L, "theGhostCasper", "huliganJezusaSt0", new EmailAddresses("theGhost@onet.pl", "Casper123@gmail.com")));
        add(new User(3L, "stNicolas", "haslo123!", new EmailAddresses("nichaloas.st@gmail.com")));
        add(new User(4L, "santiago", "deadline", new EmailAddresses("santiago@service.uk")));
        add(new User(5L, "was-far", "abcd", new EmailAddresses("dcba@gmai.com", "dog.washere@unit.co")));
    }};

    public List<User> getAllUsers() {
        return USERS;
    }

}
