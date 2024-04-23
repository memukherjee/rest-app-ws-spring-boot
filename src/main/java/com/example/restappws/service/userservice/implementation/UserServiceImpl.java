package com.example.restappws.service.userservice.implementation;

import com.example.restappws.service.userservice.UserService;
import com.example.restappws.ui.model.request.UpdateUserDetailsRequestModel;
import com.example.restappws.ui.model.request.UserDetailsRequestModel;
import com.example.restappws.ui.model.response.UserRest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    Map<String, UserRest> users;

    @Override
    public UserRest getUserById(String id) {
        if (users != null && users.containsKey(id)) {
            return users.get(id);
        }
        return null;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());

        if (users == null) users = new HashMap<>();
        users.put(userId, returnValue);
        return returnValue;
    }

    @Override
    public UserRest updateUser(String userId, UpdateUserDetailsRequestModel userDetails) {
        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());
        users.put(userId, storedUserDetails);
        return storedUserDetails;
    }

    @Override
    public void deleteUser(String userId) {
        users.remove(userId);
    }
}
