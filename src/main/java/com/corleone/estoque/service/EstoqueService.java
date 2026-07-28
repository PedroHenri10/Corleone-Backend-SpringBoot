package com.corleone.estoque.service;

import com.corleone.estoque.dto.*;
import com.corleone.estoque.entity.Estoque;
import com.corleone.estoque.entity.EstoqueAtual;
import com.corleone.estoque.entity.EstoqueIngrediente;
import com.corleone.estoque.entity.MovimentoIngrediente;
import com.corleone.estoque.event.EstoqueBaixoEvent;
import com.corleone.estoque.mapper.EstoqueMapper;
import com.corleone.estoque.repository.EstoqueAtualRepository;
import com.corleone.estoque.repository.EstoqueIngredienteRepository;
import com.corleone.estoque.repository.EstoqueRepository;
import com.corleone.estoque.repository.MovimentoIngredienteRepository;
import com.corleone.estoque.specification.EstoqueSpecification;
import com.corleone.estoque.specification.MovimentoIngredienteSpecification;
import com.corleone.estoque.validator.EstoqueValidator;
import com.corleone.estoque.validator.MovimentoIngredienteValidator;
import com.corleone.exception.BusinessException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.funcionario.entity.Funcionario;
import com.corleone.ingrediente.entity.Ingrediente;
import com.corleone.produto.entity.Produto;
import com.corleone.shared.enums.TipoMovimentacao;
import com.corleone.shared.event.publisher.EventPublisher;
import com.corleone.shared.util.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;
    private final EstoqueAtualRepository estoqueAtualRepository;
    private final EstoqueMapper mapper;
    private final EstoqueValidator validator;
    private final MovimentoIngredienteRepository movimentoIngredienteRepository;
    private final MovimentoIngredienteValidator movimentoIngredienteValidator;
    private final EstoqueIngredienteRepository estoqueIngredienteRepository;
    private final EventPublisher eventPublisher;

    public EstoqueResponse entrada(EstoqueRequest request) {

        Produto produto = validator.validarProduto(request.getProdutoId());

        Funcionario funcionario = validator.validarFuncionario(request.getFuncionarioId());

        Estoque movimentacao = mapper.toEntity(request);

        movimentacao.setProduto(produto);
        movimentacao.setFuncionario(funcionario);
        movimentacao.setTipo(TipoMovimentacao.ENTRADA);
        movimentacao.setDataMovimentacao(LocalDateTime.now(DateUtils.BR_ZONE));

        movimentacao = estoqueRepository.save(movimentacao);

        EstoqueAtual estoqueAtual = validator.buscarOuCriarEstoqueAtual(produto);

        estoqueAtual.setProduto(produto);

        BigDecimal saldoAtual = estoqueAtual.getQuantidade() == null
                ? BigDecimal.ZERO
                : estoqueAtual.getQuantidade();

        estoqueAtual.setQuantidade(
                saldoAtual.add(request.getQuantidade())
        );

        estoqueAtual.setDataAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        estoqueAtualRepository.save(estoqueAtual);

        return mapper.toResponse(movimentacao);
    }

    public EstoqueResponse saida(EstoqueRequest request) {

        Produto produto = validator.validarProduto(request.getProdutoId());

        Funcionario funcionario = validator.validarFuncionario(request.getFuncionarioId());

        EstoqueAtual estoqueAtual = validator.buscarOuCriarEstoqueAtual(produto);

        BigDecimal saldoAtual = estoqueAtual.getQuantidade() == null
                ? BigDecimal.ZERO
                : estoqueAtual.getQuantidade();

        if (saldoAtual.compareTo(request.getQuantidade()) < 0) {
            throw new BusinessException(ErrorEnum.ESTOQUE_INSUFICIENTE);
        }

        Estoque movimentacao = mapper.toEntity(request);

        movimentacao.setProduto(produto);
        movimentacao.setFuncionario(funcionario);
        movimentacao.setTipo(TipoMovimentacao.SAIDA);
        movimentacao.setDataMovimentacao(LocalDateTime.now(DateUtils.BR_ZONE));

        movimentacao = estoqueRepository.save(movimentacao);

        estoqueAtual.setQuantidade(
                saldoAtual.subtract(request.getQuantidade())
        );

        estoqueAtual.setDataAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        estoqueAtualRepository.save(estoqueAtual);

        if (produto.getEstoqueMinimo() != null && estoqueAtual.getQuantidade().compareTo(produto.getEstoqueMinimo()) <= 0) {
            eventPublisher.publish(new EstoqueBaixoEvent(produto));
        }

        return mapper.toResponse(movimentacao);
    }

    public EstoqueResponse ajuste(EstoqueRequest request) {

        Produto produto = validator.validarProduto(request.getProdutoId());

        Funcionario funcionario = validator.validarFuncionario(request.getFuncionarioId());

        EstoqueAtual estoqueAtual = validator.buscarOuCriarEstoqueAtual(produto);

        Estoque movimentacao = mapper.toEntity(request);

        movimentacao.setProduto(produto);
        movimentacao.setFuncionario(funcionario);
        movimentacao.setTipo(TipoMovimentacao.AJUSTE);
        movimentacao.setDataMovimentacao(LocalDateTime.now(DateUtils.BR_ZONE));

        movimentacao = estoqueRepository.save(movimentacao);

        estoqueAtual.setQuantidade(request.getQuantidade());

        estoqueAtual.setDataAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        estoqueAtualRepository.save(estoqueAtual);

        return mapper.toResponse(movimentacao);
    }

    @Transactional(readOnly = true)
    public EstoqueResponse buscarPorId(Integer id) {

        Estoque estoque = validator.validarEstoque(id);

        return mapper.toResponse(estoque);
    }

    @Transactional(readOnly = true)
    public Page<EstoqueResumoResponse> listar(
            EstoqueFilter filter,
            Pageable pageable) {

        return estoqueRepository.findAll(
                        EstoqueSpecification.filtrar(filter),
                        pageable)
                .map(mapper::toResumoResponse);
    }

    @Transactional(readOnly = true)
    public Page<EstoqueAtualResponse> listarEstoqueAtual(Pageable pageable) {

        return estoqueAtualRepository.findAll(pageable)
                .map(mapper::toEstoqueAtualResponse);
    }

    public MovimentoIngredienteResponse entradaIngrediente(
            MovimentoIngredienteRequest request) {

        Ingrediente ingrediente = movimentoIngredienteValidator
                .validarIngrediente(request.getIngredienteId());

        Funcionario funcionario = movimentoIngredienteValidator
                .validarFuncionario(request.getFuncionarioId());

        MovimentoIngrediente movimento = mapper.toEntity(request);

        movimento.setIngrediente(ingrediente);
        movimento.setFuncionario(funcionario);
        movimento.setTipo(TipoMovimentacao.ENTRADA);
        movimento.setDataMovimentacao(LocalDateTime.now(DateUtils.BR_ZONE));

        movimento = movimentoIngredienteRepository.save(movimento);

        EstoqueIngrediente estoque = movimentoIngredienteValidator
                .buscarOuCriarEstoque(ingrediente);

        estoque.setIngrediente(ingrediente);

        BigDecimal saldoAtual = estoque.getQuantidade() == null
                ? BigDecimal.ZERO
                : estoque.getQuantidade();

        estoque.setQuantidade(
                saldoAtual.add(request.getQuantidade())
        );

        estoque.setDataAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        estoqueIngredienteRepository.save(estoque);

        return mapper.toResponse(movimento);
    }

    public MovimentoIngredienteResponse saidaIngrediente(
            MovimentoIngredienteRequest request) {

        Ingrediente ingrediente = movimentoIngredienteValidator
                .validarIngrediente(request.getIngredienteId());

        Funcionario funcionario = movimentoIngredienteValidator
                .validarFuncionario(request.getFuncionarioId());

        EstoqueIngrediente estoque = movimentoIngredienteValidator
                .buscarOuCriarEstoque(ingrediente);

        BigDecimal saldoAtual = estoque.getQuantidade() == null
                ? BigDecimal.ZERO
                : estoque.getQuantidade();

        if (saldoAtual.compareTo(request.getQuantidade()) < 0) {
            throw new BusinessException(ErrorEnum.ESTOQUE_INGREDIENTE_INSUFICIENTE);
        }

        MovimentoIngrediente movimento = mapper.toEntity(request);

        movimento.setIngrediente(ingrediente);
        movimento.setFuncionario(funcionario);
        movimento.setTipo(TipoMovimentacao.SAIDA);
        movimento.setDataMovimentacao(LocalDateTime.now(DateUtils.BR_ZONE));

        movimento = movimentoIngredienteRepository.save(movimento);

        estoque.setQuantidade(
                saldoAtual.subtract(request.getQuantidade())
        );

        estoque.setDataAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        estoqueIngredienteRepository.save(estoque);

        return mapper.toResponse(movimento);
    }

    public MovimentoIngredienteResponse ajusteIngrediente(
            MovimentoIngredienteRequest request) {

        Ingrediente ingrediente = movimentoIngredienteValidator
                .validarIngrediente(request.getIngredienteId());

        Funcionario funcionario = movimentoIngredienteValidator
                .validarFuncionario(request.getFuncionarioId());

        EstoqueIngrediente estoque = movimentoIngredienteValidator
                .buscarOuCriarEstoque(ingrediente);

        MovimentoIngrediente movimento = mapper.toEntity(request);

        movimento.setIngrediente(ingrediente);
        movimento.setFuncionario(funcionario);
        movimento.setTipo(TipoMovimentacao.AJUSTE);
        movimento.setDataMovimentacao(LocalDateTime.now(DateUtils.BR_ZONE));

        movimento = movimentoIngredienteRepository.save(movimento);

        estoque.setQuantidade(request.getQuantidade());
        estoque.setDataAtualizacao(LocalDateTime.now(DateUtils.BR_ZONE));

        estoqueIngredienteRepository.save(estoque);

        return mapper.toResponse(movimento);
    }

    @Transactional(readOnly = true)
    public MovimentoIngredienteResponse buscarMovimentoIngrediente(Integer id) {

        return mapper.toResponse(
                movimentoIngredienteValidator.validarMovimentacao(id));
    }

    @Transactional(readOnly = true)
    public Page<MovimentoIngredienteResumoResponse> listarMovimentosIngrediente(
            MovimentoIngredienteFilter filter,
            Pageable pageable) {

        return movimentoIngredienteRepository.findAll(
                        MovimentoIngredienteSpecification.filtrar(filter),
                        pageable)
                .map(mapper::toResumoResponse);
    }

    @Transactional(readOnly = true)
    public Page<EstoqueIngredienteResponse> listarEstoqueIngrediente(
            Pageable pageable) {

        return estoqueIngredienteRepository.findAll(pageable)
                .map(mapper::toEstoqueIngredienteResponse);
    }
}
