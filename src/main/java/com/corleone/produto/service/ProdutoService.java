package com.corleone.produto.service;

import com.corleone.categoria.entity.Categoria;
import com.corleone.categoria.repository.CategoriaRepository;
import com.corleone.exception.BusinessException;
import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.fornecedor.entity.Fornecedor;
import com.corleone.fornecedor.repository.FornecedorRepository;
import com.corleone.ingrediente.entity.Ingrediente;
import com.corleone.ingrediente.repository.IngredienteRepository;
import com.corleone.produto.dto.*;
import com.corleone.produto.entity.*;
import com.corleone.produto.mapper.ProdutoMapper;
import com.corleone.produto.repository.*;
import com.corleone.produto.specification.ProdutoSpecification;
import com.corleone.produto.validator.ProdutoValidator;
import com.corleone.sabor.entity.Sabor;
import com.corleone.sabor.repository.SaborRepository;
import com.corleone.shared.util.DateUtils;
import com.corleone.tamanho.entity.Tamanho;
import com.corleone.tamanho.repository.TamanhoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProdutoService {

    private final ProdutoRepository repository;

    private final ProdutoMapper mapper;

    private final ProdutoValidator validator;

    private final CategoriaRepository categoriaRepository;

    private final FornecedorRepository fornecedorRepository;

    private final IngredienteRepository ingredienteRepository;

    private final SaborRepository saborRepository;

    private final TamanhoRepository tamanhoRepository;

    private final ProdutoIngredienteRepository produtoIngredienteRepository;

    private final ProdutoSaborRepository produtoSaborRepository;

    private final ProdutoTamanhoRepository produtoTamanhoRepository;

    public ProdutoResponse criar(ProdutoRequest request) {

    }

    public ProdutoResponse atualizar(Integer id, ProdutoRequest request) {

    }

    @Transactional(readOnly = true)
    public ProdutoResponse buscarPorId(Integer id) {

    }

    @Transactional(readOnly = true)
    public Page<ProdutoResumoResponse> listar(ProdutoFilter filtro, Pageable pageable) {

    }

    public void desativar(Integer id) {

    }

    private List<ProdutoSabor> montarSabores(Produto produto, ProdutoRequest request) {
        return request.getSabores()
                .stream()
                .map(item -> {

                    Sabor sabor = saborRepository.findById(item.getSaborId())
                            .orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.SABOR_NAO_ENCONTRADO));

                    validator.validarSaborAtivo(sabor);

                    return ProdutoSabor.builder()
                            .produto(produto)
                            .sabor(sabor)
                            .build();

                })
                .toList();
    }


    private List<ProdutoIngrediente> montarIngredientes(Produto produto, ProdutoRequest request) {
        return request.getIngredientes()
                .stream()
                .map(item -> {

                    Ingrediente ingrediente = ingredienteRepository.findById(item.getIngredienteId())
                            .orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.INGREDIENTE_NAO_ENCONTRADO));

                    validator.validarIngredienteAtivo(ingrediente);

                    return ProdutoIngrediente.builder()
                            .produto(produto)
                            .ingrediente(ingrediente)
                            .quantidade(item.getQuantidade())
                            .unidade(item.getUnidade())
                            .dataCriacao(LocalDateTime.now(DateUtils.BR_ZONE))
                            .build();

                })
                .toList();
    }

    private List<ProdutoTamanho> montarTamanhos(Produto produto, ProdutoRequest request) {
        return request.getTamanhos()
                .stream()
                .map(item -> {

                    Tamanho tamanho = tamanhoRepository.findById(item.getTamanhoId())
                            .orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.TAMANHO_NAO_ENCONTRADO));

                    validator.validarTamanhoAtivo(tamanho);

                    return ProdutoTamanho.builder()
                            .produto(produto)
                            .tamanho(tamanho)
                            .preco(item.getPreco())
                            .build();

                })
                .toList();
    }

    private void atualizarRelacionamentos(Produto produto, ProdutoRequest request) {

    }

}