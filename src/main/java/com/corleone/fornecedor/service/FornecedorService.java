package com.corleone.fornecedor.service;

import com.corleone.endereco.entity.Endereco;
import com.corleone.exception.BusinessException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.fornecedor.dto.*;
import com.corleone.fornecedor.entity.Fornecedor;
import com.corleone.fornecedor.mapper.FornecedorMapper;
import com.corleone.fornecedor.repository.FornecedorRepository;
import com.corleone.fornecedor.specification.FornecedorSpecification;
import com.corleone.fornecedor.validator.FornecedorValidator;
import com.corleone.shared.util.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
@Transactional
public class FornecedorService {

    private final FornecedorRepository repository;
    private final FornecedorMapper mapper;
    private final FornecedorValidator validator;

    public FornecedorResponse criar(FornecedorRequest request) {

        request.setCnpj(request.getCnpj().replaceAll("\\D", ""));

        validator.validarCnpjCadastro(request.getCnpj());
        validator.validarEmailCadastro(request.getEmail());

        Endereco endereco = validator.validarEndereco(request.getEnderecoId());

        Fornecedor fornecedor = mapper.toEntity(request, endereco);

        fornecedor.setForAtivo(true);

        fornecedor = repository.save(fornecedor);

        return mapper.toResponse(fornecedor);
    }

    public FornecedorResponse atualizar(Integer id, FornecedorRequest request) {

        Fornecedor fornecedor = validator.validarFornecedor(id);

        request.setCnpj(request.getCnpj().replaceAll("\\D", ""));

        validator.validarCnpjAtualizacao(id, request.getCnpj());
        validator.validarEmailAtualizacao(id, request.getEmail());

        Endereco endereco = validator.validarEndereco(request.getEnderecoId());

        mapper.updateEntity(fornecedor, request, endereco);

        fornecedor.setForDtAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        fornecedor = repository.save(fornecedor);

        return mapper.toResponse(fornecedor);
    }

    @Transactional(readOnly = true)
    public FornecedorResponse buscarPorId(Integer id) {

        return mapper.toResponse(validator.validarFornecedor(id));
    }

    @Transactional(readOnly = true)
    public Page<FornecedorResumoResponse> listar(FornecedorFiltro filtro, Pageable pageable) {

        return repository.findAll(montarSpecification(filtro), pageable).map(mapper::toResumoResponse);
    }

    private Specification<Fornecedor> montarSpecification(FornecedorFiltro filtro) {

        return Specification
                .where(
                        filtro.getAtivo() == null
                                ? FornecedorSpecification.somenteAtivos()
                                : FornecedorSpecification.ativo(filtro.getAtivo())
                )
                .and(FornecedorSpecification.nome(filtro.getNome()))
                .and(FornecedorSpecification.cnpj(filtro.getCnpj()))
                .and(FornecedorSpecification.cidade(filtro.getCidade()));
    }

    public void desativar(Integer id) {

        Fornecedor fornecedor = validator.validarFornecedor(id);

        if (Boolean.FALSE.equals(fornecedor.getForAtivo())) {
            throw new BusinessException(ErrorEnum.FORNECEDOR_INATIVO);
        }

        fornecedor.setForAtivo(false);

        repository.save(fornecedor);
    }

}