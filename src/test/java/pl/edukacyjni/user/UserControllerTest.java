package pl.edukacyjni.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    private static final String BASE_ENDPOINT = "/api/users";
    private static final String GET_ENDPOINT_1 = "/api/users/1";
    private static final String GET_ENDPOINT_2 = "/api/users/2";
    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllUsers() throws Exception {
        // arrange
        UserDTO user1=new UserDTO();
        user1.setId(1);
        user1.setUsername("user1");

        UserDTO user2=new UserDTO();
        user2.setId(2);
        user2.setUsername("user2");

        List<UserDTO> userList = Arrays.asList(
                user1,user2
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
    public void testGetUserByIdExist() throws Exception {
        // arrange
        UserDTO user1=new UserDTO();
        user1.setId(1);
        user1.setUsername("user1");



        when(userService.getUserById(1)).thenReturn(user1);

        // act + assert
        mockMvc.perform(get(GET_ENDPOINT_1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.username").value("user1"));
    }

    @Test
    public void testGetUserByIdNonExist() throws Exception {
        // arrange


        when(userService.getUserById(2)).thenReturn(null);

        // act + assert
        mockMvc.perform(get(GET_ENDPOINT_2))
                .andExpect(status().isNotFound());

    }
}