package com.corleone.endereco.service;

import com.corleone.endereco.dto.EnderecoRequest;
import com.corleone.endereco.dto.EnderecoResponse;
import com.corleone.endereco.dto.EnderecoResumoResponse;
import com.corleone.endereco.entity.Endereco;
import com.corleone.endereco.mapper.EnderecoMapper;
import com.corleone.endereco.repository.EnderecoRepository;
import com.corleone.endereco.validator.EnderecoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final EnderecoMapper mapper;
    private final EnderecoValidator validator;

    @Transactional
    public EnderecoResponse criar(EnderecoRequest request) {

        Endereco endereco = mapper.toEntity(request);

        endereco = enderecoRepository.save(endereco);

        return mapper.toResponse(endereco);
    }

    @Transactional
    public EnderecoResponse atualizar(Integer id, EnderecoRequest request) {

        Endereco endereco = validator.validarEndereco(id);

        mapper.updateEntity(endereco, request);

        endereco = enderecoRepository.save(endereco);

        return mapper.toResponse(endereco);
    }

    @Transactional(readOnly = true)
    public EnderecoResponse buscarPorId(Integer id) {

        Endereco endereco = validator.validarEndereco(id);

        return mapper.toResponse(endereco);
    }

    @Transactional(readOnly = true)
    public List<EnderecoResumoResponse> listar() {

        return enderecoRepository.findAll()
                .stream()
                .map(mapper::toResumoResponse)
                .toList();
    }

    @Transactional
    public void excluir(Integer id) {

        Endereco endereco = validator.validarEndereco(id);

        enderecoRepository.delete(endereco);
    }

}