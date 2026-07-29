package com.corleone.entrega.dto;

import com.corleone.shared.enums.StatusEntrega;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Atualização do status da entrega.")
public class AtualizarStatusEntregaRequest {

    @NotNull
    private StatusEntrega status;

}