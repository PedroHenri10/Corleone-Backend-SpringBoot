package com.corleone.exception;

import com.corleone.exceptionhandler.ErrorEnum;

public class RegraNegocioException extends BaseException {
    public RegraNegocioException(ErrorEnum errorEnum) {
        super(errorEnum);
    }
}
