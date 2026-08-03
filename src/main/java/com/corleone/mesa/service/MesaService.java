package com.corleone.mesa.service;

import com.corleone.exception.BusinessException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.mesa.dto.MesaFilter;
import com.corleone.mesa.dto.MesaRequest;
import com.corleone.mesa.dto.MesaResponse;
import com.corleone.mesa.dto.MesaResumoResponse;
import com.corleone.mesa.entity.Mesa;
import com.corleone.mesa.mapper.MesaMapper;
import com.corleone.mesa.repository.MesaRepository;
import com.corleone.mesa.specification.MesaSpecification;
import com.corleone.mesa.validator.MesaValidator;
import com.corleone.shared.enums.StatusMesa;
import com.corleone.shared.util.DateUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MesaService {

    private final MesaRepository repository;
    private final MesaMapper mapper;
    private final MesaValidator validator;

    public MesaResponse criar(MesaRequest request) {

        validator.validarNumeroDuplicado(request.getNumero());

        Mesa mesa = mapper.toEntity(request);

        mesa.setDataCriacao(LocalDateTime.now(DateUtils.BR_ZONE));

        mesa = repository.save(mesa);

        return mapper.toResponse(mesa);
    }

    public MesaResponse atualizar(Integer id, MesaRequest request) {

        Mesa mesa = validator.validarMesa(id);

        validator.validarMesaAtiva(mesa);

        validator.validarNumeroDuplicado(request.getNumero(), id);

        mapper.updateEntity(mesa, request);

        mesa = repository.save(mesa);

        return mapper.toResponse(mesa);
    }

    public MesaResponse buscarPorId(Integer id) {

        Mesa mesa = validator.validarMesa(id);

        return mapper.toResponse(mesa);
    }

    public List<MesaResumoResponse> listar(MesaFilter filter) {

        return repository.findAll(MesaSpecification.filtro(filter))
                .stream()
                .map(mapper::toResumoResponse)
                .toList();
    }

    public void inativar(Integer id) {

        Mesa mesa = validator.validarMesa(id);

        validator.validarMesaAtiva(mesa);

        if (Boolean.FALSE.equals(mesa.getAtivo())) {
            throw new BusinessException(ErrorEnum.MESA_INATIVA);
        }

        mesa.setAtivo(false);

        repository.save(mesa);
    }

    public MesaResponse abrirMesa(Integer id) {

        Mesa mesa = validator.validarMesa(id);

        validator.validarMesaAtiva(mesa);
        validator.validarMesaLivre(mesa);

        mesa.setStatus(StatusMesa.OCUPADA);

        mesa = repository.save(mesa);

        return mapper.toResponse(mesa);
    }

    public MesaResponse fecharMesa(Integer id) {

        Mesa mesa = validator.validarMesa(id);

        validator.validarMesaAtiva(mesa);
        validator.validarMesaOcupada(mesa);

        mesa.setStatus(StatusMesa.LIVRE);

        mesa = repository.save(mesa);

        return mapper.toResponse(mesa);
    }

    public MesaResponse reservarMesa(Integer id) {

        Mesa mesa = validator.validarMesa(id);

        validator.validarMesaAtiva(mesa);
        validator.validarMesaLivre(mesa);

        mesa.setStatus(StatusMesa.RESERVADA);

        mesa = repository.save(mesa);

        return mapper.toResponse(mesa);
    }

    public MesaResponse cancelarReserva(Integer id) {

        Mesa mesa = validator.validarMesa(id);

        validator.validarMesaAtiva(mesa);
        validator.validarMesaReservada(mesa);

        mesa.setStatus(StatusMesa.LIVRE);

        mesa = repository.save(mesa);

        return mapper.toResponse(mesa);
    }

}