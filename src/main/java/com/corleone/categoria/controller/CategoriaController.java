package com.corleone.categoria.controller;

import com.corleone.categoria.docs.CategoriaApi;
import com.corleone.categoria.dto.CategoriaRequest;
import com.corleone.categoria.dto.CategoriaResponse;
import com.corleone.categoria.dto.CategoriaResumoResponse;
import com.corleone.categoria.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController implements CategoriaApi {
    private final CategoriaService service;

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('CATEGORIA_CRIAR')")
    public ResponseEntity<CategoriaResponse> criar(@Valid @RequestBody CategoriaRequest request) {

        CategoriaResponse response = service.criar(request);

        return ResponseEntity.created(URI.create("/categorias/" + response.getId())).body(response);
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('CATEGORIA_VISUALIZAR')")
    public ResponseEntity<CategoriaResponse> buscarPorId(@PathVariable Integer id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('CATEGORIA_VISUALIZAR')")
    public ResponseEntity<List<CategoriaResumoResponse>> listar() {

        return ResponseEntity.ok(service.listar());
    }

    @Override
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('CATEGORIA_EDITAR')")
    public ResponseEntity<CategoriaResponse> atualizar(@PathVariable Integer id, @Valid @RequestBody CategoriaRequest request) {

        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('CATEGORIA_EXCLUIR')")
    public ResponseEntity<Void> desativar(@PathVariable Integer id) {

        service.desativar(id);

        return ResponseEntity.noContent().build();
    }
}
