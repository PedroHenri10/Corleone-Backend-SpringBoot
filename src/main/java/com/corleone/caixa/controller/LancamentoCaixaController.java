package com.corleone.caixa.controller;

import com.corleone.caixa.docs.LancamentoCaixaApi;
import com.corleone.caixa.dto.LancamentoCaixaRequest;
import com.corleone.caixa.dto.LancamentoCaixaResponse;
import com.corleone.caixa.dto.LancamentoCaixaResumoResponse;
import com.corleone.shared.enums.TipoLancamentoCaixa;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class LancamentoCaixaController implements LancamentoCaixaApi {
    @Override
    public ResponseEntity<LancamentoCaixaResponse> criar(LancamentoCaixaRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<LancamentoCaixaResponse> buscarPorId(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<List<LancamentoCaixaResumoResponse>> listar(Integer caixaId, Integer funcionarioId, Integer pedidoId, Integer pagamentoId, TipoLancamentoCaixa tipo, LocalDate dataInicial, LocalDate dataFinal) {
        return null;
    }

    @Override
    public ResponseEntity<List<LancamentoCaixaResumoResponse>> listarPorCaixa(Integer caixaId) {
        return null;
    }
}
