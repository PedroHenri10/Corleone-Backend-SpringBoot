package com.corleone.estoque.controller;

import com.corleone.estoque.docs.EstoqueApi;
import com.corleone.estoque.dto.*;
import com.corleone.estoque.service.EstoqueService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estoques")
@RequiredArgsConstructor
public class EstoqueController implements EstoqueApi {

    private final EstoqueService service;

    @Override
    @PostMapping("/entrada")
    public ResponseEntity<EstoqueResponse> entrada(@Valid @RequestBody EstoqueRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.entrada(request));
    }

    @Override
    @PostMapping("/saida")
    public ResponseEntity<EstoqueResponse> saida(@Valid @RequestBody EstoqueRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saida(request));
    }

    @Override
    @PostMapping("/ajuste")
    public ResponseEntity<EstoqueResponse> ajuste(@Valid @RequestBody EstoqueRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.ajuste(request));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<EstoqueResponse> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<Page<EstoqueResumoResponse>> listar(EstoqueFilter filter, Pageable pageable) {
        return ResponseEntity.ok(service.listar(filter, pageable));
    }

    @Override
    @GetMapping("/atual")
    public ResponseEntity<Page<EstoqueAtualResponse>> listarEstoqueAtual(Pageable pageable) {
        return ResponseEntity.ok(service.listarEstoqueAtual(pageable));
    }

    @Override
    @PostMapping("/ingredientes/entrada")
    public ResponseEntity<MovimentoIngredienteResponse> entradaIngrediente(
            @Valid @RequestBody MovimentoIngredienteRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.entradaIngrediente(request));
    }

    @Override
    @PostMapping("/ingredientes/saida")
    public ResponseEntity<MovimentoIngredienteResponse> saidaIngrediente(@Valid @RequestBody MovimentoIngredienteRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.saidaIngrediente(request));
    }

    @Override
    @PostMapping("/ingredientes/ajuste")
    public ResponseEntity<MovimentoIngredienteResponse> ajusteIngrediente(@Valid @RequestBody MovimentoIngredienteRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.ajusteIngrediente(request));
    }

    @Override
    @GetMapping("/ingredientes/{id}")
    public ResponseEntity<MovimentoIngredienteResponse> buscarMovimentoIngrediente(@PathVariable Integer id) {

        return ResponseEntity.ok(service.buscarMovimentoIngrediente(id));
    }

    @Override
    @GetMapping("/ingredientes")
    public ResponseEntity<Page<MovimentoIngredienteResumoResponse>> listarMovimentosIngrediente(MovimentoIngredienteFilter filter, Pageable pageable) {

        return ResponseEntity.ok(service.listarMovimentosIngrediente(filter, pageable));
    }

    @Override
    @GetMapping("/ingredientes/estoque")
    public ResponseEntity<Page<EstoqueIngredienteResponse>> listarEstoqueIngrediente(Pageable pageable) {

        return ResponseEntity.ok(service.listarEstoqueIngrediente(pageable));
    }
}