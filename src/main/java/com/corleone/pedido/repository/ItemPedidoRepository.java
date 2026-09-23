package com.corleone.pedido.repository;

import com.corleone.pedido.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>, JpaSpecificationExecutor<ItemPedido> {

    List<ItemPedido> findByPedidoId(Integer pedidoId);
}