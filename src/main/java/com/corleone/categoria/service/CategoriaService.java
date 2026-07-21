package com.corleone.categoria.service;

import com.corleone.categoria.dto.CategoriaRequest;
import com.corleone.categoria.dto.CategoriaResponse;
import com.corleone.categoria.dto.CategoriaResumoResponse;
import com.corleone.categoria.entity.Categoria;
import com.corleone.categoria.mapper.CategoriaMapper;
import com.corleone.categoria.repository.CategoriaRepository;
import com.corleone.categoria.validator.CategoriaValidator;
import com.corleone.exception.BusinessException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.shared.util.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoriaService {

    private final CategoriaRepository repository;
    private final CategoriaMapper mapper;
    private final CategoriaValidator validator;

    public CategoriaResponse criar(CategoriaRequest request){
        validator.validarNomeCadastro(request.getNome());

        Categoria categoria = mapper.toEntity(request);

        categoria.setCatAtivo(true);

        categoria = repository.save(categoria);

        return mapper.toResponse(categoria);
    }

    public CategoriaResponse atualizar(Integer id, CategoriaRequest request){
        Categoria categoria = validator.validarCategoria(id);

        validator.validarNomeAtualizacao(id, request.getNome());

        mapper.updateEntity(categoria, request);

        categoria.setCatDtAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        categoria = repository.save(categoria);

        return mapper.toResponse(categoria);
    }

    @Transactional(readOnly = true)
    public CategoriaResponse buscarPorId(Integer id){
        return  mapper.toResponse(validator.validarCategoria(id));
    }

    @Transactional(readOnly = true)
    public List<CategoriaResumoResponse> listar(){
        return repository.findAll()
                .stream()
                .map(mapper::toResumoResponse)
                .toList();
    }

    public void desativar(Integer id){
        Categoria categoria = validator.validarCategoria(id);

        if(Boolean.FALSE.equals(categoria.getCatAtivo())){
            throw new BusinessException(ErrorEnum.CATEGORIA_INATIVO);
        }

        categoria.setCatAtivo(false);

        repository.save(categoria);
    }
}
