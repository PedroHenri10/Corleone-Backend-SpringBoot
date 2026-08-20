package com.corleone.promocao.validator;

import com.corleone.exception.BusinessException;
import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.produto.entity.Produto;
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

    public Produto validarProduto(Integer id) {
        return produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.PRODUTO_NAO_ENCONTRADO));
    }

    public void validarProdutoJaPromocionado(Integer produtoId) {
        if (repository.existsByProdutoId(produtoId)) {
            throw new BusinessException(ErrorEnum.PRODUTO_JA_EM_PROMOCAO);
        }
    }

    public void validarProdutoJaPromocionado(Integer produtoId, Integer promocaoId) {

        repository.findById(promocaoId).filter(promocao ->
                        promocao.getProduto() != null && promocao.getProduto().getId().equals(produtoId))
                .ifPresent(promocao -> {throw new BusinessException(ErrorEnum.PRODUTO_JA_EM_PROMOCAO);
                });
    }

    

}
