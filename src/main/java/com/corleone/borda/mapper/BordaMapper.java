package com.corleone.borda.mapper;

import com.corleone.borda.dto.*;
import com.corleone.borda.entity.Borda;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BordaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    Borda toEntity(BordaRequest request);

    BordaResponse toResponse(Borda borda);

    BordaResumoResponse toResumoResponse(Borda borda);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    void updateEntity(@MappingTarget Borda borda, BordaRequest request);

}