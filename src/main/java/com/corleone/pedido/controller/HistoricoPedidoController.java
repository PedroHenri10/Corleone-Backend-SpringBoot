package com.corleone.pedido.controller;

import com.corleone.pedido.docs.HistoricoPedidoApi;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/historicos-pedido")
@RequiredArgsConstructor
public class HistoricoPedidoController implements HistoricoPedidoApi {
}
