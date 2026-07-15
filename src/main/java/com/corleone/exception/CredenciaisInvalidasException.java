package com.corleone.exception;

import com.corleone.exceptionhandler.ErrorEnum;

public class CredenciaisInvalidasException extends BaseException {
    public CredenciaisInvalidasException(ErrorEnum errorEnum) {
        super(errorEnum);
    }
}
