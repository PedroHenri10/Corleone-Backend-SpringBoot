package com.corleone.entrega.controller;

import com.corleone.entrega.docs.EntregaApi;
import com.corleone.entrega.dto.AtualizarStatusEntregaRequest;
import com.corleone.entrega.dto.EntregaFilter;
import com.corleone.entrega.dto.EntregaRequest;
import com.corleone.entrega.dto.EntregaResponse;
import com.corleone.entrega.dto.EntregaResumoResponse;
import com.corleone.entrega.service.EntregaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entregas")
@RequiredArgsConstructor
public class EntregaController implements EntregaApi {

    private final EntregaService service;

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('DELIVERY_ATUALIZAR')")
    public ResponseEntity<EntregaResponse> criar(@Valid @RequestBody EntregaRequest request) {

        return ResponseEntity.ok(service.criar(request));
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('DELIVERY_VISUALIZAR')")
    public ResponseEntity<EntregaResponse> buscarPorId(@PathVariable Integer id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Override
    @PostMapping("/filtro")
    @PreAuthorize("hasAuthority('DELIVERY_VISUALIZAR')")
    public ResponseEntity<List<EntregaResumoResponse>> listar(@RequestBody EntregaFilter filter) {

        return ResponseEntity.ok(service.listar(filter));
    }

    @Override
    @PatchMapping("/{id}/iniciar")
    @PreAuthorize("hasAuthority('DELIVERY_ATUALIZAR')")
    public ResponseEntity<EntregaResponse> iniciarEntrega(@PathVariable Integer id) {

        return ResponseEntity.ok(service.iniciarEntrega(id));
    }

    @Override
    @PatchMapping("/{id}/finalizar")
    @PreAuthorize("hasAuthority('DELIVERY_ATUALIZAR')")
    public ResponseEntity<EntregaResponse> finalizarEntrega(@PathVariable Integer id) {

        return ResponseEntity.ok(service.finalizarEntrega(id));
    }

    @Override
    @PatchMapping("/{id}/cancelar")
    @PreAuthorize("hasAuthority('DELIVERY_ATUALIZAR')")
    public ResponseEntity<EntregaResponse> cancelarEntrega(@PathVariable Integer id) {

        return ResponseEntity.ok(service.cancelarEntrega(id));
    }

    @Override
    @PatchMapping("/{id}/status")
    @PreAuthorize("hasAuthority('DELIVERY_ATUALIZAR')")
    public ResponseEntity<EntregaResponse> atualizarStatus(@PathVariable Integer id, @Valid @RequestBody AtualizarStatusEntregaRequest request) {

        return ResponseEntity.ok(service.atualizarStatus(id, request));
    }

}