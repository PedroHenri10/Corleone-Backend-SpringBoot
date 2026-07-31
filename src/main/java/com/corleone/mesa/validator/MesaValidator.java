package com.corleone.mesa.validator;

import com.corleone.exception.BusinessException;
import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.mesa.entity.Mesa;
import com.corleone.mesa.repository.MesaRepository;
import com.corleone.shared.enums.StatusMesa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MesaValidator {
    private final MesaRepository repository;

    public Mesa validarMesa(Integer id){
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.MESA_NAO_ENCONTRADA));
    }

    public void validarNumeroDuplicado(Integer numero){
        if(repository.existsByNumero(numero)){
            throw new BusinessException(ErrorEnum.MESA_JA_CADASTRADA);
        }
    }

    public void validarNumeroDuplicado(Integer numero, Integer id) {
        if (repository.existsByNumeroAndIdNot(numero, id)) {
            throw new BusinessException(ErrorEnum.MESA_JA_CADASTRADA);
        }
    }

    public void validarMesaAtiva(Mesa mesa) {
        if (Boolean.FALSE.equals(mesa.getAtivo())) {
            throw new BusinessException(ErrorEnum.MESA_INATIVA);
        }
    }

    public void validarMesaLivre(Mesa mesa) {
        if (mesa.getStatus() != StatusMesa.LIVRE) {
            throw new BusinessException(ErrorEnum.MESA_NAO_DISPONIVEL);
        }
    }

    public void validarMesaOcupada(Mesa mesa) {
        if (mesa.getStatus() != StatusMesa.OCUPADA) {
            throw new BusinessException(ErrorEnum.MESA_NAO_OCUPADA);
        }
    }

    public void validarMesaReservada(Mesa mesa) {
        if (mesa.getStatus() != StatusMesa.RESERVADA) {
            throw new BusinessException(ErrorEnum.MESA_NAO_RESERVADA);
        }

    }
