package com.corleone.estoque.validator;

import com.corleone.estoque.entity.EstoqueIngrediente;
import com.corleone.estoque.repository.EstoqueIngredienteRepository;
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

}