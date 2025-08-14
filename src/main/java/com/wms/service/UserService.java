
package com.wms.service;

import com.wms.dto.CreateUserRequest;
import com.wms.dto.LoginRequest;
import com.wms.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto registerUser(CreateUserRequest request);
    UserDto login(LoginRequest loginRequest);
}