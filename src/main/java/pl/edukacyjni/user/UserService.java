package pl.edukacyjni.user;

import org.springframework.stereotype.Service;
import pl.edukacyjni.pair.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {

    private static final List<User> USERS = new ArrayList<>() {{
        add(new User(1L, "michaelPaello", "kochamPierogi", new Pair("micheal@gmail.com")));
        add(new User(2L, "theGhostCasper", "huliganJezusaSt0", new Pair("theGhost@onet.pl", "Casper123@gmail.com")));
        add(new User(3L, "stNicolas", "haslo123!", new Pair("nichaloas.st@gmail.com")));
        add(new User(4L, "santiago", "deadline", new Pair("santiago@service.uk")));
        add(new User(5L, "was-far", "abcd", new Pair("dcba@gmai.com", "dog.washere@unit.co")));
    }};

    public List<User> getAllUsers() {
        return USERS;
    }

    /**
     * Boolean method that checks the validity of user-input email addresses.
     *
     * @param emails  Pair of user emails
     * @return true - emails valid, false - emails invalid
     */
    public boolean checkEmailValidity(Pair emails) {
        for (String email : new String[]{emails.getPrimaryEmail(), emails.getSecondaryEmail()}) {
            if (email != null) {
                Matcher m = Pattern.compile("^(?!\\.)[a-zA-Z0-9.]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$")
                        .matcher(email);
                String s = null;
                while (m.find()) {
                    s = m.group(0);
                    if (!s.equals(email))
                        return false;
                }
                if (s == null)
                    return false;
            }
        }
        return true;
    }
}
