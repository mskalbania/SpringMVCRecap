package edu.mvc.model;

import edu.mvc.validator.ValidUser;
import lombok.Data;

@Data
@ValidUser
public class User {

    private String userName;
    private String password;
    private Role role;
    private Gender gender;

    public enum Gender {
        MALE, FEMALE
    }

    public enum Role {
        ADMIN, VIP, FREE
    }
}
