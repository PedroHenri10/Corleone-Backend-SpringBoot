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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/entregas")
@RequiredArgsConstructor
public class EntregaController implements EntregaApi {

    private final EntregaService service;

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('DELIVERY_ATUALIZAR')")
    public ResponseEntity<EntregaResponse> criar(@Valid @RequestBody EntregaRequest request) {

        return ResponseEntity.status(201).body(service.criar(request));
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
    public ResponseEntity<Page<EntregaResumoResponse>> listar(@RequestBody EntregaFilter filter, Pageable pageable
    ) {
        return ResponseEntity.ok(service.listar(filter, pageable));
    }

    @Override
    @PatchMapping("/{id}/status")
    @PreAuthorize("hasAuthority('DELIVERY_ATUALIZAR')")
    public ResponseEntity<EntregaResponse> atualizarStatus(@PathVariable Integer id, @Valid @RequestBody AtualizarStatusEntregaRequest request) {

        return ResponseEntity.ok(service.atualizarStatus(id, request));
    }

}