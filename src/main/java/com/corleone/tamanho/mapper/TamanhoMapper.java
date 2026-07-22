package com.corleone.tamanho.mapper;

import com.corleone.tamanho.dto.TamanhoRequest;
import com.corleone.tamanho.dto.TamanhoResponse;
import com.corleone.tamanho.dto.TamanhoResumoResponse;
import com.corleone.tamanho.entity.Tamanho;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TamanhoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "fatorPreco", source = "fatorPreco")
    Tamanho toEntity(TamanhoRequest request);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "fatorPreco", source = "fatorPreco")
    TamanhoResponse toResponse(Tamanho tamanho);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "fatorPreco", source = "fatorPreco")
    TamanhoResumoResponse toResumoResponse(Tamanho tamanho);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "fatorPreco", source = "fatorPreco")
    void updateEntity(@MappingTarget Tamanho tamanho, TamanhoRequest request);

}