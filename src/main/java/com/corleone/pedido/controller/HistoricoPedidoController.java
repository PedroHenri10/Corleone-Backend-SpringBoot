package com.corleone.pedido.controller;

import com.corleone.pedido.docs.HistoricoPedidoApi;
import com.corleone.pedido.dto.HistoricoPedidoFilter;
import com.corleone.pedido.dto.HistoricoPedidoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/historicos-pedido")
@RequiredArgsConstructor
public class HistoricoPedidoController implements HistoricoPedidoApi {
    @Override
    public ResponseEntity<HistoricoPedidoResponse> buscarPorId(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<Page<HistoricoPedidoResponse>> listar(HistoricoPedidoFilter filtro, Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<List<HistoricoPedidoResponse>> listarPorPedido(Integer pedidoId) {
        return null;
    }
}
