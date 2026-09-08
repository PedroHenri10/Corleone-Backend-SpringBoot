package com.corleone.caixa.validator;

import com.corleone.caixa.repository.CaixaRepository;
import com.corleone.caixa.repository.LancamentoCaixaRepository;
import com.corleone.funcionario.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CaixaValidator {
    private final CaixaRepository repository;
    private final FuncionarioRepository funcionarioRepository;
    private final LancamentoCaixaRepository lancamentoRepository;

    
}
