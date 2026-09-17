package com.corleone.caixa.controller;

import com.corleone.caixa.docs.CaixaApi;
import com.corleone.caixa.dto.CaixaFilter;
import com.corleone.caixa.dto.CaixaRequest;
import com.corleone.caixa.dto.CaixaResponse;
import com.corleone.caixa.dto.CaixaResumoResponse;
import com.corleone.caixa.service.CaixaService;
import com.corleone.shared.enums.StatusCaixa;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CaixaController implements CaixaApi {

    private final CaixaService service;

    @Override
    @PreAuthorize("hasAuthority('CAIXA_CRIAR')")
    public ResponseEntity<CaixaResponse> abrir(@Valid CaixaRequest request
    ) {
        return ResponseEntity
                .status(201)
                .body(service.abrir(request));
    }

    @Override
    @PreAuthorize("hasAuthority('CAIXA_FECHAR')")
    public ResponseEntity<CaixaResponse> fechar(Integer id, BigDecimal valorFechamento
    ) {
        return ResponseEntity.ok(service.fechar(id, valorFechamento));
    }

    @Override
    @PreAuthorize("hasAuthority('CAIXA_VISUALIZAR')")
    public ResponseEntity<CaixaResponse> buscarPorId(Integer id
    ) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Override
    @PreAuthorize("hasAuthority('CAIXA_VISUALIZAR')")
    public ResponseEntity<List<CaixaResumoResponse>> listar(Integer funcionarioId, StatusCaixa status, LocalDate dataInicial,
            LocalDate dataFinal
    ) {
        CaixaFilter filter = CaixaFilter.builder()
                .funcionarioId(funcionarioId)
                .status(status)
                .dataInicial(dataInicial)
                .dataFinal(dataFinal)
                .build();

        return ResponseEntity.ok(service.listar(filter));
    }


    @Override
    public ResponseEntity<List<CaixaResumoResponse>> listarAbertos() {
        return null;
    }
}
