package com.corleone.cupom.validator;

import com.corleone.cupom.entity.Cupom;
import com.corleone.cupom.repository.CupomRepository;
import com.corleone.exception.BusinessException;
import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class CupomValidator {

    private final CupomRepository repository;

    public Cupom validarCupom(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.CUPOM_NAO_ENCONTRADO));
    }

    public void validarCodigoDuplicado(String codigo) {
        if (repository.existsByCodigo(codigo)) {
            throw new BusinessException(ErrorEnum.CUPOM_JA_CADASTRADO);
        }
    }

    public void validarCodigoDuplicado(String codigo, Integer id) {
        repository.findByCodigo(codigo)
                .filter(cupom -> !cupom.getId().equals(id))
                .ifPresent(cupom -> {
                    throw new BusinessException(ErrorEnum.CUPOM_JA_CADASTRADO);
                });
    }

    public void validarPeriodo(LocalDateTime dataInicio, LocalDateTime dataFim) {
        if (dataInicio != null && dataFim != null && dataFim.isBefore(dataInicio)) {
            throw new BusinessException(ErrorEnum.PERIODO_CUPOM_INVALIDO);
        }
    }

    public void validarValorMinimo(java.math.BigDecimal valorMinimo) {
        if (valorMinimo != null && valorMinimo.compareTo(java.math.BigDecimal.ZERO) <= 0) {
            throw new BusinessException(ErrorEnum.VALOR_MINIMO_CUPOM_INVALIDO);
        }
    }

    public void validarCupomAtivo(Cupom cupom) {
        if (!Boolean.TRUE.equals(cupom.getAtivo())) {
            throw new BusinessException(ErrorEnum.CUPOM_INATIVO);
        }
    }
}