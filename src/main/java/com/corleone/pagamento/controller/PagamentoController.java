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
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('PAGAMENTO_VISUALIZAR')")
    public ResponseEntity<PagamentoResponse> buscarPorId(@PathVariable Integer id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }


    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('PAGAMENTO_VISUALIZAR')")
    public ResponseEntity<List<PagamentoResumoResponse>> listar(PagamentoFilter filter) {

        return ResponseEntity.ok(service.listar(filter));
    }

    @Override
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('PAGAMENTO_EDITAR')")
    public ResponseEntity<PagamentoResponse> atualizar(@PathVariable Integer id, @RequestBody PagamentoRequest request) {

        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @Override
    @PatchMapping("/{id}/ativar")
    @PreAuthorize("hasAuthority('PAGAMENTO_EDITAR')")
    public ResponseEntity<PagamentoResponse> ativar(@PathVariable Integer id) {

        return ResponseEntity.ok(service.ativar(id));
    }

    @Override
    @PatchMapping("/{id}/desativar")
    @PreAuthorize("hasAuthority('PAGAMENTO_EDITAR')")
    public ResponseEntity<PagamentoResponse> desativar(@PathVariable Integer id) {

        return ResponseEntity.ok(service.desativar(id));
    }
}
