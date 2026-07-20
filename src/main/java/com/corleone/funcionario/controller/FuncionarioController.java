package com.corleone.funcionario.controller;

import com.corleone.funcionario.docs.FuncionarioApi;
import com.corleone.funcionario.dto.FuncionarioFiltro;
import com.corleone.funcionario.dto.FuncionarioRequest;
import com.corleone.funcionario.dto.FuncionarioResponse;
import com.corleone.funcionario.dto.FuncionarioResumoResponse;
import com.corleone.funcionario.service.FuncionarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController implements FuncionarioApi {

    private final FuncionarioService funcionarioService;

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('FUNCIONARIO_CRIAR')")
    public ResponseEntity<FuncionarioResponse> criar(@Valid @RequestBody FuncionarioRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.criar(request));
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('FUNCIONARIO_VISUALIZAR')")
    public ResponseEntity<FuncionarioResponse> buscarPorId(@PathVariable Integer id) {

        return ResponseEntity.ok(funcionarioService.buscarPorId(id));
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('FUNCIONARIO_VISUALIZAR')")
    public ResponseEntity<Page<FuncionarioResumoResponse>> listar(FuncionarioFiltro filtro, Pageable pageable) {
        return ResponseEntity.ok(funcionarioService.listar(filtro, pageable)
        );
    }

    @Override
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('FUNCIONARIO_EDITAR')")
    public ResponseEntity<FuncionarioResponse> atualizar(@Valid @PathVariable Integer id, @RequestBody FuncionarioRequest request) {

        return ResponseEntity.ok(funcionarioService.atualizar(id, request)
        );
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('FUNCIONARIO_EXCLUIR')")
    public ResponseEntity<Void> desativar(@PathVariable Integer id) {

        funcionarioService.desativar(id);

        return ResponseEntity.noContent().build();
    }
}