package pl.edukacyjni.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.edukacyjni.pair.Pair;

@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
    private Pair emails;
}
