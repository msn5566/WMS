package com.wms.service;

import com.wms.model.User;

public interface JwtService {
  String generateToken(User user);
}