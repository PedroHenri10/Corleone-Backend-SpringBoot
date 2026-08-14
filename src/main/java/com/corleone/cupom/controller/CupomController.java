package com.corleone.cupom.controller;

import com.corleone.cupom.CupomApi;
import com.corleone.cupom.dto.CupomFilter;
import com.corleone.cupom.dto.CupomRequest;
import com.corleone.cupom.dto.CupomResponse;
import com.corleone.cupom.dto.CupomResumoResponse;
import com.corleone.cupom.service.CupomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/cupons")
@RequiredArgsConstructor
public class CupomController implements CupomApi {

    private final CupomService service;

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('CUPOM_CRIAR')")
    public ResponseEntity<CupomResponse> criar(@Valid @RequestBody CupomRequest request) {

        return ResponseEntity.ok(service.criar(request));
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('CUPOM_VISUALIZAR')")
    public ResponseEntity<CupomResponse> buscarPorId(@PathVariable Integer id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('CUPOM_VISUALIZAR')")
    public ResponseEntity<List<CupomResumoResponse>> listar(@ModelAttribute CupomFilter filter) {

        return ResponseEntity.ok(service.listar(filter));
    }

    @Override
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('CUPOM_EDITAR')")
    public ResponseEntity<CupomResponse> atualizar(@PathVariable Integer id, @Valid @RequestBody CupomRequest request) {

        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('CUPOM_EXCLUIR')")
    public ResponseEntity<Void> desativar(@PathVariable Integer id) {

        service.desativar(id);

        return ResponseEntity.noContent().build();
    }
}
