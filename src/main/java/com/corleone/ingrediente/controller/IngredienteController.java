package com.corleone.ingrediente.controller;

import com.corleone.ingrediente.docs.IngredienteApi;
import com.corleone.ingrediente.dto.IngredienteFilter;
import com.corleone.ingrediente.dto.IngredienteRequest;
import com.corleone.ingrediente.dto.IngredienteResponse;
import com.corleone.ingrediente.dto.IngredienteResumoResponse;
import com.corleone.ingrediente.service.IngredienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredientes")
@RequiredArgsConstructor
public class IngredienteController implements IngredienteApi {

    private final IngredienteService service;

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('INGREDIENTE_CRIAR')")
    public ResponseEntity<IngredienteResponse> criar(@Valid @RequestBody IngredienteRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('INGREDIENTE_VISUALIZAR')")
    public ResponseEntity<IngredienteResponse> buscarPorId(@PathVariable Integer id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('INGREDIENTE_VISUALIZAR')")
    public ResponseEntity<Page<IngredienteResumoResponse>> listar(IngredienteFilter filtro, Pageable pageable) {

        return ResponseEntity.ok(service.listar(filtro, pageable));
    }

    @Override
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('INGREDIENTE_EDITAR')")
    public ResponseEntity<IngredienteResponse> atualizar(@PathVariable Integer id, @Valid @RequestBody IngredienteRequest request) {

        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('INGREDIENTE_EXCLUIR')")
    public ResponseEntity<Void> desativar(@PathVariable Integer id) {

        service.desativar(id);

        return ResponseEntity.noContent().build();
    }
}