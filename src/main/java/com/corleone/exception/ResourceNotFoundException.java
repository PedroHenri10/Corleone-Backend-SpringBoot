package com.corleone.exception;


import com.corleone.exceptionhandler.ErrorEnum;

public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException(ErrorEnum errorEnum) {
        super(errorEnum);
    }
}
