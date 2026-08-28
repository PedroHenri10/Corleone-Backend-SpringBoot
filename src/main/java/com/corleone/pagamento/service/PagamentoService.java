package com.corleone.pagamento.service;

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

    
}
