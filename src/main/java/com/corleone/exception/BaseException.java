package com.corleone.exception;

import com.corleone.exceptionhandler.ErrorEnum;
import lombok.Getter;

@Getter
public abstract class BaseException extends RuntimeException {

    private final ErrorEnum errorEnum;

    protected BaseException(ErrorEnum errorEnum) {
        super(errorEnum.getErrorMessage());
        this.errorEnum = errorEnum;
    }
}