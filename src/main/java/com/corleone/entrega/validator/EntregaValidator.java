package com.corleone.entrega.validator;

import com.corleone.endereco.entity.Endereco;
import com.corleone.endereco.repository.EnderecoRepository;
import com.corleone.exception.BusinessException;
import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.funcionario.entity.Funcionario;
import com.corleone.funcionario.repository.FuncionarioRepository;
import com.corleone.pedido.entity.Pedido;
import com.corleone.pedido.repository.PedidoRepository;
import com.corleone.entrega.entity.Entrega;
import com.corleone.entrega.repository.EntregaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EntregaValidator {

    private final EntregaRepository entregaRepository;
    private final PedidoRepository pedidoRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final EnderecoRepository enderecoRepository;

    public Pedido validarPedido(Integer pedidoId) {

        return pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.PEDIDO_NAO_ENCONTRADO));

    }

    public Funcionario validarEntregador(Integer funcionarioId) {

        Funcionario funcionario = funcionarioRepository.findById(funcionarioId).orElseThrow(() ->
                        new ResourceNotFoundException(ErrorEnum.FUNCIONARIO_NAO_ENCONTRADO));

        if (Boolean.FALSE.equals(funcionario.getFunAtivo())) {
            throw new BusinessException(ErrorEnum.FUNCIONARIO_INATIVO);
        }

        return funcionario;

    }

    public Endereco validarEndereco(Integer enderecoId) {

        return enderecoRepository.findById(enderecoId).orElseThrow(() ->
                        new ResourceNotFoundException(ErrorEnum.ENDERECO_NAO_ENCONTRADO));

    }

    public Entrega validarEntrega(Integer id) {

        return entregaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.ENTREGA_NAO_ENCONTRADA));

    }

    public void validarPedidoSemEntrega(Integer pedidoId) {

        if (entregaRepository.findByPedidoId(pedidoId).isPresent()) {
            throw new BusinessException(ErrorEnum.PEDIDO_JA_POSSUI_ENTREGA);
        }

    }

}