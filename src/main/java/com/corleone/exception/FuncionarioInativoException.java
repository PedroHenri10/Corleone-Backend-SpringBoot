package com.corleone.exception;

import com.corleone.exceptionhandler.ErrorEnum;

public class FuncionarioInativoException extends BaseException {
    public FuncionarioInativoException(ErrorEnum errorEnum) {
        super(errorEnum);
    }
}
