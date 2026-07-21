package com.corleone.fornecedor.controller;

import com.corleone.fornecedor.docs.FornecedorApi;
import com.corleone.fornecedor.dto.*;
import com.corleone.fornecedor.service.FornecedorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fornecedores")
@RequiredArgsConstructor
public class FornecedorController implements FornecedorApi {

    private final FornecedorService service;

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('FORNECEDOR_CRIAR')")
    public ResponseEntity<FornecedorResponse> criar(@Valid @RequestBody FornecedorRequest request) {

        return ResponseEntity.status(201).body(service.criar(request));
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('FORNECEDOR_VISUALIZAR')")
    public ResponseEntity<FornecedorResponse> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('FORNECEDOR_VISUALIZAR')")
    public ResponseEntity<Page<FornecedorResumoResponse>> listar(FornecedorFiltro filtro, Pageable pageable) {

        return ResponseEntity.ok(service.listar(filtro, pageable));
    }

    @Override
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('FORNECEDOR_EDITAR')")
    public ResponseEntity<FornecedorResponse> atualizar(@PathVariable Integer id, @Valid @RequestBody FornecedorRequest request) {

        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('FORNECEDOR_EXCLUIR')")
    public ResponseEntity<Void> desativar(@PathVariable Integer id) {

        service.desativar(id);

        return ResponseEntity.noContent().build();
    }

}