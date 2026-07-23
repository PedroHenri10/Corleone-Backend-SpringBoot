package com.corleone.produto.validator;

import com.corleone.categoria.entity.Categoria;
import com.corleone.fornecedor.entity.Fornecedor;
import com.corleone.ingrediente.entity.Ingrediente;
import com.corleone.produto.entity.Produto;
import com.corleone.produto.repository.ProdutoRepository;
import com.corleone.sabor.entity.Sabor;
import com.corleone.tamanho.entity.Tamanho;
import com.corleone.exception.BusinessException;
import com.corleone.exceptionhandler.ErrorEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProdutoValidator {

    private final ProdutoRepository repository;

    public Produto validarProduto(Integer id) {

        return repository.findById(id).orElseThrow(() -> new BusinessException(ErrorEnum.PRODUTO_NAO_ENCONTRADO));

    }

    public void validarCodigoCadastro(String codigo) {

        if (repository.existsByCodigoIgnoreCase(codigo)) {
            throw new BusinessException(ErrorEnum.PRODUTO_JA_CADASTRADO);
        }

    }

    public void validarCodigoAtualizacao(Integer id, String codigo) {

        if (repository.existsByCodigoIgnoreCaseAndIdNot(codigo, id)) {
            throw new BusinessException(ErrorEnum.PRODUTO_JA_CADASTRADO);
        }

    }

    public void validarFornecedorAtivo(Fornecedor fornecedor) {

        if (Boolean.FALSE.equals(fornecedor.getForAtivo())) {
            throw new BusinessException(ErrorEnum.FORNECEDOR_INATIVO);
        }

    }

    public void validarCategoriaAtiva(Categoria categoria) {

        if (Boolean.FALSE.equals(categoria.getCatAtivo())) {
            throw new BusinessException(ErrorEnum.CATEGORIA_INATIVO);
        }

    }

    public void validarIngredienteAtivo(Ingrediente ingrediente) {

        if (Boolean.FALSE.equals(ingrediente.getAtivo())) {
            throw new BusinessException(ErrorEnum.INGREDIENTE_INATIVO);
        }

    }

    public void validarSaborAtivo(Sabor sabor) {

        if (Boolean.FALSE.equals(sabor.getAtivo())) {
            throw new BusinessException(ErrorEnum.SABOR_INATIVO);
        }

    }

    public void validarTamanhoAtivo(Tamanho tamanho) {

        if (Boolean.FALSE.equals(tamanho.getAtivo())) {
            throw new BusinessException(ErrorEnum.TAMANHO_INATIVO);
        }

    }

}