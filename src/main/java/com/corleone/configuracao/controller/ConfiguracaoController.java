package com.corleone.configuracao.controller;

import com.corleone.configuracao.docs.ConfiguracaoApi;
import com.corleone.configuracao.dto.ConfiguracaoRequest;
import com.corleone.configuracao.dto.ConfiguracaoResponse;
import com.corleone.configuracao.dto.ConfiguracaoResumoResponse;
import com.corleone.configuracao.service.ConfiguracaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/configuracoes")
@RequiredArgsConstructor
public class ConfiguracaoController implements ConfiguracaoApi {

    private final ConfiguracaoService service;

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('CONFIGURACAO_CRIAR')")
    public ResponseEntity<ConfiguracaoResponse> criar(@Valid @RequestBody ConfiguracaoRequest request) {

        return ResponseEntity.ok(service.criar(request));
    }

    
}