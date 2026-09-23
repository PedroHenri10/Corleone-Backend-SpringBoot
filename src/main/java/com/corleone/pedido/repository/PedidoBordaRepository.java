package com.corleone.pedido.repository;

import com.corleone.pedido.entity.PedidoBorda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoBordaRepository extends JpaRepository<PedidoBorda, Integer> {

    List<PedidoBorda> findByItemPedidoId(Integer itemPedidoId);
}