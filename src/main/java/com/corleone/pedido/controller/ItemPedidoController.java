package com.corleone.pedido.controller;

import com.corleone.pedido.docs.ItemPedidoApi;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class ItemPedidoController implements ItemPedidoApi {
}
