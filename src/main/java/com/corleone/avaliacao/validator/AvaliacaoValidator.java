package com.corleone.avaliacao.validator;

import com.corleone.avaliacao.entity.Avaliacao;
import com.corleone.avaliacao.repository.AvaliacaoRepository;
import com.corleone.cliente.entity.Cliente;
import com.corleone.cliente.repository.ClienteRepository;
import com.corleone.exception.BusinessException;
import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.pedido.entity.Pedido;
import com.corleone.pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AvaliacaoValidator {

    private final AvaliacaoRepository repository;
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    public Avaliacao validarAvaliacao(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.AVALIACAO_NAO_ENCONTRADA));
    }

    public Pedido validarPedido(Integer id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.PEDIDO_NAO_ENCONTRADO));
    }

    public Cliente validarCliente(Integer id) {
        return clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.CLIENTE_NAO_ENCONTRADO));
    }

    public void validarNota(Integer nota) {

        if (nota == null || nota < 1 || nota > 5) {
            throw new BusinessException(ErrorEnum.NOTA_INVALIDA);
        }

    }

    public void validarPedidoJaAvaliado(Integer pedidoId) {

        if (repository.existsByPedidoId(pedidoId)) {
            throw new BusinessException(ErrorEnum.PEDIDO_JA_AVALIADO);
        }

    }
}