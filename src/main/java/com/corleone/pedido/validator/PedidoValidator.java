package com.corleone.pedido.validator;

import com.corleone.cliente.entity.Cliente;
import com.corleone.cliente.repository.ClienteRepository;
import com.corleone.cupom.entity.Cupom;
import com.corleone.cupom.repository.CupomRepository;
import com.corleone.funcionario.entity.Funcionario;
import com.corleone.funcionario.repository.FuncionarioRepository;
import com.corleone.mesa.entity.Mesa;
import com.corleone.mesa.repository.MesaRepository;
import com.corleone.pagamento.entity.Pagamento;
import com.corleone.pagamento.repository.PagamentoRepository;
import com.corleone.pedido.entity.Pedido;
import com.corleone.pedido.repository.PedidoRepository;
import com.corleone.exception.BusinessException;
import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.shared.enums.StatusPedido;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedidoValidator {

    private final PedidoRepository repository;
    private final ClienteRepository clienteRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final MesaRepository mesaRepository;
    private final CupomRepository cupomRepository;
    private final PagamentoRepository pagamentoRepository;

    public Pedido validarPedido(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(ErrorEnum.PEDIDO_NAO_ENCONTRADO));
    }

    public Cliente validarCliente(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(ErrorEnum.CLIENTE_NAO_ENCONTRADO));
    }

    public Funcionario validarFuncionario(Integer id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(ErrorEnum.FUNCIONARIO_NAO_ENCONTRADO));
    }

    public Mesa validarMesa(Integer id) {
        return mesaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(ErrorEnum.MESA_NAO_ENCONTRADA));
    }

    public Cupom validarCupom(Integer id) {
        return cupomRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(ErrorEnum.CUPOM_NAO_ENCONTRADO));
    }

    public Pagamento validarPagamento(Integer id) {
        return pagamentoRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(ErrorEnum.PAGAMENTO_NAO_ENCONTRADO));
    }

    public void validarPedidoEditavel(Pedido pedido) {
        if (StatusPedido.FINALIZADO.equals(pedido.getStatus())
                || StatusPedido.CANCELADO.equals(pedido.getStatus())) {

            throw new BusinessException(ErrorEnum.PEDIDO_NAO_EDITAVEL);
        }
    }

    
}