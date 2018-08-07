package edu.mvc.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class User {

    @NotNull(message = "cannot be empty")
    @Size(min = 5, message = "should contain at leas 5 characters")
    private String userName;
    @NotNull(message = "cannot be empty")
    private String password;
    @NotNull(message = "cannot be empty")
    private Role role;
    @NotNull(message = "cannot be empty")
    private Gender gender;

    public enum Gender {
        MALE, FEMALE
    }

    public enum Role {
        ADMIN, VIP, FREE
    }
}
