package pl.edukacyjni.pair;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Pair {
    private String primaryEmail;
    private String secondaryEmail;

    public Pair(String primaryEmail){
        this.primaryEmail = primaryEmail;
        this.secondaryEmail = null;
    }
}
