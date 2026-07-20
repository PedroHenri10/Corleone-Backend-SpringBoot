package com.corleone.exception;

import com.corleone.exceptionhandler.ErrorEnum;

public class CpfInvalidoException extends BaseException {
    public CpfInvalidoException(ErrorEnum errorEnum) {
        super(errorEnum);
    }
}
