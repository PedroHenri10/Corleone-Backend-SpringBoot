package com.corleone.entrega.repository;

import com.corleone.entrega.entity.Entrega;
import com.corleone.shared.enums.StatusEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface EntregaRepository extends JpaRepository<Entrega, Integer>, JpaSpecificationExecutor<Entrega> {

    Optional<Entrega> findByPedidoId(Integer pedidoId);

    List<Entrega> findAllByStatus(StatusEntrega status);

}