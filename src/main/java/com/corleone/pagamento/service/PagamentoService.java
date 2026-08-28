package com.corleone.pagamento.service;

import com.corleone.pagamento.dto.PagamentoRequest;
import com.corleone.pagamento.dto.PagamentoResponse;
import com.corleone.pagamento.entity.Pagamento;
import com.corleone.pagamento.mapper.PagamentoMapper;
import com.corleone.pagamento.repository.PagamentoRepository;
import com.corleone.pagamento.validator.PagamentoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
