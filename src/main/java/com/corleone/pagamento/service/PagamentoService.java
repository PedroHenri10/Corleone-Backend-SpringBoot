package com.corleone.pagamento.service;

import com.corleone.pagamento.dto.PagamentoFilter;
import com.corleone.pagamento.dto.PagamentoRequest;
import com.corleone.pagamento.dto.PagamentoResponse;
import com.corleone.pagamento.dto.PagamentoResumoResponse;
import com.corleone.pagamento.entity.Pagamento;
import com.corleone.pagamento.mapper.PagamentoMapper;
import com.corleone.pagamento.repository.PagamentoRepository;
import com.corleone.pagamento.specification.PagamentoSpecification;
import com.corleone.pagamento.validator.PagamentoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PagamentoService {
    private final PagamentoRepository repository;
    private final PagamentoMapper mapper;
    private final PagamentoValidator validator;

    public PagamentoResponse criar(PagamentoRequest request) {

        validator.validarNomeDuplicado(request.getNome());

        Pagamento pagamento = mapper.toEntity(request);

        pagamento = repository.save(pagamento);

        return mapper.toResponse(pagamento);
    }

    public PagamentoResponse buscarPorId(Integer id) {

        Pagamento pagamento = validator.validarPagamento(id);

        return mapper.toResponse(pagamento);
    }

    public List<PagamentoResumoResponse> listar(PagamentoFilter filter) {

        return repository.findAll(PagamentoSpecification.filtro(filter))
                .stream()
                .map(mapper::toResumoResponse)
                .toList();
    }

    public PagamentoResponse atualizar(Integer id, PagamentoRequest request) {

        Pagamento pagamento = validator.validarPagamento(id);

        validator.validarPagamentoAtivo(pagamento);

        if (!pagamento.getNome().equalsIgnoreCase(request.getNome())) {
            validator.validarNomeDuplicado(request.getNome());
        }

        mapper.updateEntity(pagamento, request);

        pagamento = repository.save(pagamento);

        return mapper.toResponse(pagamento);
    }

    public PagamentoResponse ativar(Integer id) {

        Pagamento pagamento = validator.validarPagamento(id);

        pagamento.setAtivo(true);

        pagamento = repository.save(pagamento);

        return mapper.toResponse(pagamento);
    }

    public PagamentoResponse desativar(Integer id) {

        Pagamento pagamento = validator.validarPagamento(id);

        validator.validarPagamentoAtivo(pagamento);

        pagamento.setAtivo(false);

        pagamento = repository.save(pagamento);

        return mapper.toResponse(pagamento);
    }

    public void excluir(Integer id) {

        Pagamento pagamento = validator.validarPagamento(id);

        repository.delete(pagamento);
    }
}
