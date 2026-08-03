package com.corleone.mesa.controller;

import com.corleone.mesa.docs.MesaApi;
import com.corleone.mesa.dto.MesaFilter;
import com.corleone.mesa.dto.MesaRequest;
import com.corleone.mesa.dto.MesaResponse;
import com.corleone.mesa.dto.MesaResumoResponse;
import com.corleone.mesa.service.MesaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mesas")
@RequiredArgsConstructor
public class MesaController implements MesaApi {

    private final MesaService mesaService;

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('MESA_CRIAR')")
    public ResponseEntity<MesaResponse> criar(@Valid @RequestBody MesaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mesaService.criar(request));
    }

    @Override
    public ResponseEntity<MesaResponse> buscarPorId(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<Page<MesaResumoResponse>> listar(MesaFilter filtro, Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<MesaResponse> atualizar(@Valid @PathVariable Integer id, @RequestBody MesaRequest request) {
        return ResponseEntity.ok(mesaService.atualizar(id, request));
    }

    @Override
    public ResponseEntity<Void> desativar(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<MesaResponse> abrirMesa(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<MesaResponse> fecharMesa(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<MesaResponse> reservarMesa(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<MesaResponse> cancelarReserva(Integer id) {
        return null;
    }
}
