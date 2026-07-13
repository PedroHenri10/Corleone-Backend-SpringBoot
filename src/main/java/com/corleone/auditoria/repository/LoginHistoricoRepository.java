package com.corleone.auditoria.repository;

import com.corleone.auditoria.entity.LoginHistorico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginHistoricoRepository extends JpaRepository<LoginHistorico, Integer> {
}
