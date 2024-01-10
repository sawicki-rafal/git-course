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

    private UserDTO convertUserToUserDTO(User user)
    {
        UserDTO userDTO=new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }

    public List<UserDTO> getAllUsers() {
        ArrayList<UserDTO> USERSDTO=new ArrayList<UserDTO>();

        for(User user:USERS)
            USERSDTO.add(convertUserToUserDTO(user));

        return USERSDTO;
    }

    public UserDTO getUserById(long id)
    {
        for(User user:USERS)
            if(user.getId()==id)
                return convertUserToUserDTO(user);

        return null;

    }
}
