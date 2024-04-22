package com.example.restappws.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping(path="/{userId}")
    public String getUser(@PathVariable String userId) {
        return "get User called with id: " + userId;
    }

    @PostMapping
    public String createUser() {
        return "create User";
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
