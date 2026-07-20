package com.corleone.exception;

import com.corleone.exceptionhandler.ErrorEnum;

public class FuncionarioNaoEncontrado extends BaseException {
    public FuncionarioNaoEncontrado(ErrorEnum errorEnum) {
        super(errorEnum);
    }
}
