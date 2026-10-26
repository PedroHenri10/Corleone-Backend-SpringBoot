package com.corleone.pedido.controller;

import com.corleone.pedido.docs.HistoricoPedidoApi;
import com.corleone.pedido.dto.HistoricoPedidoFilter;
import com.corleone.pedido.dto.HistoricoPedidoResponse;
import com.corleone.pedido.service.HistoricoPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/historicos-pedido")
@RequiredArgsConstructor
public class HistoricoPedidoController implements HistoricoPedidoApi {

    private final HistoricoPedidoService historicoPedidoService;

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('PEDIDO_VISUALIZAR')")
    public ResponseEntity<HistoricoPedidoResponse> buscarPorId(@PathVariable Integer id) {

        return ResponseEntity.ok(
                historicoPedidoService.buscarPorId(id)
        );
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('PEDIDO_VISUALIZAR')")
    public ResponseEntity<Page<HistoricoPedidoResponse>> listar(HistoricoPedidoFilter filtro, Pageable pageable) {

        return ResponseEntity.ok(historicoPedidoService.listar(filtro, pageable));
    }

    @Override
    @GetMapping("/pedido/{pedidoId}")
    @PreAuthorize("hasAuthority('PEDIDO_VISUALIZAR')")
    public ResponseEntity<List<HistoricoPedidoResponse>> listarPorPedido(@PathVariable Integer pedidoId) {

        return ResponseEntity.ok(historicoPedidoService.listarPorPedido(pedidoId));
    }
}