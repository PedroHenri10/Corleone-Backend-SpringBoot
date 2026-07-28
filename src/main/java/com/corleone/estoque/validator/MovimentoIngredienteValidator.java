package com.corleone.estoque.validator;

import com.corleone.estoque.entity.EstoqueIngrediente;
import com.corleone.estoque.entity.MovimentoIngrediente;
import com.corleone.estoque.repository.EstoqueIngredienteRepository;
import com.corleone.estoque.repository.MovimentoIngredienteRepository;
import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.funcionario.entity.Funcionario;
import com.corleone.funcionario.validator.FuncionarioValidator;
import com.corleone.ingrediente.entity.Ingrediente;
import com.corleone.ingrediente.validator.IngredienteValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovimentoIngredienteValidator {

    private final IngredienteValidator ingredienteValidator;
    private final FuncionarioValidator funcionarioValidator;
    private final EstoqueIngredienteRepository estoqueIngredienteRepository;
    private final MovimentoIngredienteRepository movimentoIngredienteRepository;

    public Ingrediente validarIngrediente(Integer id) {
        return ingredienteValidator.validarIngrediente(id);
    }

    public Funcionario validarFuncionario(Integer id) {
        return funcionarioValidator.validarFuncionario(id);
    }

    public EstoqueIngrediente buscarOuCriarEstoque(Ingrediente ingrediente) {

        return estoqueIngredienteRepository.findByIngredienteId(ingrediente.getId())
                .orElse(EstoqueIngrediente.builder()
                                .ingrediente(ingrediente)
                                .quantidade(java.math.BigDecimal.ZERO)
                                .build()
                );
    }

    public MovimentoIngrediente validarMovimentacao(Integer id) {

        return movimentoIngredienteRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(ErrorEnum.MOVIMENTO_INGREDIENTE_NAO_ENCONTRADO));
    }

}