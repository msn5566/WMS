package com.wms.service.impl;


import com.wms.model.User;
import com.wms.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;



@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret.key}")
    private String SECRET_KEY;
    @Value("${jwt.expiration.time}")
    private Long JWT_EXPIRATION_TIME;



    @Override
    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, user.getUsername());
    }



    private String createToken(Map<String, Object> claims, String userName) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + (JWT_EXPIRATION_TIME != null ? JWT_EXPIRATION_TIME : 3600000))) //Provide default value if JWT_EXPIRATION_TIME is null
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }



    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }



}