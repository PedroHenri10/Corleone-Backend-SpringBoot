package com.corleone.cupom.service;

import com.corleone.cupom.dto.CupomFilter;
import com.corleone.cupom.dto.CupomRequest;
import com.corleone.cupom.dto.CupomResponse;
import com.corleone.cupom.dto.CupomResumoResponse;
import com.corleone.cupom.entity.Cupom;
import com.corleone.cupom.mapper.CupomMapper;
import com.corleone.cupom.repository.CupomRepository;
import com.corleone.cupom.specification.CupomSpecification;
import com.corleone.cupom.validator.CupomValidator;
import com.corleone.shared.util.DateUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CupomService {
    private final CupomRepository repository;
    private final CupomMapper mapper;
    private final CupomValidator validator;

    public CupomResponse criar(CupomRequest request) {

        validator.validarCodigoDuplicado(request.getCodigo());

        validator.validarPeriodo(request.getDataInicio(), request.getDataFim());

        validator.validarValorMinimo(request.getValorMinimo());

        Cupom cupom = mapper.toEntity(request);

        cupom.setDataCriacao(LocalDateTime.now(DateUtils.BR_ZONE));

        cupom = repository.save(cupom);

        return mapper.toResponse(cupom);
    }

    public CupomResponse CupomResponseAtualizar(Integer id, CupomRequest request) {

        Cupom cupom = validator.validarCupom(id);

        validator.validarCupomAtivo(cupom);

        validator.validarCodigoDuplicado(request.getCodigo(), id);

        validator.validarPeriodo(request.getDataInicio(), request.getDataFim());

        validator.validarValorMinimo(request.getValorMinimo());

        mapper.updateEntity(cupom, request);

        cupom = repository.save(cupom);

        return mapper.toResponse(cupom);
    }

    @Transactional
    public CupomResponse buscarPorId(Integer id) {

        Cupom cupom = validator.validarCupom(id);

        return mapper.toResponse(cupom);
    }

    @Transactional
    public List<CupomResumoResponse> listar(CupomFilter filter) {

        return repository.findAll(CupomSpecification.filtro(filter))
                .stream()
                .map(mapper::toResumoResponse)
                .toList();
    }

    public void desativar(Integer id) {

        Cupom cupom = validator.validarCupom(id);

        validator.validarCupomAtivo(cupom);

        cupom.setAtivo(false);

        repository.save(cupom);
    }
}
