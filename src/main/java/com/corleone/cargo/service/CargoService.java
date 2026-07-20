package com.corleone.cargo.service;

import com.corleone.cargo.dto.CargoRequest;
import com.corleone.cargo.dto.CargoResponse;
import com.corleone.cargo.entity.Cargo;
import com.corleone.cargo.mapper.CargoMapper;
import com.corleone.cargo.repository.CargoRepository;
import com.corleone.cargo.validator.CargoValidator;
import com.corleone.exception.BusinessException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.shared.util.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CargoService {

    private final CargoRepository repository;
    private final CargoMapper mapper;
    private final CargoValidator validator;

    @Transactional
    public CargoResponse criar(CargoRequest request) {

        validator.validarNomeCadastro(request.getNome());

        Cargo cargo = mapper.toEntity(request);

        cargo.setAtivo(true);
        cargo.setDataAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        cargo = repository.save(cargo);

        return mapper.toResponse(cargo);
    }

    @Transactional
    public CargoResponse atualizar(Integer id, CargoRequest request) {

        Cargo cargo = validator.validarCargo(id);

        validator.validarNomeAtualizacao(id, request.getNome());

        mapper.updateEntity(cargo, request);

        cargo.setDataAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        cargo = repository.save(cargo);

        return mapper.toResponse(cargo);
    }

    @Transactional(readOnly = true)
    public CargoResponse buscarPorId(Integer id) {

        return mapper.toResponse(validator.validarCargo(id));
    }

    @Transactional(readOnly = true)
    public List<CargoResponse> listar() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Transactional
    public void desativar(Integer id) {

        Cargo cargo = validator.validarCargo(id);

        if (Boolean.FALSE.equals(cargo.getAtivo())) {
            throw new BusinessException(ErrorEnum.CARGO_INATIVO);
        }

        cargo.setAtivo(false);
    }

}