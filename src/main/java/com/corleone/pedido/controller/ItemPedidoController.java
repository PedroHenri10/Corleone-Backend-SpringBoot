package com.corleone.pedido.controller;

import com.corleone.pedido.docs.ItemPedidoApi;
import com.corleone.pedido.dto.ItemPedidoFilter;
import com.corleone.pedido.dto.ItemPedidoRequest;
import com.corleone.pedido.dto.ItemPedidoResponse;
import com.corleone.pedido.dto.ItemPedidoResumoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class ItemPedidoController implements ItemPedidoApi {
    @Override
    public ResponseEntity<ItemPedidoResponse> criar(Integer pedidoId, ItemPedidoRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Page<ItemPedidoResumoResponse>> listar(ItemPedidoFilter filtro, Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<List<ItemPedidoResponse>> listarPorPedido(Integer pedidoId) {
        return null;
    }

    @Override
    public ResponseEntity<ItemPedidoResponse> atualizar(Integer id, ItemPedidoRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Void> remover(Integer id) {
        return null;
    }
}
