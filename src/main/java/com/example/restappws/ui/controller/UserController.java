package com.example.restappws.ui.controller;

import com.example.restappws.ui.model.request.UserDetailsRequestModel;
import com.example.restappws.ui.model.response.UserRest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    Map<String, UserRest> users;

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "20") int limit, @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        return "get users called with page = " + page + ", limit = " + limit + " and sort = " + sort;
    }

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
        if (users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());

        if (users == null) users = new HashMap<>();
        users.put(userId, returnValue);

        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }

    @PutMapping
    public String updateUser() {
        return "update User";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete User";
    }
}
