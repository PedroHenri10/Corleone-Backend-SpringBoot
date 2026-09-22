package com.corleone.caixa.controller;

import com.corleone.caixa.docs.LancamentoCaixaApi;
import com.corleone.caixa.dto.LancamentoCaixaFilter;
import com.corleone.caixa.dto.LancamentoCaixaRequest;
import com.corleone.caixa.dto.LancamentoCaixaResponse;
import com.corleone.caixa.dto.LancamentoCaixaResumoResponse;
import com.corleone.caixa.service.LancamentoCaixaService;
import com.corleone.shared.enums.TipoLancamentoCaixa;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class LancamentoCaixaController implements LancamentoCaixaApi {

    private final LancamentoCaixaService service;

    @Override
    @PreAuthorize("hasAuthority('CAIXA_LANCAMENTO')")
    public ResponseEntity<LancamentoCaixaResponse> criar(@Valid LancamentoCaixaRequest request
    ) {
        return ResponseEntity.status(201).body(service.criar(request));
    }

    @Override
    @PreAuthorize("hasAuthority('CAIXA_LANCAMENTO')")
    public ResponseEntity<LancamentoCaixaResponse> buscarPorId(Integer id
    ) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Override
    @PreAuthorize("hasAuthority('CAIXA_LANCAMENTO')")
    public ResponseEntity<List<LancamentoCaixaResumoResponse>> listar(
            Integer caixaId,
            Integer funcionarioId,
            Integer pedidoId,
            Integer pagamentoId,
            TipoLancamentoCaixa tipo,
            LocalDate dataInicial,
            LocalDate dataFinal
    ) {
        LancamentoCaixaFilter filter = LancamentoCaixaFilter.builder()
                .caixaId(caixaId)
                .funcionarioId(funcionarioId)
                .pedidoId(pedidoId)
                .pagamentoId(pagamentoId)
                .tipo(tipo)
                .dataInicial(dataInicial)
                .dataFinal(dataFinal)
                .build();

        return ResponseEntity.ok(service.listar(filter));
    }

    @Override
    public ResponseEntity<List<LancamentoCaixaResumoResponse>> listarPorCaixa(Integer caixaId) {
        return null;
    }
}
