package com.corleone.cargo.mapper;

import com.corleone.cargo.dto.CargoRequest;
import com.corleone.cargo.dto.CargoResponse;
import com.corleone.cargo.entity.Cargo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CargoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", constant = "true")
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "dataAtualizacao", ignore = true)

    @Mapping(target = "nome", source = "request.nome")
    @Mapping(target = "descricao", source = "request.descricao")
    @Mapping(target = "salarioBase", source = "request.salarioBase")
    Cargo toEntity(CargoRequest request);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "descricao", source = "descricao")
    @Mapping(target = "salarioBase", source = "salarioBase")
    @Mapping(target = "ativo", source = "ativo")
    @Mapping(target = "dataCriacao", source = "dataCriacao")
    @Mapping(target = "dataAtualizacao", source = "dataAtualizacao")
    CargoResponse toResponse(Cargo cargo);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "dataAtualizacao", ignore = true)

    @Mapping(target = "nome", source = "request.nome")
    @Mapping(target = "descricao", source = "request.descricao")
    @Mapping(target = "salarioBase", source = "request.salarioBase")
    void updateEntity(@MappingTarget Cargo cargo, CargoRequest request);

}
