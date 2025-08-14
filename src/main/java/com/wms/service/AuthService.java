package com.wms.service;

import com.wms.dto.LoginRequest;
import com.wms.dto.RegisterRequest;

public interface AuthService {
    String register(RegisterRequest request);
    String login(LoginRequest request);
}