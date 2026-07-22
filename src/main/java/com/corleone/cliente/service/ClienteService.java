package com.corleone.cliente.service;

import com.corleone.cliente.dto.*;
import com.corleone.cliente.entity.Cliente;
import com.corleone.cliente.mapper.ClienteMapper;
import com.corleone.cliente.repository.ClienteRepository;
import com.corleone.cliente.specification.ClienteSpecification;
import com.corleone.cliente.validator.ClienteValidator;
import com.corleone.endereco.entity.Endereco;
import com.corleone.exception.BusinessException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.shared.util.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;
    private final ClienteValidator validator;

    public ClienteResponse criar(ClienteRequest request) {

        validator.validarEmailCadastro(request.getEmail());

        Endereco endereco = validator.validarEndereco(request.getEnderecoId());

        Cliente cliente = mapper.toEntity(request, endereco);

        cliente.setAtivo(true);

        cliente = repository.save(cliente);

        return mapper.toResponse(cliente);
    }

    public ClienteResponse atualizar(Integer id, ClienteRequest request) {

        Cliente cliente = validator.validarCliente(id);

        validator.validarEmailAtualizacao(id, request.getEmail());

        Endereco endereco = validator.validarEndereco(request.getEnderecoId());

        mapper.updateEntity(cliente, request, endereco);

        cliente.setDataAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        cliente = repository.save(cliente);

        return mapper.toResponse(cliente);
    }

    @Transactional(readOnly = true)
    public ClienteResponse buscarPorId(Integer id) {

        return mapper.toResponse(validator.validarCliente(id));
    }

    @Transactional(readOnly = true)
    public Page<ClienteResumoResponse> listar(ClienteFiltro filtro, Pageable pageable) {

        Specification<Cliente> specification = montarSpecification(filtro);

        return repository.findAll(specification, pageable).map(mapper::toResumoResponse);
    }

    @Transactional
    public void desativar(Integer id) {

        Cliente cliente = validator.validarCliente(id);

        if (Boolean.FALSE.equals(cliente.getAtivo())) {
            throw new BusinessException(ErrorEnum.CLIENTE_INATIVO);
        }

        cliente.setAtivo(false);

        repository.save(cliente);
    }

    private Specification<Cliente> montarSpecification(ClienteFiltro filtro) {

        return Specification
                .where(
                        filtro.getAtivo() == null
                                ? ClienteSpecification.somenteAtivos()
                                : ClienteSpecification.ativo(filtro.getAtivo())
                )
                .and(ClienteSpecification.nome(filtro.getNome()))
                .and(ClienteSpecification.telefone(filtro.getTelefone()))
                .and(ClienteSpecification.email(filtro.getEmail()))
                .and(ClienteSpecification.status(filtro.getStatus()))
                .and(ClienteSpecification.cidade(filtro.getCidade()));
    }

}