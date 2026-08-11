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

    
}