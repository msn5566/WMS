package com.wms.service.impl;

// Required imports (from instructions)
// ... (Mockito, JUnit)

import com.wms.model.User;
import com.wms.service.JwtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class JwtServiceImplTest {

    @Spy // Use @Spy since we are testing internal logic of the class
    @InjectMocks
    private JwtServiceImpl jwtService;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(jwtService, "JWT_EXPIRATION_TIME", 3600000L);
        ReflectionTestUtils.setField(jwtService, "SECRET_KEY", "413F4428472B4B6250655368566D59703373367639792F423F4528482B4D6251");
    }


    @Test
    void generateToken() {
        User user = User.builder()
                .username("testuser")
                .password("testpassword")
                .role("admin").build();

        String token = jwtService.generateToken(user);

        assertNotNull(token);
        assertTrue(token.length() > 0);
    }
}