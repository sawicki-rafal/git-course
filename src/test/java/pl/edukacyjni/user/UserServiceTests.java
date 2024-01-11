package pl.edukacyjni.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.edukacyjni.pair.Pair;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {
    @InjectMocks
    private UserService userService;

    @Test
    public void checkEmailValidity_ShouldReturnTrue_WhenValidEmailAddressGiven() {
        assertTrue(userService.checkEmailValidity(new Pair(
                "valid.email@gmail.com"
                , "123456@student.pwr.edu.pl")));
    }
    @Test
    public void checkEmailValidity_ShouldReturnFalse_WhenInvalidEmailAddressGiven() {
        assertAll(
                () -> assertFalse(userService.checkEmailValidity(new Pair(
                        ".email@gmail.com"
                        , "@o2.pl"))),
                () -> assertFalse(userService.checkEmailValidity(new Pair(
                        "A.V@.com"
                        , "val@o2"))),
                () -> assertFalse(userService.checkEmailValidity(new Pair(
                        ""
                        , "a.a@o.2"))),
                () -> assertFalse(userService.checkEmailValidity(new Pair(
                        ".email@"
                        , "e@o2.pl$")))
        );
    }

}
