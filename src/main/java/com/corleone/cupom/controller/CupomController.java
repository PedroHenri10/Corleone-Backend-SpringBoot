package com.corleone.cupom.controller;

import com.corleone.cupom.CupomApi;
import com.corleone.cupom.dto.CupomFilter;
import com.corleone.cupom.dto.CupomRequest;
import com.corleone.cupom.dto.CupomResponse;
import com.corleone.cupom.dto.CupomResumoResponse;
import com.corleone.cupom.service.CupomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/cupons")
@RequiredArgsConstructor
public class CupomController implements CupomApi {

    private final CupomService service;

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('CUPOM_CRIAR')")
    public ResponseEntity<CupomResponse> criar(
            @Valid @RequestBody CupomRequest request) {

        return ResponseEntity.ok(service.criar(request));
    }


    @Override
    public ResponseEntity<CupomResponse> buscarPorId(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<List<CupomResumoResponse>> listar(CupomFilter filter) {
        return null;
    }

    @Override
    public ResponseEntity<CupomResponse> atualizar(Integer id, CupomRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Void> desativar(Integer id) {
        return null;
    }
}
