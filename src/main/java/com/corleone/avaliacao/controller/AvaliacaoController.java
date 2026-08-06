package com.corleone.avaliacao.controller;

import com.corleone.avaliacao.docs.AvaliacaoApi;
import com.corleone.avaliacao.dto.AvaliacaoFilter;
import com.corleone.avaliacao.dto.AvaliacaoRequest;
import com.corleone.avaliacao.dto.AvaliacaoResponse;
import com.corleone.avaliacao.dto.AvaliacaoResumoResponse;
import com.corleone.avaliacao.service.AvaliacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
@RequiredArgsConstructor
public class AvaliacaoController extends AvaliacaoApi {
    private final AvaliacaoService service;


    @Override
    @PostMapping
    public ResponseEntity<AvaliacaoResponse> criar(AvaliacaoRequest request) {
        return null;
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
