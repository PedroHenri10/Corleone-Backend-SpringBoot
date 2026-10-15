package com.corleone.pedido.controller;

import com.corleone.pedido.docs.PedidoApi;
import com.corleone.pedido.dto.PedidoFilter;
import com.corleone.pedido.dto.PedidoRequest;
import com.corleone.pedido.dto.PedidoResponse;
import com.corleone.pedido.dto.PedidoResumoResponse;
import com.corleone.pedido.service.PedidoService;
import com.corleone.shared.enums.StatusPedido;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController implements PedidoApi {

    private final PedidoService pedidoService;

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('PEDIDO_CRIAR')")
    public ResponseEntity<PedidoResponse> criar(@Valid @RequestBody PedidoRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.criar(request));
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('PEDIDO_VISUALIZAR')")
    public ResponseEntity<PedidoResponse> buscarPorId(@PathVariable Integer id) {

        return ResponseEntity.ok(pedidoService.buscarPorId(id));
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('PEDIDO_VISUALIZAR')")
    public ResponseEntity<Page<PedidoResumoResponse>> listar(PedidoFilter filtro, Pageable pageable) {

        return ResponseEntity.ok(pedidoService.listar(filtro, pageable));
    }

    @Override
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('PEDIDO_EDITAR')")
    public ResponseEntity<PedidoResponse> atualizar(@PathVariable Integer id, @Valid @RequestBody PedidoRequest request) {

        return ResponseEntity.ok(pedidoService.atualizar(id, request));
    }

    @Override
    @PatchMapping("/{id}/status")
    @PreAuthorize("hasAuthority('PEDIDO_EDITAR')")
    public ResponseEntity<PedidoResponse> alterarStatus(@PathVariable Integer id, @RequestParam StatusPedido status) {

        return ResponseEntity.ok(pedidoService.alterarStatus(id, status));
    }

    @Override
    @PatchMapping("/{id}/cancelar")
    @PreAuthorize("hasAuthority('PEDIDO_CANCELAR')")
    public ResponseEntity<PedidoResponse> cancelar(@PathVariable Integer id) {

        return ResponseEntity.ok(pedidoService.cancelar(id));
    }
}