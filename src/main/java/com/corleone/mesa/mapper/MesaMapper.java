package com.corleone.mesa.mapper;

import com.corleone.mesa.dto.MesaRequest;
import com.corleone.mesa.dto.MesaResponse;
import com.corleone.mesa.dto.MesaResumoResponse;
import com.corleone.mesa.entity.Mesa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MesaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "ativo", constant = "true")
    @Mapping(target = "status", constant = "LIVRE")
    /*Como o nome dos campos é igual (numero e capacidade), o MapStruct faz esse mapeamento automaticamente.
     Então essas duas linhas são desnecessárias.*/
    @Mapping(target = "numero", source = "request.numero")
    @Mapping(target = "capacidade", source = "request.capacidade")
    Mesa toEntity(MesaRequest request);


    MesaResponse toResponse(Mesa mesa);

    MesaResumoResponse toResumoResponse(Mesa mesa);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "status", ignore = true)
    void updateEntity(@MappingTarget Mesa mesa, MesaRequest request);
}
