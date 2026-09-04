package com.corleone.caixa.mapper;

import com.corleone.caixa.dto.CaixaRequest;
import com.corleone.caixa.dto.CaixaResponse;
import com.corleone.caixa.dto.CaixaResumoResponse;
import com.corleone.caixa.entity.Caixa;
import com.corleone.funcionario.entity.Funcionario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CaixaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "funcionario", source = "funcionario")
    @Mapping(target = "dataAbertura", ignore = true)
    @Mapping(target = "dataFechamento", ignore = true)
    @Mapping(target = "valorFechamento", ignore = true)
    @Mapping(target = "valorSistema", ignore = true)
    @Mapping(target = "diferenca", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "lancamentos", ignore = true)
    Caixa toEntity(CaixaRequest request, Funcionario funcionario);

    @Mapping(target = "funcionarioId", source = "funcionario.id")
    @Mapping(target = "funcionario", source = "funcionario.nome")
    CaixaResponse toResponse(Caixa caixa);

    @Mapping(target = "funcionario", source = "funcionario.nome")
    CaixaResumoResponse toResumoResponse(Caixa caixa);

    
}
