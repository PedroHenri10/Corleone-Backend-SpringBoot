package com.corleone.security;

import com.corleone.auth.dto.LoginRequest;
import com.corleone.auth.dto.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public LoginResponse login(LoginRequest request) {

        if (!"admin".equals(request.getUsername()) || !"123456".equals(request.getPassword())
        ) {
            throw new RuntimeException("Credenciais inválidas");
        }

        return LoginResponse.builder()
                .token("LOGIN_FAKE_SPRINT_0")
                .build();
    }
}