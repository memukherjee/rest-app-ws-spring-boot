package com.example.restappws.ui.model.request;

import com.example.restappws.validations.ValidEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDetailsRequestModel {
    @NotNull(message = "First name can not be empty")
    @Size(min=2, message = "First name must be at least 2 characters long")
    private String firstName;

    @NotNull(message = "Last name can not be empty")
    @Size(min=2, message = "Last name must be at least 2 characters long")
    private String lastName;

    @NotNull(message = "Email can not be empty")
//    @Email(message = "Not a valid email")
//    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Not a valid email")
    @ValidEmail
    private String email;

    @NotNull(message = "Password can not be empty")
    @Size(min=8, max=16, message = "Password must be equal or greater than 8 characters and less than or equal to 16 characters")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
