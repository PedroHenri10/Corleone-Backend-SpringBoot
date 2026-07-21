package com.corleone.usuario.controller;

import com.corleone.usuario.docs.UsuarioApi;
import com.corleone.usuario.dto.UsuarioRequest;
import com.corleone.usuario.dto.UsuarioResponse;
import com.corleone.usuario.dto.UsuarioResumoResponse;
import com.corleone.usuario.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController implements UsuarioApi {

    private final UsuarioService service;

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('USUARIO_CRIAR')")
    public ResponseEntity<UsuarioResponse> criar(@Valid @RequestBody UsuarioRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @Override
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('USUARIO_EDITAR')")
    public ResponseEntity<UsuarioResponse> atualizar(@PathVariable Integer id, @Valid @RequestBody UsuarioRequest request) {

        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USUARIO_VISUALIZAR')")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable Integer id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('USUARIO_VISUALIZAR')")
    public ResponseEntity<Page<UsuarioResumoResponse>> listar(Pageable pageable) {

        return ResponseEntity.ok(service.listar(pageable));
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('USUARIO_EXCLUIR')")
    public ResponseEntity<Void> desativar(@PathVariable Integer id) {

        service.desativar(id);

        return ResponseEntity.noContent().build();
    }

}