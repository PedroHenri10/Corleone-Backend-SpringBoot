package com.corleone.produto.controller;

import com.corleone.produto.docs.ProdutoApi;
import com.corleone.produto.dto.ProdutoFilter;
import com.corleone.produto.dto.ProdutoRequest;
import com.corleone.produto.dto.ProdutoResponse;
import com.corleone.produto.dto.ProdutoResumoResponse;
import com.corleone.produto.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController implements ProdutoApi {

    private final ProdutoService service;

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('PRODUTO_CRIAR')")
    public ResponseEntity<ProdutoResponse> criar(@Valid @RequestBody ProdutoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('PRODUTO_VISUALIZAR')")
    public ResponseEntity<ProdutoResponse> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('PRODUTO_VISUALIZAR')")
    public ResponseEntity<Page<ProdutoResumoResponse>> listar(ProdutoFilter filtro, Pageable pageable) {
        return ResponseEntity.ok(service.listar(filtro, pageable));
    }

    @Override
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('PRODUTO_EDITAR')")
    public ResponseEntity<ProdutoResponse> atualizar(@PathVariable Integer id, @Valid @RequestBody ProdutoRequest request) {
        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('PRODUTO_EXCLUIR')")
    public ResponseEntity<Void> desativar(@PathVariable Integer id) {
        service.desativar(id);
        return ResponseEntity.noContent().build();
    }
}