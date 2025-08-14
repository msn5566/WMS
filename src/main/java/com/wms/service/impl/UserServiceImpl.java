
package com.wms.service.impl;

import com.wms.dto.CreateUserRequest;
import com.wms.dto.LoginRequest;
import com.wms.dto.UserDto;
import com.wms.model.User;
import com.wms.repository.UserRepository;
import com.wms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

    @Override
    public UserDto login(LoginRequest loginRequest) {
        Optional<User> userOptional = userRepository.findByUsername(loginRequest.getUsername());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                return UserDto.builder()
                        .username(user.getUsername())
                        .id(user.getId())
                        .build();
            }
        }
        return null;
    }

    @Override
    public UserDto registerUser(CreateUserRequest request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .active(true)
                .role("USER") // default role
                .build();
        User savedUser = userRepository.save(user);
        return UserDto.builder()
                .username(savedUser.getUsername())
                .id(savedUser.getId())
                .build();
    }

}