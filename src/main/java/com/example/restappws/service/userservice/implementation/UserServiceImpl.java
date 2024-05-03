package com.example.restappws.service.userservice.implementation;

import com.example.restappws.exceptions.UserServiceException;
import com.example.restappws.service.userservice.UserService;
import com.example.restappws.shared.Utils;
import com.example.restappws.ui.model.request.UpdateUserDetailsRequestModel;
import com.example.restappws.ui.model.request.UserDetailsRequestModel;
import com.example.restappws.ui.model.response.UserRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private Map<String, UserRest> users;

    private final Utils utils;

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest getUserById(String id) {
        if (users != null && users.containsKey(id)) {
            return users.get(id);
        }
        return null;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {

        UserRest newUser = new UserRest();
        String userId = utils.generateUserId();
        newUser.setUserId(userId);
        newUser.setFirstName(userDetails.getFirstName());
        newUser.setLastName(userDetails.getLastName());
        newUser.setEmail(userDetails.getEmail());

        if (users == null) users = new HashMap<>();
        boolean isUniqueUser = newUser.isUnique(users.values().stream().toList());
        if(!isUniqueUser) {
            throw new UserServiceException("Please use another email id. User is already present with this email id");
        }
        users.put(userId, newUser);
        return newUser;
    }

    @Override
    public UserRest updateUser(String userId, UpdateUserDetailsRequestModel userDetails) {
        if(users==null || !users.containsKey(userId)) {
            return null;
        }

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
