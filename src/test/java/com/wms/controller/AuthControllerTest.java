
package com.wms.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wms.dto.AuthRequest;
import com.wms.dto.AuthResponse;
import com.wms.dto.RegisterRequest;
import com.wms.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AuthControllerTest {

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthController authController;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
    }

    @Test
    void shouldRegisterUser_whenValidRequest() throws Exception {
        RegisterRequest request = RegisterRequest.builder()
                .username("testuser")
                .password("password")
                .role("WORKER")
                .build();
        AuthResponse response = AuthResponse.builder()
                .token("testtoken")
                .build();
        when(authService.register(any(RegisterRequest.class))).thenReturn(response);

        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldAuthenticateUser_whenValidRequest() throws Exception {
        AuthRequest request = AuthRequest.builder()
                .username("testuser")
                .password("password")
                .build();
        AuthResponse response = AuthResponse.builder()
                .token("testtoken")
                .build();
        when(authService.authenticate(any(AuthRequest.class))).thenReturn(response);


        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }
}