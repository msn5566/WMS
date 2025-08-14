package com.wms.service;

import com.wms.dto.CreateUserRequest;
import com.wms.dto.LoginRequest;
import com.wms.dto.UserDto;

public interface UserService {
    UserDto registerUser(CreateUserRequest request);
    void login(LoginRequest loginRequest);
}