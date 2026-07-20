package com.corleone.exception;

import com.corleone.exceptionhandler.ErrorEnum;

public class EnderecoNaoEncontradoException extends BaseException {
    public EnderecoNaoEncontradoException(ErrorEnum errorEnum) {
        super(errorEnum);
    }
}
