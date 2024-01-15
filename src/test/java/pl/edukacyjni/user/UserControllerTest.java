package pl.edukacyjni.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    private static final String BASE_ENDPOINT = "/api/users";

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllUsers() throws Exception {
        // arrange
        List<User> userList = Arrays.asList(
                new User(1L, "user1", "example"),
                new User(2L, "user2", "use2om")
        );
        when(userService.getAllUsers()).thenReturn(userList);

        // act + assert
        mockMvc.perform(get(BASE_ENDPOINT))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].username").value("user1"))
                .andExpect(jsonPath("$[1].username").value("user2"));
    }

    @Test
    public void testGetUserById() throws Exception {
        long userId = 1L;
        User user = new User(userId, "testUser", "example");

        when(userService.getUserById(userId)).thenReturn(user);

        mockMvc.perform(get(BASE_ENDPOINT + "/" + userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(userId))
                .andExpect(jsonPath("$.username").value("testUser"));
    }

    @Test
    public void testGetUserById_UserNotFound() throws Exception {
        long nonExistingUserId = 100L;
        when(userService.getUserById(nonExistingUserId)).thenThrow(new NoSuchElementException("User not found with id: " + nonExistingUserId));

        mockMvc.perform(get(BASE_ENDPOINT + "/" + nonExistingUserId))
                .andExpect(status().isNotFound());
    }
}