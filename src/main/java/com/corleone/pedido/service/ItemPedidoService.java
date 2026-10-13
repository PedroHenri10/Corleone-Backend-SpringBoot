package com.corleone.pedido.service;

import com.corleone.pedido.dto.ItemPedidoFilter;
import com.corleone.pedido.dto.ItemPedidoRequest;
import com.corleone.pedido.dto.ItemPedidoResponse;
import com.corleone.pedido.dto.ItemPedidoResumoResponse;
import com.corleone.pedido.entity.ItemPedido;
import com.corleone.pedido.entity.Pedido;
import com.corleone.pedido.mapper.PedidoMapper;
import com.corleone.pedido.repository.ItemPedidoRepository;
import com.corleone.pedido.repository.PedidoRepository;
import com.corleone.pedido.specification.ItemPedidoSpecification;
import com.corleone.pedido.validator.ItemPedidoValidator;
import com.corleone.pedido.validator.PedidoValidator;
import com.corleone.shared.util.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemPedidoService {

    private final ItemPedidoRepository repository;
    private final PedidoRepository pedidoRepository;
    private final PedidoMapper mapper;
    private final ItemPedidoValidator validator;
    private final PedidoValidator pedidoValidator;

    public ItemPedidoResponse criar(Integer pedidoId, ItemPedidoRequest request) {
        Pedido pedido = pedidoValidator.validarPedido(pedidoId);
        pedidoValidator.validarPedidoEditavel(pedido);

        validator.validarQuantidade(request.getQuantidade());
        var produto = validator.validarProduto(request.getProdutoId());

        ItemPedido item = mapper.toItemEntity(request, produto);
        item.setPedido(pedido);

        BigDecimal precoUnitario = produto.getPrecoVenda();
        item.setPrecoUnitario(precoUnitario);
        item.setDesconto(BigDecimal.ZERO);
        item.setSubtotal(precoUnitario.multiply(request.getQuantidade()));

        item = repository.save(item);

        atualizarTotais(pedido);

        return mapper.toItemResponse(item);
    }

    public ItemPedidoResponse atualizar(Integer id, ItemPedidoRequest request) {
        ItemPedido item = validator.validarItemPedido(id);
        validator.validarQuantidade(request.getQuantidade());

        Pedido pedido = item.getPedido();
        pedidoValidator.validarPedidoEditavel(pedido);

        var produto = validator.validarProduto(request.getProdutoId());

        mapper.updateItemEntity(item, request, produto);

        BigDecimal precoUnitario = produto.getPrecoVenda();
        item.setPrecoUnitario(precoUnitario);
        item.setDesconto(BigDecimal.ZERO);
        item.setSubtotal(precoUnitario.multiply(request.getQuantidade()));

        item = repository.save(item);

        atualizarTotais(pedido);

        return mapper.toItemResponse(item);
    }

    @Transactional(readOnly = true)
    public ItemPedidoResponse buscarPorId(Integer id) {
        return mapper.toItemResponse(validator.validarItemPedido(id));
    }

    @Transactional(readOnly = true)
    public List<ItemPedidoResumoResponse> listar(ItemPedidoFilter filter) {
        return repository.findAll(ItemPedidoSpecification.filtro(filter))
                .stream()
                .map(mapper::toItemResumoResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<ItemPedidoResumoResponse> listarPorPedido(Integer pedidoId) {
        pedidoValidator.validarPedido(pedidoId);

        return repository.findByPedidoId(pedidoId)
                .stream()
                .map(mapper::toItemResumoResponse)
                .toList();
    }

    public void remover(Integer id) {
        ItemPedido item = validator.validarItemPedido(id);

        Pedido pedido = item.getPedido();
        pedidoValidator.validarPedidoEditavel(pedido);

        repository.delete(item);
        repository.flush();

        atualizarTotais(pedido);
    }

    private void atualizarTotais(Pedido pedido) {
        List<ItemPedido> itens = repository.findByPedidoId(pedido.getId());

        BigDecimal subtotal = itens.stream()
                .map(ItemPedido::getSubtotal)
                .filter(valor -> valor != null)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal desconto = pedido.getDesconto() != null
                ? pedido.getDesconto()
                : BigDecimal.ZERO;

        BigDecimal taxaEntrega = pedido.getTaxaEntrega() != null
                ? pedido.getTaxaEntrega()
                : BigDecimal.ZERO;

        BigDecimal total = subtotal.subtract(desconto).add(taxaEntrega);

        pedido.setSubtotal(subtotal);
        pedido.setTotal(total);
        pedido.setDataAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        pedidoRepository.save(pedido);
    }
}