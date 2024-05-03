package com.example.restappws.ui.model.response;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class UserRest {
    private String firstName;
    private String lastName;
    private String email;
    private String userId;

    @Override
    public boolean equals(Object comparedUserObject) {
        if (this == comparedUserObject) return true;
        if (comparedUserObject == null || getClass() != comparedUserObject.getClass()) return false;
        UserRest comparedUser = (UserRest) comparedUserObject;
        return Objects.equals(email, comparedUser.email) || Objects.equals(userId, comparedUser.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    public boolean isUnique(List<UserRest> listOfUsers){
        Set<UserRest> poolOfUsers = new HashSet<>(listOfUsers);
        return !poolOfUsers.contains(this);
    }

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
