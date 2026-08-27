package com.corleone.pagamento.validator;

import com.corleone.pagamento.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PagamentoValidator {
    private final PagamentoRepository repository;

}
