package com.corleone.endereco.controller;

import com.corleone.endereco.docs.EnderecoApi;
import com.corleone.endereco.dto.EnderecoRequest;
import com.corleone.endereco.dto.EnderecoResponse;
import com.corleone.endereco.dto.EnderecoResumoResponse;
import com.corleone.endereco.service.EnderecoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
@RequiredArgsConstructor
public class EnderecoController implements EnderecoApi {

    private final EnderecoService enderecoService;

    @Override
    @PostMapping
    public ResponseEntity<EnderecoResponse> criar(@Valid @RequestBody EnderecoRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.criar(request));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponse> buscarPorId(@PathVariable Integer id) {

        return ResponseEntity.ok(enderecoService.buscarPorId(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<EnderecoResumoResponse>> listar() {

        return ResponseEntity.ok(enderecoService.listar());
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<EnderecoResponse> atualizar(@PathVariable Integer id, @Valid @RequestBody EnderecoRequest request) {

        return ResponseEntity.ok(enderecoService.atualizar(id, request));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {

        enderecoService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}