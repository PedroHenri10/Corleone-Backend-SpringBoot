package com.corleone.pedido.repository;

import com.corleone.pedido.entity.HistoricoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface HistoricoPedidoRepository extends JpaRepository<HistoricoPedido, Integer>, JpaSpecificationExecutor<HistoricoPedido> {

    List<HistoricoPedido> findByPedidoId(Integer pedidoId);
}