package com.corleone.cliente.controller;

import com.corleone.cliente.docs.ClienteApi;
import com.corleone.cliente.dto.*;
import com.corleone.cliente.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController implements ClienteApi {

    private final ClienteService service;

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('CLIENTE_CRIAR')")
    public ResponseEntity<ClienteResponse> criar(@Valid @RequestBody ClienteRequest request) {

        return ResponseEntity.status(201).body(service.criar(request));
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('CLIENTE_VISUALIZAR')")
    public ResponseEntity<ClienteResponse> buscarPorId(@PathVariable Integer id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('CLIENTE_VISUALIZAR')")
    public ResponseEntity<Page<ClienteResumoResponse>> listar(ClienteFiltro filtro, Pageable pageable) {

        return ResponseEntity.ok(service.listar(filtro, pageable));
    }

    @Override
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('CLIENTE_EDITAR')")
    public ResponseEntity<ClienteResponse> atualizar(@PathVariable Integer id, @Valid @RequestBody ClienteRequest request) {

        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('CLIENTE_EXCLUIR')")
    public ResponseEntity<Void> desativar(@PathVariable Integer id) {

        service.desativar(id);

        return ResponseEntity.noContent().build();
    }

}