package com.corleone.usuario.repository;

import com.corleone.usuario.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository
        extends JpaRepository<Role, Integer> {
}