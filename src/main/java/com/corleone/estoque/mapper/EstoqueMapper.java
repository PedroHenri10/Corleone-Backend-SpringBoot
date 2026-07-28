package com.corleone.estoque.mapper;

import com.corleone.estoque.dto.*;
import com.corleone.estoque.entity.Estoque;
import com.corleone.estoque.entity.EstoqueAtual;
import com.corleone.estoque.entity.EstoqueIngrediente;
import com.corleone.estoque.entity.MovimentoIngrediente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EstoqueMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "produto", ignore = true)
    @Mapping(target = "funcionario", ignore = true)
    @Mapping(target = "dataMovimentacao", ignore = true)
    Estoque toEntity(EstoqueRequest request);

    @Mapping(target = "produtoId", source = "produto.id")
    @Mapping(target = "produto", source = "produto.nome")
    @Mapping(target = "funcionarioId", source = "funcionario.id")
    @Mapping(target = "funcionario", source = "funcionario.nome")
    EstoqueResponse toResponse(Estoque estoque);

    @Mapping(target = "produto", source = "produto.nome")
    EstoqueResumoResponse toResumoResponse(Estoque estoque);

    @Mapping(target = "produtoId", source = "produto.id")
    @Mapping(target = "produto", source = "produto.nome")
    EstoqueAtualResponse toEstoqueAtualResponse(EstoqueAtual estoqueAtual);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ingrediente", ignore = true)
    @Mapping(target = "funcionario", ignore = true)
    @Mapping(target = "dataMovimentacao", ignore = true)
    MovimentoIngrediente toEntity(MovimentoIngredienteRequest request);

    @Mapping(target = "ingredienteId", source = "ingrediente.id")
    @Mapping(target = "ingrediente", source = "ingrediente.nome")
    @Mapping(target = "funcionarioId", source = "funcionario.id")
    @Mapping(target = "funcionario", source = "funcionario.nome")
    MovimentoIngredienteResponse toResponse(MovimentoIngrediente movimento);

    @Mapping(target = "ingrediente", source = "ingrediente.nome")
    MovimentoIngredienteResumoResponse toResumoResponse(MovimentoIngrediente movimento);

    @Mapping(target = "ingredienteId", source = "ingrediente.id")
    @Mapping(target = "ingrediente", source = "ingrediente.nome")
    EstoqueIngredienteResponse toEstoqueIngredienteResponse(EstoqueIngrediente estoqueIngrediente);

}