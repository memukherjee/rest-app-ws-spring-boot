package com.example.restappws.service.userservice;

import com.example.restappws.ui.model.request.UpdateUserDetailsRequestModel;
import com.example.restappws.ui.model.request.UserDetailsRequestModel;
import com.example.restappws.ui.model.response.UserRest;

public interface UserService {
    UserRest getUserById(String id);
    UserRest createUser(UserDetailsRequestModel userDetails);
    UserRest updateUser(String userId, UpdateUserDetailsRequestModel userDetails);
    void deleteUser(String userId);
}
