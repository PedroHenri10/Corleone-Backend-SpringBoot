package com.corleone.caixa.controller;

import com.corleone.caixa.docs.CaixaApi;
import com.corleone.caixa.dto.CaixaRequest;
import com.corleone.caixa.dto.CaixaResponse;
import com.corleone.caixa.dto.CaixaResumoResponse;
import com.corleone.shared.enums.StatusCaixa;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CaixaController implements CaixaApi {
    @Override
    public ResponseEntity<CaixaResponse> abrir(CaixaRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<CaixaResponse> fechar(Integer id, BigDecimal valorFechamento) {
        return null;
    }

    @Override
    public ResponseEntity<CaixaResponse> buscarPorId(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<List<CaixaResumoResponse>> listar(Integer funcionarioId, StatusCaixa status, LocalDate dataInicial, LocalDate dataFinal) {
        return null;
    }

    @Override
    public ResponseEntity<List<CaixaResumoResponse>> listarAbertos() {
        return null;
    }
}
