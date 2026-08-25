package com.corleone.promocao.controller;

import com.corleone.promocao.docs.PromocaoApi;
import com.corleone.promocao.dto.PromocaoFilter;
import com.corleone.promocao.dto.PromocaoRequest;
import com.corleone.promocao.dto.PromocaoResponse;
import com.corleone.promocao.dto.PromocaoResumoResponse;
import com.corleone.promocao.service.PromocaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/promocoes")
@RequiredArgsConstructor
public class PromocaoController implements PromocaoApi {

    private final PromocaoService service;

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('PROMOCAO_CRIAR')")
    public ResponseEntity<PromocaoResponse> criar(@RequestBody PromocaoRequest request) {

        return ResponseEntity.ok(service.criar(request)
        );
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('PROMOCAO_VISUALIZAR')")
    public ResponseEntity<PromocaoResponse> buscarPorId(@PathVariable Integer id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('PROMOCAO_VISUALIZAR')")
    public ResponseEntity<List<PromocaoResumoResponse>> listar(PromocaoFilter filter) {

        return ResponseEntity.ok(service.listar(filter));
    }

    @Override
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('PROMOCAO_EDITAR')")
    public ResponseEntity<PromocaoResponse> atualizar(@PathVariable Integer id, @RequestBody PromocaoRequest request) {

        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @Override
    @PatchMapping("/{id}/ativar")
    @PreAuthorize("hasAuthority('PROMOCAO_EDITAR')")
    public ResponseEntity<PromocaoResponse> ativar(@PathVariable Integer id) {

        return ResponseEntity.ok(service.ativar(id));
    }

    @Override
    @PatchMapping("/{id}/desativar")
    @PreAuthorize("hasAuthority('PROMOCAO_EDITAR')")
    public ResponseEntity<PromocaoResponse> desativar(@PathVariable Integer id) {

        return ResponseEntity.ok(service.desativar(id));
    }

    @Override
    public ResponseEntity<Void> excluir(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<List<PromocaoResumoResponse>> listarAtivas() {
        return null;
    }

    @Override
    public ResponseEntity<List<PromocaoResumoResponse>> listarEmVigencia() {
        return null;
    }
}
