package com.corleone.exception;

import com.corleone.exceptionhandler.ErrorEnum;

public class EmailInvalidoException extends BaseException {
    public EmailInvalidoException(ErrorEnum errorEnum) {
        super(errorEnum);
    }
}
