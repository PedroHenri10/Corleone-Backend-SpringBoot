package com.corleone.pedido.controller;

import com.corleone.pedido.docs.ItemPedidoApi;
import com.corleone.pedido.dto.ItemPedidoFilter;
import com.corleone.pedido.dto.ItemPedidoRequest;
import com.corleone.pedido.dto.ItemPedidoResponse;
import com.corleone.pedido.dto.ItemPedidoResumoResponse;
import com.corleone.pedido.service.ItemPedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class ItemPedidoController implements ItemPedidoApi {

    private final ItemPedidoService itemPedidoService;

    @Override
    @PostMapping("/{pedidoId}/itens")
    @PreAuthorize("hasAuthority('PEDIDO_EDITAR')")
    public ResponseEntity<ItemPedidoResponse> criar(@PathVariable Integer pedidoId, @Valid @RequestBody ItemPedidoRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(itemPedidoService.criar(pedidoId, request));
    }

    @Override
    @GetMapping("/itens")
    @PreAuthorize("hasAuthority('PEDIDO_VISUALIZAR')")
    public ResponseEntity<Page<ItemPedidoResumoResponse>> listar(ItemPedidoFilter filtro, Pageable pageable) {

        return ResponseEntity.ok(itemPedidoService.listar(filtro, pageable));
    }

    @Override
    public ResponseEntity<List<ItemPedidoResponse>> listarPorPedido(Integer pedidoId) {
        return null;
    }

    @Override
    @PutMapping("/itens/{id}")
    @PreAuthorize("hasAuthority('PEDIDO_EDITAR')")
    public ResponseEntity<ItemPedidoResponse> atualizar(@PathVariable Integer id, @Valid @RequestBody ItemPedidoRequest request) {

        return ResponseEntity.ok(itemPedidoService.atualizar(id, request));
    }

    @Override
    public ResponseEntity<Void> remover(Integer id) {
        return null;
    }
}
