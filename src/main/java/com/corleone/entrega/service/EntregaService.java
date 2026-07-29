package com.corleone.entrega.service;

import com.corleone.endereco.entity.Endereco;
import com.corleone.entrega.dto.*;
import com.corleone.entrega.entity.Entrega;
import com.corleone.entrega.mapper.EntregaMapper;
import com.corleone.entrega.repository.EntregaRepository;
import com.corleone.entrega.specification.EntregaSpecification;
import com.corleone.entrega.validator.EntregaValidator;
import com.corleone.funcionario.entity.Funcionario;
import com.corleone.pedido.entity.Pedido;
import com.corleone.shared.enums.StatusEntrega;
import com.corleone.shared.util.DateUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EntregaService {

    private final EntregaRepository repository;
    private final EntregaMapper mapper;
    private final EntregaValidator validator;

    public EntregaResponse criar(EntregaRequest request) {

        validator.validarPedidoSemEntrega(request.getPedidoId());

        Pedido pedido = validator.validarPedido(request.getPedidoId());

        Funcionario entregador = validator.validarEntregador(request.getEntregadorId());

        Endereco endereco = validator.validarEndereco(request.getEnderecoId());

        Entrega entrega = mapper.toEntity(request);

        entrega.setPedido(pedido);
        entrega.setEntregador(entregador);
        entrega.setEndereco(endereco);
        entrega.setStatus(StatusEntrega.AGUARDANDO);

        entrega = repository.save(entrega);

        return mapper.toResponse(entrega);
    }

    public EntregaResponse atualizarStatus(Integer id, AtualizarStatusEntregaRequest request) {

        Entrega entrega = validator.validarEntrega(id);

        mapper.updateEntity(request, entrega);

        switch (request.getStatus()) {

            case SAIU -> {
                if (entrega.getDataSaida() == null) {entrega.setDataSaida(LocalDateTime.now(DateUtils.BR_ZONE));
                }

            }

            case ENTREGUE -> {
                if (entrega.getDataEntrega() == null) {entrega.setDataEntrega(LocalDateTime.now(DateUtils.BR_ZONE));
                }
            }
            default -> {
            }
        }

        entrega = repository.save(entrega);

        return mapper.toResponse(entrega);

    }

    public EntregaResponse buscarPorId(Integer id) {

        Entrega entrega = validator.validarEntrega(id);

        return mapper.toResponse(entrega);

    }

    public List<EntregaResumoResponse> listar(EntregaFilter filter) {

        return repository.findAll(EntregaSpecification.filtro(filter))
                .stream()
                .map(mapper::toResumoResponse)
                .toList();

    }

    public EntregaResponse iniciarEntrega(Integer id) {

        Entrega entrega = validator.validarEntrega(id);

        entrega.setStatus(StatusEntrega.SAIU);

        entrega.setDataSaida(LocalDateTime.now(DateUtils.BR_ZONE));

        entrega = repository.save(entrega);

        return mapper.toResponse(entrega);

    }

    public EntregaResponse finalizarEntrega(Integer id) {

        Entrega entrega = validator.validarEntrega(id);

        entrega.setStatus(StatusEntrega.ENTREGUE);

        entrega.setDataEntrega(LocalDateTime.now(DateUtils.BR_ZONE));

        entrega = repository.save(entrega);

        return mapper.toResponse(entrega);

    }

    public EntregaResponse cancelarEntrega(Integer id) {

        Entrega entrega = validator.validarEntrega(id);

        entrega.setStatus(StatusEntrega.CANCELADA);

        entrega = repository.save(entrega);

        return mapper.toResponse(entrega);

    }

}