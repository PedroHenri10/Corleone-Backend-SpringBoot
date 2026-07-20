package com.corleone.cargo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados retornados de um cargo.")
public class CargoResponse {

    @Schema(description = "Identificador do cargo.", example = "1")
    private Integer id;

    @Schema(description = "Nome do cargo.", example = "Gerente")
    private String nome;

    @Schema(description = "Descrição do cargo.", example = "Responsável pela gestão da pizzaria.")
    private String descricao;

    @Schema(description = "Salário base.", example = "3500.00")
    private BigDecimal salarioBase;

    @Schema(description = "Indica se o cargo está ativo.", example = "true")
    private Boolean ativo;

    @Schema(description = "Data de criação do registro.")
    private LocalDateTime dataCriacao;

    @Schema(description = "Data da última atualização.")
    private LocalDateTime dataAtualizacao;

}