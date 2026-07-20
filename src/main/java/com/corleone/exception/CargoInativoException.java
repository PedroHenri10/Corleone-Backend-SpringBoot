package com.corleone.exception;

import com.corleone.exceptionhandler.ErrorEnum;

public class CargoInativoException extends BaseException {
    public CargoInativoException(ErrorEnum errorEnum) {
        super(errorEnum);
    }
}
