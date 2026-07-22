package com.corleone.borda.service;

import com.corleone.borda.dto.BordaRequest;
import com.corleone.borda.dto.BordaResponse;
import com.corleone.borda.dto.BordaResumoResponse;
import com.corleone.borda.entity.Borda;
import com.corleone.borda.mapper.BordaMapper;
import com.corleone.borda.repository.BordaRepository;
import com.corleone.borda.validator.BordaValidator;
import com.corleone.exception.BusinessException;
import com.corleone.exceptionhandler.ErrorEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BordaService {

    private final BordaRepository repository;
    private final BordaMapper mapper;
    private final BordaValidator validator;

    public BordaResponse criar(BordaRequest request) {

        validator.validarNomeCadastro(request.getNome());

        Borda borda = mapper.toEntity(request);

        borda.setAtivo(true);

        borda = repository.save(borda);

        return mapper.toResponse(borda);
    }

    public BordaResponse atualizar(Integer id, BordaRequest request) {

        Borda borda = validator.validarBorda(id);

        validator.validarNomeAtualizacao(id, request.getNome());

        mapper.updateEntity(borda, request);

        borda = repository.save(borda);

        return mapper.toResponse(borda);
    }

    @Transactional(readOnly = true)
    public BordaResponse buscarPorId(Integer id) {

        return mapper.toResponse(validator.validarBorda(id));
    }

    @Transactional(readOnly = true)
    public List<BordaResumoResponse> listar() {

        return repository.findAll()
                .stream()
                .map(mapper::toResumoResponse)
                .toList();
    }

    public void desativar(Integer id) {

        Borda borda = validator.validarBorda(id);

        if (Boolean.FALSE.equals(borda.getAtivo())) {
            throw new BusinessException(ErrorEnum.BORDA_INATIVA);
        }

        borda.setAtivo(false);

        repository.save(borda);
    }

}