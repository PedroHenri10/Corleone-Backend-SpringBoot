package com.corleone.configuracao.repository;

import com.corleone.configuracao.entity.Configuracao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfiguracaoRepository extends JpaRepository<Configuracao, Integer> {
    Optional<Configuracao> findByChave(String chave);

    boolean existsByChave(String chave);
}
