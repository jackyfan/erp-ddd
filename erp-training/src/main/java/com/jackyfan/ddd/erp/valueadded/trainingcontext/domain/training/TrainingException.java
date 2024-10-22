package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.training;


import com.jackyfan.ddd.core.exception.DomainException;

public class TrainingException extends DomainException {

    public TrainingException(String message) {
        super(message);
    }
}