package com.dhanshree.storagetiering.service;

import com.dhanshree.storagetiering.model.User;
import com.dhanshree.storagetiering.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) {

        // Check if email already exists
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // Encrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Default role
        if (user.getRole() == null || user.getRole().isBlank()) {
            user.setRole("USER");
        }

        // Save user
        return userRepository.save(user);
    }
}