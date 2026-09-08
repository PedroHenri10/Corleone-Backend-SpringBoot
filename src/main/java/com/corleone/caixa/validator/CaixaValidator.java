package com.corleone.caixa.validator;

import com.corleone.caixa.entity.Caixa;
import com.corleone.caixa.repository.CaixaRepository;
import com.corleone.caixa.repository.LancamentoCaixaRepository;
import com.corleone.exception.BusinessException;
import com.corleone.exception.ResourceNotFoundException;
import com.corleone.exceptionhandler.ErrorEnum;
import com.corleone.funcionario.entity.Funcionario;
import com.corleone.funcionario.repository.FuncionarioRepository;
import com.corleone.shared.enums.StatusCaixa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CaixaValidator {
    private final CaixaRepository repository;
    private final FuncionarioRepository funcionarioRepository;
    private final LancamentoCaixaRepository lancamentoRepository;

    public Caixa validarCaixa(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.CAIXA_NAO_ENCONTRADO));
    }

    public Funcionario validarFuncionario(Integer id) {
        return funcionarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                                ErrorEnum.FUNCIONARIO_NAO_ENCONTRADO));
    }

    public void validarFuncionarioSemCaixaAberto(Integer funcionarioId) {
        if (repository.existsByFuncionarioIdAndStatus(funcionarioId, StatusCaixa.ABERTO)) {
            throw new BusinessException(ErrorEnum.CAIXA_JA_ABERTO);
        }
    }

    public void validarCaixaAberto(Caixa caixa) {
        if (!StatusCaixa.ABERTO.equals(caixa.getStatus())) {
            throw new BusinessException(ErrorEnum.CAIXA_NAO_ABERTO);
        }
    }
}
