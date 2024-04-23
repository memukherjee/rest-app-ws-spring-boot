package com.example.restappws.ui.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
    @NotNull(message = "First name can not be empty")
    @Size(min=2, message = "First name must be at least 2 characters long")
    private String firstName;

    @NotNull(message = "Last name can not be empty")
    @Size(min=2, message = "Last name must be at least 2 characters long")
    private String lastName;

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
}
