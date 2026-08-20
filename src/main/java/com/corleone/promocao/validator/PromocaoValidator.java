package com.corleone.promocao.validator;

import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.produto.repository.ProdutoRepository;
import com.corleone.promocao.entity.Promocao;
import com.corleone.promocao.repository.PromocaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PromocaoValidator {

    private final PromocaoRepository repository;
    private final ProdutoRepository produtoRepository;

    public Promocao validarPromocao(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.PROMOCAO_NAO_ENCONTRADA));
    }

    
}
