package com.corleone.produto.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ProdutoResponse {
    private Integer id;

    private Integer fornecedorId;
    private String fornecedorNome;

    private Integer categoriaId;
    private String categoriaNome;

    private String codigo;
    private String nome;
    private String descricao;

    private BigDecimal precoCusto;
    private BigDecimal precoVenda;
    private BigDecimal estoqueMinimo;

    private Boolean ativo;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    private List<ProdutoSaborResponse> sabores;

    private List<ProdutoTamanhoResponse> tamanhos;

    private List<ProdutoIngredienteResponse> ingredientes;
}
