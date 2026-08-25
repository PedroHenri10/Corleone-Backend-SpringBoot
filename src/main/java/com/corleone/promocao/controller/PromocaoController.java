package com.corleone.promocao.controller;

import com.corleone.promocao.docs.PromocaoApi;
import com.corleone.promocao.dto.PromocaoFilter;
import com.corleone.promocao.dto.PromocaoRequest;
import com.corleone.promocao.dto.PromocaoResponse;
import com.corleone.promocao.dto.PromocaoResumoResponse;
import com.corleone.promocao.service.PromocaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/promocoes")
@RequiredArgsConstructor
public class PromocaoController implements PromocaoApi {

    private final PromocaoService service;

    @Override
    public ResponseEntity<PromocaoResponse> criar(PromocaoRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<PromocaoResponse> buscarPorId(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<List<PromocaoResumoResponse>> listar(PromocaoFilter filter) {
        return null;
    }

    @Override
    public ResponseEntity<PromocaoResponse> atualizar(Integer id, PromocaoRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<PromocaoResponse> ativar(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<PromocaoResponse> desativar(Integer id) {
        return null;
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
