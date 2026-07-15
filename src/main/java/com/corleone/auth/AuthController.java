package com.corleone.auth;

import com.corleone.auth.docs.AuthApi;
import com.corleone.auth.dto.LoginRequest;
import com.corleone.auth.dto.LoginResponse;
import com.corleone.auth.dto.MeResponse;
import com.corleone.security.AuthenticationService;
import com.corleone.shared.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController implements AuthApi {

    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
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

    @GetMapping("/me")
    public ResponseEntity<MeResponse> me(Authentication authentication) {
        UserDetails user = (UserDetails) authentication.getPrincipal();

        return ResponseEntity.ok(MeResponse.builder().login(user.getUsername()).build()
        );
    }
}
