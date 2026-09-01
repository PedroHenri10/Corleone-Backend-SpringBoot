package com.corleone.pagamento.controller;

import com.corleone.pagamento.docs.PagamentoApi;
import com.corleone.pagamento.dto.PagamentoFilter;
import com.corleone.pagamento.dto.PagamentoRequest;
import com.corleone.pagamento.dto.PagamentoResponse;
import com.corleone.pagamento.dto.PagamentoResumoResponse;
import com.corleone.pagamento.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/pagamentos")
@RequiredArgsConstructor
public class PagamentoController implements PagamentoApi {

    private final PagamentoService service;

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('PAGAMENTO_CRIAR')")
    public ResponseEntity<PagamentoResponse> criar(@RequestBody PagamentoRequest request) {

        return ResponseEntity.ok(service.criar(request));
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
