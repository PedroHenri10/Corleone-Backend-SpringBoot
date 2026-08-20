package com.corleone.promocao.validator;

import com.corleone.produto.repository.ProdutoRepository;
import com.corleone.promocao.repository.PromocaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PromocaoValidator {

    private final PromocaoRepository repository;
    private final ProdutoRepository produtoRepository;


}
