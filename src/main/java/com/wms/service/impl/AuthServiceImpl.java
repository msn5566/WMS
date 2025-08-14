package com.wms.service.impl;

import com.wms.dto.LoginRequest;
import com.wms.dto.RegisterRequest;
import com.wms.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.wms.model.User;
import com.wms.repository.UserRepository;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public String register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole()); // Consider using an Enum for roles
        userRepository.save(user);
        return "User registered successfully";
    }

    @Override
    public String login(LoginRequest request) {
        // Basic login logic for demonstration (replace with proper authentication later)
        User user = userRepository.findByUsername(request.getUsername());

        if (user != null && passwordEncoder.matches(request.getPassword(), user.getPassword())) {

            return "Login successful"; // Return a JWT or session token here in a real application
        } else {
            return "Login failed"; // Indicate login failure with appropriate response
        }
    }
}