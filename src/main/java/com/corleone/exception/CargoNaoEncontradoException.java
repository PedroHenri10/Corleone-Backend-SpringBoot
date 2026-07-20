package com.corleone.exception;

import com.corleone.exceptionhandler.ErrorEnum;

public class CargoNaoEncontradoException extends BaseException{
    public CargoNaoEncontradoException(ErrorEnum errorEnum) {
        super(errorEnum);
    }
}
