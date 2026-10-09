package com.corleone.pedido.service;

import com.corleone.pedido.dto.ItemPedidoFilter;
import com.corleone.pedido.dto.ItemPedidoRequest;
import com.corleone.pedido.dto.ItemPedidoResponse;
import com.corleone.pedido.dto.ItemPedidoResumoResponse;
import com.corleone.pedido.entity.ItemPedido;
import com.corleone.pedido.mapper.PedidoMapper;
import com.corleone.pedido.repository.ItemPedidoRepository;
import com.corleone.pedido.specification.ItemPedidoSpecification;
import com.corleone.pedido.validator.ItemPedidoValidator;
import com.corleone.pedido.validator.PedidoValidator;
import com.corleone.shared.util.DateUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemPedidoService {

    private final ItemPedidoRepository repository;
    private final PedidoMapper mapper;
    private final ItemPedidoValidator validator;
    private final PedidoValidator pedidoValidator;

    public ItemPedidoResponse criar(Integer pedidoId, ItemPedidoRequest request) {

        var pedido = pedidoValidator.validarPedido(pedidoId);
        pedidoValidator.validarPedidoEditavel(pedido);

        var produto = validator.validarProduto(request.getProdutoId());

        validator.validarQuantidade(request.getQuantidade());

        ItemPedido item = mapper.toItemEntity(request, produto);

        item.setPedido(pedido);

        BigDecimal precoUnitario = produto.getPrecoVenda();

        BigDecimal subtotal = precoUnitario.multiply(request.getQuantidade());

        item.setPrecoUnitario(precoUnitario);
        item.setDesconto(BigDecimal.ZERO);
        item.setSubtotal(subtotal);

        item = repository.save(item);

        pedido.setDataAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        return mapper.toItemResponse(item);
    }

    public ItemPedidoResponse atualizar(Integer id, ItemPedidoRequest request) {

        ItemPedido item = validator.validarItemPedido(id);

        validator.validarQuantidade(request.getQuantidade());

        var pedido = item.getPedido();

        pedidoValidator.validarPedidoEditavel(pedido);

        var produto = validator.validarProduto(request.getProdutoId());

        mapper.updateItemEntity(item, request, produto);

        BigDecimal precoUnitario = produto.getPrecoCusto();

        BigDecimal subtotal = precoUnitario
                .multiply(request.getQuantidade());

        item.setPrecoUnitario(precoUnitario);
        item.setDesconto(BigDecimal.ZERO);
        item.setSubtotal(subtotal);

        pedido.setDataAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        item = repository.save(item);

        return mapper.toItemResponse(item);
    }

    @Transactional(readOnly = true)
    public ItemPedidoResponse buscarPorId(Integer id) {

        ItemPedido item = validator.validarItemPedido(id);

        return mapper.toItemResponse(item);
    }

    @Transactional(readOnly = true)
    public List<ItemPedidoResumoResponse> listar(ItemPedidoFilter filter) {

        return repository.findAll(ItemPedidoSpecification.filtro(filter))
                .stream()
                .map(mapper::toItemResumoResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<ItemPedidoResumoResponse> listarPorPedido(Integer pedidoId
    ) {

        pedidoValidator.validarPedido(pedidoId);

        return repository.findByPedidoId(pedidoId)
                .stream()
                .map(mapper::toItemResumoResponse)
                .toList();
    }
}
