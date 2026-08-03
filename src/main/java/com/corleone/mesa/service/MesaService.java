package com.corleone.mesa.service;

import com.corleone.mesa.dto.MesaRequest;
import com.corleone.mesa.dto.MesaResponse;
import com.corleone.mesa.entity.Mesa;
import com.corleone.mesa.mapper.MesaMapper;
import com.corleone.mesa.repository.MesaRepository;
import com.corleone.mesa.validator.MesaValidator;
import com.corleone.shared.util.DateUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class MesaService {
    private final MesaRepository repository;
    private final MesaMapper mapper;
    private final MesaValidator validator;

    public MesaResponse criar(MesaRequest request){
        validator.validarNumeroDuplicado(request.getNumero());

        Mesa mesa = mapper.toEntity(request);

        mesa.setDataCriacao(LocalDateTime.now(DateUtils.BR_ZONE));

        mesa = repository.save(mesa);

        return mapper.toResponse(mesa);
    }

    public MesaResponse atualizar(Integer id, MesaRequest request){
        Mesa mesa = validator.validarMesa(id);

        validator.validarMesaAtiva(mesa);

        validator.validarNumeroDuplicado(request.getNumero(), id);

        mapper.updateEntity(mesa, request);

        mesa = repository.save(mesa);

        return mapper.toResponse(mesa);
    }

    public MesaResponse buscarPorId(Integer id){
        Mesa mesa= validator.validarMesa(id);
        return mapper.toResponse(mesa);
    }

    
}
