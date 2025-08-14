
package com.wms.service.impl;

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
import com.wms.model.User;
import com.wms.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AuthServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthServiceImpl authService;

    @Test
    @DisplayName("shouldRegisterUser_whenValidRequest")
    void register_validRequest() {
        RegisterRequest request = new RegisterRequest("testuser", "password", "Worker");
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(new User());

        String response = authService.register(request);

        assertEquals("User registered successfully", response);
        verify(passwordEncoder, times(1)).encode("password");
        verify(userRepository, times(1)).save(any(User.class));


    }

    @Test
    @DisplayName("shouldLoginUser_whenValidCredentials")
    void login_validCredentials() {
        LoginRequest request = new LoginRequest("testuser", "password");
        User user = new User();
        user.setPassword("encodedPassword");
        when(userRepository.findByUsername(anyString())).thenReturn(user);
        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(true);

        String response = authService.login(request);


        assertEquals("Login successful", response);
        verify(userRepository, times(1)).findByUsername("testuser");
        verify(passwordEncoder, times(1)).matches("password", "encodedPassword");
    }


    @Test
    @DisplayName("shouldNotLoginUser_whenInvalidCredentials")
    void login_invalidCredentials() {
        LoginRequest request = new LoginRequest("invaliduser", "wrongpassword");

        when(userRepository.findByUsername(anyString())).thenReturn(null);


        String response = authService.login(request);

        assertEquals("Login failed", response);
        verify(userRepository, times(1)).findByUsername("invaliduser");
        verify(passwordEncoder, times(0)).matches(anyString(), anyString());

    }


    @Test
    @DisplayName("shouldNotLoginUser_whenPasswordDoesNotMatch")
    void login_passwordDoesNotMatch() {
        LoginRequest request = new LoginRequest("testuser", "wrongpassword");
        User user = new User();
        user.setPassword("encodedPassword");


        when(userRepository.findByUsername(anyString())).thenReturn(user);
        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(false);



        String response = authService.login(request);

        assertEquals("Login failed", response);
        verify(userRepository, times(1)).findByUsername("testuser");
        verify(passwordEncoder, times(1)).matches("wrongpassword", "encodedPassword");
    }
}