package com.corleone.auth;

import com.corleone.auth.docs.AuthApi;
import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.usuario.entity.Usuario;
import com.corleone.usuario.repository.UsuarioRepository;
import com.corleone.auth.dto.*;
import com.corleone.security.AuthenticationService;
import com.corleone.security.JwtService;
import com.corleone.shared.dto.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController implements AuthApi {

    private final AuthenticationService authenticationService;
    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;

    public AuthController(AuthenticationService authenticationService, JwtService jwtService, UsuarioRepository usuarioRepository){
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@Valid @RequestBody LoginRequest request) {
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
    public ResponseEntity<ApiResponse<MeResponse>> me(@AuthenticationPrincipal UserDetails user
    ) {

        if (user == null) {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(
                            ApiResponse.<MeResponse>builder()
                                    .success(false)
                                    .message("Usuário não autenticado")
                                    .build()
                    );
        }

        Usuario usuario = usuarioRepository
                        .findByLoginAndAtivoTrue(user.getUsername())
                        .orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.USUARIO_NAO_ENCONTRADO));

        MeResponse response =
                MeResponse.builder()
                        .id(usuario.getId())
                        .login(usuario.getLogin())
                        .build();

        return ResponseEntity.ok(
                ApiResponse.<MeResponse>builder()
                        .success(true)
                        .message("Usuário autenticado")
                        .data(response)
                        .build()
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
