package com.corleone.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class JwtService {

    private final String secret;
    private final Long expiration;

    public JwtService(@Value("${jwt.secret}") String secret, @Value("${jwt.expiration}") Long expiration
    ) {
        this.secret = secret;
        this.expiration = expiration;
    }

    public String generateToken(String username) {

        Algorithm algorithm = Algorithm.HMAC256(secret);

        Instant now = Instant.now();

        Instant expiresAt = now.plusMillis(expiration);

        return JWT.create().withSubject(username).withIssuedAt(now).withExpiresAt(expiresAt).sign(algorithm);
    }

    public String extractUsername(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.require(algorithm)
                .build()
                .verify(token)
                .getSubject();
    }

    public boolean isTokenValid(String token) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWT.require(algorithm)
                    .build()
                    .verify(token);
            return true;
        }catch(JWTVerificationException e) {
            return false;
        }
    }
}