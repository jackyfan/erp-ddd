package com.jackyfan.ddd.core.exception;

public class ApplicationInfrastructureException extends ApplicationException{
    public ApplicationInfrastructureException(String message, RuntimeException ex) {
        super(message, ex);
    }
}
