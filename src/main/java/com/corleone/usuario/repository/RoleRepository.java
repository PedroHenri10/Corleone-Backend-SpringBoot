package com.corleone.usuario.repository;

import com.corleone.usuario.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    List<Role> findByIdIn(List<Integer> ids);
}