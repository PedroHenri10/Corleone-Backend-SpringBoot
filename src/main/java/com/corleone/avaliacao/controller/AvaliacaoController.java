package com.corleone.avaliacao.controller;

import com.corleone.avaliacao.docs.AvaliacaoApi;
import com.corleone.avaliacao.dto.AvaliacaoFilter;
import com.corleone.avaliacao.dto.AvaliacaoRequest;
import com.corleone.avaliacao.dto.AvaliacaoResponse;
import com.corleone.avaliacao.dto.AvaliacaoResumoResponse;
import com.corleone.avaliacao.service.AvaliacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
@RequiredArgsConstructor
public class AvaliacaoController implements AvaliacaoApi {
    private final AvaliacaoService service;


    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('AVALIACAO_MODERAR')")
    public ResponseEntity<AvaliacaoResponse> criar(@Valid @RequestBody AvaliacaoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @Override
    public ResponseEntity<AvaliacaoResponse> buscarPorId(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<List<AvaliacaoResumoResponse>> listar(AvaliacaoFilter filter) {
        return null;
    }

    @Override
    public ResponseEntity<AvaliacaoResponse> atualizar(Integer id, AvaliacaoRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Void> excluir(Integer id) {
        return null;
    }
}
