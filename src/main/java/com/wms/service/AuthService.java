package com.wms.service;

import com.wms.dto.AuthRequest;
import com.wms.dto.AuthResponse;
import com.wms.dto.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse authenticate(AuthRequest request);
}