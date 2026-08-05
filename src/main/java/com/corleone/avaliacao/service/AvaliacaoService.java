package com.corleone.avaliacao.service;

import com.corleone.avaliacao.dto.AvaliacaoFilter;
import com.corleone.avaliacao.dto.AvaliacaoRequest;
import com.corleone.avaliacao.dto.AvaliacaoResponse;
import com.corleone.avaliacao.dto.AvaliacaoResumoResponse;
import com.corleone.avaliacao.entity.Avaliacao;
import com.corleone.avaliacao.mapper.AvaliacaoMapper;
import com.corleone.avaliacao.repository.AvaliacaoRepository;
import com.corleone.avaliacao.specification.AvaliacaoSpecification;
import com.corleone.avaliacao.validator.AvaliacaoValidator;
import com.corleone.cliente.entity.Cliente;
import com.corleone.pedido.entity.Pedido;
import com.corleone.shared.util.DateUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AvaliacaoService {

    private final AvaliacaoRepository repository;
    private final AvaliacaoMapper mapper;
    private final AvaliacaoValidator validator;

    public AvaliacaoResponse criar(AvaliacaoRequest request) {

        validator.validarNota(request.getNota());

        validator.validarPedidoJaAvaliado(request.getPedidoId());

        Pedido pedido = validator.validarPedido(request.getPedidoId());

        Cliente cliente = validator.validarCliente(request.getClienteId());

        Avaliacao avaliacao = mapper.toEntity(request, pedido, cliente);

        avaliacao.setDataCriacao(LocalDateTime.now(DateUtils.BR_ZONE));

        avaliacao = repository.save(avaliacao);

        return mapper.toResponse(avaliacao);
    }

    public AvaliacaoResponse atualizar(Integer id, AvaliacaoRequest request) {

        Avaliacao avaliacao = validator.validarAvaliacao(id);

        validator.validarNota(request.getNota());

        Pedido pedido = validator.validarPedido(request.getPedidoId());

        Cliente cliente = validator.validarCliente(request.getClienteId());

        mapper.updateEntity(avaliacao, request, pedido, cliente);

        avaliacao = repository.save(avaliacao);

        return mapper.toResponse(avaliacao);
    }

    public AvaliacaoResponse buscarPorId(Integer id) {

        Avaliacao avaliacao = validator.validarAvaliacao(id);

        return mapper.toResponse(avaliacao);
    }

    public List<AvaliacaoResumoResponse> listar(AvaliacaoFilter filter) {

        return repository.findAll(AvaliacaoSpecification.filtro(filter))
                .stream()
                .map(mapper::toResumoResponse)
                .toList();
    }
    

}