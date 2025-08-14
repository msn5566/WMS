
package com.wms.controller;

// Mockito imports
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.ArgumentCaptor;

// JUnit 5 imports
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

// Spring Test imports (for controller tests)
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Mockito static imports
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

// Jackson imports (if testing JSON serialization)
import com.fasterxml.jackson.databind.ObjectMapper;

// Jakarta imports (if testing XML/validation)
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;


import com.wms.dto.LoginRequest;
import com.wms.dto.RegisterRequest;
import com.wms.service.AuthService;
import org.springframework.http.MediaType;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AuthControllerTest {

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthController authController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
        objectMapper = new ObjectMapper();
    }


    @Test
    @DisplayName("shouldRegisterUser_whenValidRequest")
    void register_validRequest() throws Exception {
        RegisterRequest request = new RegisterRequest("testuser", "password", "Worker");
        when(authService.register(any(RegisterRequest.class))).thenReturn("User registered successfully");

        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().string("User registered successfully"));

        verify(authService, times(1)).register(any(RegisterRequest.class));
    }


    @Test
    @DisplayName("shouldLoginUser_whenValidCredentials")
    void login_validCredentials() throws Exception {
        LoginRequest request = new LoginRequest("testuser", "password");
        when(authService.login(any(LoginRequest.class))).thenReturn("Login successful");


        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().string("Login successful"));

        verify(authService, times(1)).login(any(LoginRequest.class));

    }

    @Test
    @DisplayName("shouldNotLoginUser_whenInvalidCredentials")
    void login_invalidCredentials() throws Exception {
        LoginRequest request = new LoginRequest("invaliduser", "wrongpassword");
        when(authService.login(any(LoginRequest.class))).thenReturn("Login failed");


        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().string("Login failed"));

        verify(authService, times(1)).login(any(LoginRequest.class));
    }
}