package com.example.restappws.shared;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Utils {
    public String generateUserId() {
        return UUID.randomUUID().toString();
    }
}
