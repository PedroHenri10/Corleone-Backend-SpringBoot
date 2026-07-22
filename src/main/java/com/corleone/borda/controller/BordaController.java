package com.corleone.borda.controller;

import com.corleone.borda.docs.BordaApi;
import com.corleone.borda.dto.BordaRequest;
import com.corleone.borda.dto.BordaResponse;
import com.corleone.borda.dto.BordaResumoResponse;
import com.corleone.borda.service.BordaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bordas")
@RequiredArgsConstructor
public class BordaController implements BordaApi {

    private final BordaService service;

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('BORDA_CRIAR')")
    public ResponseEntity<BordaResponse> criar(@Valid @RequestBody BordaRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.criar(request));
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('BORDA_VISUALIZAR')")
    public ResponseEntity<BordaResponse> buscarPorId(@PathVariable Integer id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('BORDA_VISUALIZAR')")
    public ResponseEntity<List<BordaResumoResponse>> listar() {

        return ResponseEntity.ok(service.listar());
    }

    @Override
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('BORDA_EDITAR')")
    public ResponseEntity<BordaResponse> atualizar(@PathVariable Integer id, @Valid @RequestBody BordaRequest request) {

        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('BORDA_EXCLUIR')")
    public ResponseEntity<Void> desativar(@PathVariable Integer id) {

        service.desativar(id);

        return ResponseEntity.noContent().build();
    }
}
