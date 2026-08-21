package com.corleone.promocao.service;

import com.corleone.promocao.dto.PromocaoFilter;
import com.corleone.promocao.dto.PromocaoRequest;
import com.corleone.promocao.dto.PromocaoResponse;
import com.corleone.promocao.dto.PromocaoResumoResponse;
import com.corleone.promocao.entity.Promocao;
import com.corleone.promocao.mapper.PromocaoMapper;
import com.corleone.promocao.repository.PromocaoRepository;
import com.corleone.promocao.specification.PromocaoSpecification;
import com.corleone.promocao.validator.PromocaoValidator;
import com.corleone.produto.entity.Produto;
import com.corleone.shared.util.DateUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PromocaoService {

    private final PromocaoRepository repository;
    private final PromocaoMapper mapper;
    private final PromocaoValidator validator;

   
}