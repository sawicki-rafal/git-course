package pl.edukacyjni.user;

import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    public UserDTO mapToDTO(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());

        return userDTO;
    }

}
