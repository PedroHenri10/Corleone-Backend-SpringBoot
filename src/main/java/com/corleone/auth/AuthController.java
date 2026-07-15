package com.corleone.auth;

import com.corleone.auth.docs.AuthApi;
import com.corleone.auth.dto.*;
import com.corleone.security.AuthenticationService;
import com.corleone.security.JwtService;
import com.corleone.shared.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController implements AuthApi {

    private final AuthenticationService authenticationService;
    private final JwtService jwtService;

    public AuthController(AuthenticationService authenticationService, JwtService jwtService){
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@RequestBody LoginRequest request) {
        LoginResponse response = authenticationService.login(request);

        return ResponseEntity.ok(
                ApiResponse.<LoginResponse>builder()
                        .success(true)
                        .message("Login realizado com sucesso")
                        .data(response)
                        .build()
        );
    }

    @Override
    @GetMapping("/me")
    public ResponseEntity<MeResponse> me(Authentication authentication) {
        UserDetails user = (UserDetails) authentication.getPrincipal();

        return ResponseEntity.ok(MeResponse.builder().login(user.getUsername()).build()
        );
    }

    @Override
    @PostMapping("/refresh")
    public ResponseEntity<ApiResponse<RefreshTokenResponse>> refresh(@RequestBody RefreshTokenRequest request) {

        String username = jwtService.extractUsername(request.getToken());

        String novoToken = jwtService.generateToken(username);

        return ResponseEntity.ok(ApiResponse.<RefreshTokenResponse>builder()
                        .success(true)
                        .message("Token renovado com sucesso")
                        .data(RefreshTokenResponse
                                        .builder()
                                        .token(novoToken)
                                        .build())
                        .build()
        );
    }
}
