package pl.edukacyjni.emailAddresses;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EmailAddresses {
    private String primaryEmail;
    private String secondaryEmail;

    public EmailAddresses(String primaryEmail){
        this.primaryEmail = primaryEmail;
        this.secondaryEmail = null;
    }
}
