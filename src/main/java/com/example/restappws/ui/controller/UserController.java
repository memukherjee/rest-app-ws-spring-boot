package com.example.restappws.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "20") int limit, @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        return "get users called with page = " + page + ", limit = " + limit + " and sort = " + sort;
    }

    @GetMapping(path = "/{userId}")
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
