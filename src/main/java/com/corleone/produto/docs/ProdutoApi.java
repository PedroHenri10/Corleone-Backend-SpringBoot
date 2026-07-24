package com.corleone.produto.docs;

import com.corleone.produto.dto.ProdutoFilter;
import com.corleone.produto.dto.ProdutoRequest;
import com.corleone.produto.dto.ProdutoResponse;
import com.corleone.produto.dto.ProdutoResumoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@Tag(name = "Produto", description = "Gerenciamento de produtos da Corleone.")
public interface ProdutoApi {

    @Operation(summary = "Cadastrar produto", description = "Realiza o cadastro de um novo produto."
    )
    @ApiResponse(responseCode = "201", description = "Produto cadastrado com sucesso.", content = @Content(schema = @Schema(implementation = ProdutoResponse.class)))
    @ApiResponse(responseCode = "400", description = "Dados inválidos.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "403", description = "Sem permissão.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "404", description = "Categoria, fornecedor, ingrediente, sabor ou tamanho não encontrado.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "409", description = "Código do produto já cadastrado.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<ProdutoResponse> criar(@Parameter(description = "Dados do produto") ProdutoRequest request);

    @Operation(summary = "Buscar produto por ID", description = "Retorna um produto pelo identificador.")
    @ApiResponse(responseCode = "200", description = "Produto encontrado.", content = @Content(schema = @Schema(implementation = ProdutoResponse.class)))
    @ApiResponse(responseCode = "404", description = "Produto não encontrado.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<ProdutoResponse> buscarPorId(@Parameter(description = "ID do produto", example = "1") Integer id);

    @Operation(summary = "Listar produtos", description = "Lista os produtos cadastrados utilizando filtros.")
    @ApiResponse(responseCode = "200", description = "Produtos listados com sucesso.", content = @Content(array = @ArraySchema(
                    schema = @Schema(implementation = ProdutoResumoResponse.class))))
    ResponseEntity<Page<ProdutoResumoResponse>> listar(ProdutoFilter filtro, Pageable pageable);

    @Operation(summary = "Atualizar produto", description = "Atualiza os dados de um produto.")
    @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso.", content = @Content(schema = @Schema(implementation = ProdutoResponse.class)))
    @ApiResponse(responseCode = "400", description = "Dados inválidos.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "404", description = "Produto não encontrado.", content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "409", description = "Código já cadastrado.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<ProdutoResponse> atualizar(@Parameter(description = "ID do produto", example = "1") Integer id,
            @Parameter(description = "Dados do produto") ProdutoRequest request);

    @Operation(summary = "Desativar produto", description = "Realiza a exclusão lógica do produto.")
    @ApiResponse(responseCode = "204", description = "Produto desativado com sucesso.")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado.", content = @Content(schema = @Schema(hidden =true)))
    @ApiResponse(responseCode = "422", description = "Produto já está inativo.", content = @Content(schema = @Schema(hidden = true)))
    ResponseEntity<Void> desativar(@Parameter(description = "ID do produto", example = "1") Integer id);
}