package com.dhanshree.storagetiering.controller;

import com.dhanshree.storagetiering.dto.RegisterRequest;
import com.dhanshree.storagetiering.model.User;
import com.dhanshree.storagetiering.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole("USER");

        return userService.registerUser(user);
    }
}