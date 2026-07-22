package com.corleone.tamanho.service;

import com.corleone.exception.BusinessException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.tamanho.dto.TamanhoRequest;
import com.corleone.tamanho.dto.TamanhoResponse;
import com.corleone.tamanho.dto.TamanhoResumoResponse;
import com.corleone.tamanho.entity.Tamanho;
import com.corleone.tamanho.mapper.TamanhoMapper;
import com.corleone.tamanho.repository.TamanhoRepository;
import com.corleone.tamanho.validator.TamanhoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TamanhoService {

    private final TamanhoRepository repository;
    private final TamanhoMapper mapper;
    private final TamanhoValidator validator;

    public TamanhoResponse criar(TamanhoRequest request) {

        validator.validarNomeCadastro(request.getNome());

        Tamanho tamanho = mapper.toEntity(request);

        tamanho = repository.save(tamanho);

        return mapper.toResponse(tamanho);
    }

    public TamanhoResponse atualizar(Integer id, TamanhoRequest request) {

        Tamanho tamanho = validator.validarTamanho(id);

        validator.validarNomeAtualizacao(id, request.getNome());

        mapper.updateEntity(tamanho, request);

        tamanho = repository.save(tamanho);

        return mapper.toResponse(tamanho);
    }

    @Transactional(readOnly = true)
    public TamanhoResponse buscarPorId(Integer id) {

        return mapper.toResponse(validator.validarTamanho(id));
    }

    @Transactional(readOnly = true)
    public List<TamanhoResumoResponse> listar() {

        return repository.findAll()
                .stream()
                .map(mapper::toResumoResponse)
                .toList();
    }

    public void desativar(Integer id) {

        Tamanho tamanho = validator.validarTamanho(id);

        if (Boolean.FALSE.equals(tamanho.getAtivo())) {
            throw new BusinessException(ErrorEnum.TAMANHO_INATIVO);
        }

        tamanho.setAtivo(false);

        repository.delete(tamanho);
    }
}
