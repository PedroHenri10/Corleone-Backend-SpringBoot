package com.corleone.produto.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Sabor associado ao produto.")
public class ProdutoSaborRequest {

    @NotNull
    @Schema(example = "1")
    private Integer saborId;

}
