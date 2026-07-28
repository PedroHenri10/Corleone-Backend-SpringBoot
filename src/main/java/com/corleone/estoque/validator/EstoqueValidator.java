package com.corleone.estoque.validator;

import com.corleone.estoque.entity.Estoque;
import com.corleone.estoque.entity.EstoqueAtual;
import com.corleone.estoque.repository.EstoqueAtualRepository;
import com.corleone.estoque.repository.EstoqueRepository;
import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.funcionario.entity.Funcionario;
import com.corleone.funcionario.validator.FuncionarioValidator;
import com.corleone.produto.entity.Produto;
import com.corleone.produto.validator.ProdutoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EstoqueValidator {

    private final ProdutoValidator produtoValidator;
    private final FuncionarioValidator funcionarioValidator;
    private final EstoqueAtualRepository estoqueAtualRepository;
    private final EstoqueRepository estoqueRepository;

    public Produto validarProduto(Integer id) {
        return produtoValidator.validarProduto(id);
    }

    public Funcionario validarFuncionario(Integer id) {
        return funcionarioValidator.validarFuncionario(id);
    }

    public EstoqueAtual buscarOuCriarEstoqueAtual(Produto produto) {

        return estoqueAtualRepository.findByProdutoId(produto.getId())
                .orElse(EstoqueAtual.builder()
                                .produto(produto)
                                .quantidade(java.math.BigDecimal.ZERO)
                                .build()
                );
    }

    public Estoque validarEstoque(Integer id) {
        return estoqueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.ESTOQUE_NAO_ENCONTRADO));
    }

}