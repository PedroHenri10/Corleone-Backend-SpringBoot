package com.corleone.caixa.service;

import com.corleone.caixa.mapper.CaixaMapper;
import com.corleone.caixa.repository.LancamentoCaixaRepository;
import com.corleone.caixa.validator.CaixaValidator;
import com.corleone.funcionario.repository.FuncionarioRepository;
import com.corleone.pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LancamentoCaixaService {
    private final LancamentoCaixaRepository repository;
    private final CaixaValidator validator;
    private final CaixaMapper mapper;

    private final FuncionarioRepository funcionarioRepository;
    private final PedidoRepository pedidoRepository;
}
