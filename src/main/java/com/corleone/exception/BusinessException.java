package com.corleone.exception;

import com.corleone.exceptionhandler.ErrorEnum;

public class BusinessException extends BaseException {

    public BusinessException(ErrorEnum errorEnum) {
        super(errorEnum);
    }
}