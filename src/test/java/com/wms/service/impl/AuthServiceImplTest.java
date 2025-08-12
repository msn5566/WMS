package com.wms.service.impl;

// Required imports (as specified in instructions)
// ... (Mockito, JUnit, etc.)

import com.wms.dto.AuthRequest;
import com.wms.dto.AuthResponse;
import com.wms.dto.RegisterRequest;
import com.wms.model.User;
import com.wms.repository.UserRepository;
import com.wms.service.JwtService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AuthServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtService jwtService;

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private AuthServiceImpl authService;

    @Test
    void shouldRegisterUser_whenValidRequest() {
        RegisterRequest request = RegisterRequest.builder()
                .username("testuser")
                .password("password")
                .role("WORKER")
                .build();

        User user = User.builder()
                .username("testuser")
                .password("encodedPassword")
                .role("WORKER")
                .build();
        when(passwordEncoder.encode("password")).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(jwtService.generateToken(any(User.class))).thenReturn("testtoken");


        AuthResponse response = authService.register(request);

        assertEquals("testtoken", response.getToken());
        verify(userRepository).save(any(User.class));
        verify(jwtService).generateToken(any(User.class));

    }

    @Test
    void shouldAuthenticateUser_whenValidRequest() {
        AuthRequest request = AuthRequest.builder()
                .username("testuser")
                .password("password")
                .build();
        User user = User.builder()
                .username("testuser")
                .password("encodedPassword")
                .role("WORKER")
                .build();
        Authentication authentication = new UsernamePasswordAuthenticationToken("testuser", "password");

        when(authenticationManager.authenticate(any())).thenReturn(authentication);
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));
        when(jwtService.generateToken(any(User.class))).thenReturn("testtoken");



        AuthResponse response = authService.authenticate(request);


        assertEquals("testtoken", response.getToken());
        verify(authenticationManager).authenticate(any());
        verify(userRepository).findByUsername("testuser");
        verify(jwtService).generateToken(any(User.class));

    }

}