package com.corleone.configuracao.repository;

import com.corleone.configuracao.entity.Configuracao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfiguracaoRepository extends JpaRepository<Configuracao, Long> {
}
