package com.corleone.usuario.repository;

import com.corleone.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository
        extends JpaRepository<Usuario, Integer> {

    Optional<Usuario>
    findByLoginAndAtivoTrue(
            String login
    );
}