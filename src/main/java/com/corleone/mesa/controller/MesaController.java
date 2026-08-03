package com.corleone.mesa.controller;

import com.corleone.mesa.docs.MesaApi;
import com.corleone.mesa.dto.MesaFilter;
import com.corleone.mesa.dto.MesaRequest;
import com.corleone.mesa.dto.MesaResponse;
import com.corleone.mesa.dto.MesaResumoResponse;
import com.corleone.mesa.service.MesaService;
import io.micrometer.observation.transport.ResponseContext;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('MESA_VISUALIZAR')")
    public ResponseEntity<MesaResponse> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(mesaService.buscarPorId(id));
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('MESA_VISUALIZAR')")
    public ResponseEntity<List<MesaResumoResponse>> listar(MesaFilter filtro) {
        return ResponseEntity.ok(mesaService.listar(filtro));
    }

    @Override
    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('MESA_EDITAR')")
    public ResponseEntity<MesaResponse> atualizar(@Valid @PathVariable Integer id, @RequestBody MesaRequest request) {
        return ResponseEntity.ok(mesaService.atualizar(id, request));
    }

    @Override
    @DeleteMapping("/{id}")
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('MESA_EXCLUIR')")
    public ResponseEntity<Void> desativar(@PathVariable Integer id) {
        mesaService.desativar(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PreAuthorize("hasAuthority('MESA_ABRIR')")
    @PatchMapping("/{id}/abrir")
    public ResponseEntity<MesaResponse> abrirMesa(@PathVariable Integer id) {
        return ResponseEntity.ok(mesaService.abrirMesa(id));
    }

    @Override
    @PreAuthorize("hasAuthority('MESA_FECHAR')")
    @PatchMapping("/{id}/fechar")
    public ResponseEntity<MesaResponse> fecharMesa(@PathVariable Integer id) {
        return ResponseEntity.ok(mesaService.fecharMesa(id));
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
