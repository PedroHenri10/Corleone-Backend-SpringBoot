package com.corleone.pagamento.service;

import com.corleone.pagamento.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PagamentoService {
    private final PagamentoRepository repository;
    
}
