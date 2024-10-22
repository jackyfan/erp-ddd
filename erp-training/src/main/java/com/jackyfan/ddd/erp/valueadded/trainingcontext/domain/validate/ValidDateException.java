package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.validate;


import com.jackyfan.ddd.core.exception.DomainException;

public class ValidDateException extends DomainException {
    public ValidDateException(String message) {
        super(message);
    }
}