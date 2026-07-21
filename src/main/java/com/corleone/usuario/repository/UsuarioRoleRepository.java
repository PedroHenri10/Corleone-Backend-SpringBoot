package com.corleone.usuario.repository;

import com.corleone.usuario.entity.Usuario;
import com.corleone.usuario.entity.UsuarioRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRoleRepository extends JpaRepository<UsuarioRole, Integer> {

    List<UsuarioRole> findByUsuario(Usuario usuario);

    void deleteByUsuario(Usuario usuario);
}