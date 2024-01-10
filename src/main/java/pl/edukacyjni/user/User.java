package pl.edukacyjni.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class User {
    private Long id;
    private String username;
    private String password;


}
