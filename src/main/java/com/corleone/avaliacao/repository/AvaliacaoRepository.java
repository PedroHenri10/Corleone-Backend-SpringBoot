package com.corleone.avaliacao.repository;

import com.corleone.avaliacao.entity.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer>, JpaSpecificationExecutor<Avaliacao> {

    boolean existsByPedidoId(Integer pedidoId);

    Optional<Avaliacao> findByPedidoId(Integer pedidoId);
    Optional<Avaliacao> findByClienteId(Integer clienteId);

}