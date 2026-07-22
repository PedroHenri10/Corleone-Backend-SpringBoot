package com.corleone.sabor.controller;

import com.corleone.sabor.docs.SaborApi;
import com.corleone.sabor.dto.*;
import com.corleone.sabor.service.SaborService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sabores")
@RequiredArgsConstructor
public class SaborController implements SaborApi {

    private final SaborService service;

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('SABOR_CRIAR')")
    public ResponseEntity<SaborResponse> criar(@Valid @RequestBody SaborRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SABOR_VISUALIZAR')")
    public ResponseEntity<SaborResponse> buscarPorId(@PathVariable Integer id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('SABOR_VISUALIZAR')")
    public ResponseEntity<Page<SaborResumoResponse>> listar(SaborFiltro filtro, Pageable pageable) {

        return ResponseEntity.ok(service.listar(filtro, pageable));
    }

    @Override
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SABOR_EDITAR')")
    public ResponseEntity<SaborResponse> atualizar(@PathVariable Integer id, @Valid @RequestBody SaborRequest request) {

        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SABOR_EXCLUIR')")
    public ResponseEntity<Void> desativar(@PathVariable Integer id) {

        service.desativar(id);

        return ResponseEntity.noContent().build();
    }
}