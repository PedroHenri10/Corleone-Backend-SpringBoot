package com.corleone.security;

import com.corleone.auth.dto.LoginRequest;
import com.corleone.auth.dto.LoginResponse;
import com.corleone.exception.CredenciaisInvalidasException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.usuario.entity.Usuario;
import com.corleone.usuario.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthenticationService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest request) {

        Usuario usuario = usuarioRepository
                .findByLoginAndAtivoTrue(request.getUsername())
                .orElseThrow(() -> new CredenciaisInvalidasException(ErrorEnum.CREDENCIAIS_INVALIDAS));

        boolean senhaValida = passwordEncoder.matches(
                request.getPassword(),
                usuario.getSenha()
        );

        if (!senhaValida) {
            throw new CredenciaisInvalidasException(ErrorEnum.CREDENCIAIS_INVALIDAS);
        }

        String token = jwtService.generateToken(usuario.getLogin());

        return LoginResponse.builder()
                .token(token)
                .build();
    }

}