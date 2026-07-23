package com.corleone.produto.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados para cadastro e atualização de um produto.")
public class ProdutoRequest {

    @NotNull
    @Schema(description = "Fornecedor", example = "1")
    private Integer fornecedorId;

    @NotNull
    @Schema(description = "Categoria", example = "2")
    private Integer categoriaId;

    @NotBlank
    @Size(max = 30)
    @Schema(description = "Código do produto", example = "PIZ001")
    private String codigo;

    @NotBlank
    @Size(max = 150)
    @Schema(description = "Nome", example = "Pizza Calabresa")
    private String nome;

    @Size(max = 1000)
    @Schema(description = "Descrição")
    private String descricao;

    @NotNull
    @DecimalMin("0.00")
    @Schema(example = "25.00")
    private BigDecimal precoCusto;

    @NotNull
    @DecimalMin("0.00")
    @Schema(example = "59.90")
    private BigDecimal precoVenda;

    @DecimalMin("0.00")
    @Schema(example = "5.000")
    private BigDecimal estoqueMinimo;

    @Valid
    @NotEmpty
    private List<ProdutoSaborRequest> sabores;

    @Valid
    @NotEmpty
    private List<ProdutoTamanhoRequest> tamanhos;

    @Valid
    private List<ProdutoIngredienteRequest> ingredientes;
}