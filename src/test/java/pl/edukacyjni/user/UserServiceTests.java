package pl.edukacyjni.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.edukacyjni.emailAddresses.EmailAddresses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {
    @InjectMocks
    private UserService userService;

    /**
     * Boolean method that checks the validity of user-input email addresses.
     *
     * @param emails  Pair of user emails
     * @return true - emails valid, false - emails invalid
     */
    public boolean checkEmailValidity(EmailAddresses emails) {
        for (String email : new String[]{emails.getPrimaryEmail(), emails.getSecondaryEmail()}) {
            if (email != null) {
                Matcher m = Pattern.compile("^(?!\\.)[a-zA-Z0-9.]+@[a-zA-Z0-9.]+\\.[a-zA-Z]{2,}$")
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
    @Test
    public void checkEmailValidity_ShouldReturnTrue_WhenValidEmailAddressGiven() {
        assertTrue(checkEmailValidity(new EmailAddresses(
                "valid.email@gmail.com"
                , "123456@student.pwr.edu.pl")));
    }
    @Test
    public void checkEmailValidity_ShouldReturnFalse_WhenInvalidEmailAddressGiven() {
        assertAll(
                () -> assertFalse(checkEmailValidity(new EmailAddresses(
                        ".email@gmail.com"
                        , "@o2.pl"))),
                () -> assertFalse(checkEmailValidity(new EmailAddresses(
                        "A.V@.com"
                        , "val@o2"))),
                () -> assertFalse(checkEmailValidity(new EmailAddresses(
                        ""
                        , "a.a@o.2"))),
                () -> assertFalse(checkEmailValidity(new EmailAddresses(
                        ".email@"
                        , "e@o2.pl$")))
        );
    }

}
