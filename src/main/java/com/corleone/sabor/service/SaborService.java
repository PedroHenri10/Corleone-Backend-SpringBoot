package com.corleone.sabor.service;

import com.corleone.exception.BusinessException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.sabor.dto.*;
import com.corleone.sabor.entity.Sabor;
import com.corleone.sabor.mapper.SaborMapper;
import com.corleone.sabor.repository.SaborRepository;
import com.corleone.sabor.specification.SaborSpecification;
import com.corleone.sabor.validator.SaborValidator;
import com.corleone.shared.util.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SaborService {

    private final SaborRepository repository;
    private final SaborMapper mapper;
    private final SaborValidator validator;

    public SaborResponse criar(SaborRequest request) {

        validator.validarNomeCadastro(request.getNome());

        Sabor sabor = mapper.toEntity(request);

        sabor.setAtivo(true);

        sabor = repository.save(sabor);

        return mapper.toResponse(sabor);
    }

    public SaborResponse atualizar(Integer id, SaborRequest request) {

        Sabor sabor = validator.validarSabor(id);

        validator.validarNomeAtualizacao(id, request.getNome());

        mapper.updateEntity(sabor, request);

        sabor = repository.save(sabor);

        return mapper.toResponse(sabor);
    }

    @Transactional(readOnly = true)
    public SaborResponse buscarPorId(Integer id) {

        return mapper.toResponse(validator.validarSabor(id));
    }

    @Transactional(readOnly = true)
    public Page<SaborResumoResponse> listar(SaborFiltro filtro, Pageable pageable
    ) {
        Specification<Sabor> specification = montarSpecification(filtro);

        return repository.findAll(specification, pageable).map(mapper::toResumoResponse);
    }

    private Specification<Sabor> montarSpecification(SaborFiltro filtro) {
        if (filtro == null) {
            return Specification.where(SaborSpecification.somenteAtivos());
        }

        Specification<Sabor> spec = Specification.where(
                filtro.getAtivo() == null
                        ? SaborSpecification.somenteAtivos()
                        : SaborSpecification.ativo(filtro.getAtivo())
        );

        if (filtro.getNome() != null && !filtro.getNome().isBlank()) {
            spec = spec.and(SaborSpecification.nome(filtro.getNome()));
        }

        return spec;
    }

    public void desativar(Integer id) {

        Sabor sabor = validator.validarSabor(id);

        if (Boolean.FALSE.equals(sabor.getAtivo())) {
            throw new BusinessException(ErrorEnum.SABOR_INATIVO);
        }

        sabor.setAtivo(false);

        repository.save(sabor);
    }
}