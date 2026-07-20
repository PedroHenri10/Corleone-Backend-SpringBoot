package com.corleone.exception;

import com.corleone.exceptionhandler.ErrorEnum;

public class CpfJaCadastradoException extends BaseException {
    public CpfJaCadastradoException(ErrorEnum errorEnum) {
        super(errorEnum);
    }
}
