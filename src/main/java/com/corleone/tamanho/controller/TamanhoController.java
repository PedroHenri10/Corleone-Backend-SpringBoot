package com.corleone.tamanho.controller;

import com.corleone.tamanho.docs.TamanhoApi;
import com.corleone.tamanho.dto.TamanhoRequest;
import com.corleone.tamanho.dto.TamanhoResponse;
import com.corleone.tamanho.dto.TamanhoResumoResponse;
import com.corleone.tamanho.service.TamanhoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tamanhos")
@RequiredArgsConstructor
public class TamanhoController implements TamanhoApi {

    private final TamanhoService service;

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('TAMANHO_CRIAR')")
    public ResponseEntity<TamanhoResponse> criar(@Valid @RequestBody TamanhoRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('TAMANHO_VISUALIZAR')")
    public ResponseEntity<TamanhoResponse> buscarPorId(@PathVariable Integer id
    ) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('TAMANHO_VISUALIZAR')")
    public ResponseEntity<List<TamanhoResumoResponse>> listar() {

        return ResponseEntity.ok(service.listar());
    }

    @Override
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('TAMANHO_EDITAR')")
    public ResponseEntity<TamanhoResponse> atualizar(@PathVariable Integer id, @Valid @RequestBody TamanhoRequest request
    ) {
        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('TAMANHO_EXCLUIR')")
    public ResponseEntity<Void> desativar(@PathVariable Integer id) {

        service.desativar(id);

        return ResponseEntity.noContent().build();
    }
}
