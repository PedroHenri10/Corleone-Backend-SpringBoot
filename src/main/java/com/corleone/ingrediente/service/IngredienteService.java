package com.corleone.ingrediente.service;

import com.corleone.exception.BusinessException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.ingrediente.dto.*;
import com.corleone.ingrediente.entity.Ingrediente;
import com.corleone.ingrediente.mapper.IngredienteMapper;
import com.corleone.ingrediente.repository.IngredienteRepository;
import com.corleone.ingrediente.specification.IngredienteSpecification;
import com.corleone.ingrediente.validator.IngredienteValidator;
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
public class IngredienteService {

    private final IngredienteRepository repository;
    private final IngredienteMapper mapper;
    private final IngredienteValidator validator;

    public IngredienteResponse criar(IngredienteRequest request) {

        validator.validarNomeCadastro(request.getNome());

        Ingrediente ingrediente = mapper.toEntity(request);

        ingrediente.setAtivo(true);

        ingrediente.setDataCriacao(LocalDateTime.now(DateUtils.BR_ZONE));

        ingrediente = repository.save(ingrediente);

        return mapper.toResponse(ingrediente);
    }

    public IngredienteResponse atualizar(Integer id, IngredienteRequest request) {

        Ingrediente ingrediente = validator.validarIngrediente(id);

        validator.validarNomeAtualizacao(id, request.getNome());

        mapper.updateEntity(ingrediente, request);

        ingrediente.setDataAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        ingrediente = repository.save(ingrediente);

        return mapper.toResponse(ingrediente);
    }

    @Transactional(readOnly = true)
    public IngredienteResponse buscarPorId(Integer id) {

        return mapper.toResponse(validator.validarIngrediente(id));
    }

    @Transactional(readOnly = true)
    public Page<IngredienteResumoResponse> listar(IngredienteFilter filtro, Pageable pageable) {

        Specification<Ingrediente> specification = IngredienteSpecification.filtrar(filtro);

        return repository.findAll(specification, pageable).map(mapper::toResumoResponse);
    }

    public void desativar(Integer id) {

        Ingrediente ingrediente = validator.validarIngrediente(id);

        if (Boolean.FALSE.equals(ingrediente.getAtivo())) {
            throw new BusinessException(ErrorEnum.INGREDIENTE_INATIVO);
        }

        ingrediente.setAtivo(false);

        ingrediente.setDataAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        repository.save(ingrediente);
    }

}