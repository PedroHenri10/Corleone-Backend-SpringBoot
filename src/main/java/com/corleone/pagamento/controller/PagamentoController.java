package com.corleone.pagamento.controller;

import com.corleone.pagamento.docs.PagamentoApi;
import com.corleone.pagamento.dto.PagamentoFilter;
import com.corleone.pagamento.dto.PagamentoRequest;
import com.corleone.pagamento.dto.PagamentoResponse;
import com.corleone.pagamento.dto.PagamentoResumoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/pagamentos")
@RequiredArgsConstructor
public class PagamentoController implements PagamentoApi {
    @Override
    public ResponseEntity<PagamentoResponse> criar(PagamentoRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<PagamentoResponse> buscarPorId(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<List<PagamentoResumoResponse>> listar(PagamentoFilter filter) {
        return null;
    }

    @Override
    public ResponseEntity<List<PagamentoResumoResponse>> listarAtivos() {
        return null;
    }

    @Override
    public ResponseEntity<PagamentoResponse> atualizar(Integer id, PagamentoRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<PagamentoResponse> ativar(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<PagamentoResponse> desativar(Integer id) {
        return null;
    }
}
