package com.corleone.exception;

import com.corleone.exceptionhandler.ErrorEnum;

public class EmailJaCadastradoException extends BaseException {
    public EmailJaCadastradoException(ErrorEnum errorEnum) {
        super(errorEnum);
    }
}
