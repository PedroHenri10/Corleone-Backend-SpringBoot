package com.corleone.caixa.service;

import com.corleone.caixa.mapper.CaixaMapper;
import com.corleone.caixa.repository.CaixaRepository;
import com.corleone.caixa.validator.CaixaValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CaixaService {

    private final CaixaRepository repository;
    private final CaixaMapper mapper;
    private final CaixaValidator validator;

    
}
