package com.corleone.cargo.controller;

import com.corleone.cargo.docs.CargoApi;
import com.corleone.cargo.dto.CargoRequest;
import com.corleone.cargo.dto.CargoResponse;
import com.corleone.cargo.service.CargoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cargos")
@RequiredArgsConstructor
public class CargoController implements CargoApi {

    private final CargoService service;

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('CATEGORIA_CRIAR')")
    public ResponseEntity<CargoResponse> criar(@Valid @RequestBody CargoRequest request) {

        CargoResponse response = service.criar(request);

        return ResponseEntity.created(URI.create("/cargos/" + response.getId())).body(response);
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('CARGO_VISUALIZAR')")
    public ResponseEntity<CargoResponse> buscarPorId(@PathVariable Integer id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('CARGO_VISUALIZAR')")
    public ResponseEntity<List<CargoResponse>> listar() {

        return ResponseEntity.ok(service.listar());
    }

    @Override
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('CARGO_EDITAR')")
    public ResponseEntity<CargoResponse> atualizar(@PathVariable Integer id, @Valid @RequestBody CargoRequest request) {

        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('CARGO_EXCLUIR')")
    public ResponseEntity<Void> desativar(@PathVariable Integer id) {

        service.desativar(id);

        return ResponseEntity.noContent().build();
    }

}