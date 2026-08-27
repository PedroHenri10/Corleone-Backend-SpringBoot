package com.corleone.pagamento.validator;

import com.corleone.exception.BusinessException;
import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.pagamento.entity.Pagamento;
import com.corleone.pagamento.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PagamentoValidator {
    private final PagamentoRepository repository;

    public Pagamento validarPagamento(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(ErrorEnum.PAGAMENTO_NAO_ENCONTRADO));
    }

    public void validarNomeDuplicado(String nome) {
        if (repository.existsByNomeIgnoreCase(nome)) {
            throw new BusinessException(ErrorEnum.PAGAMENTO_JA_CADASTRADO);
        }
    }
}
