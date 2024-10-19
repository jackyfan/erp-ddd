package com.jackyfan.ddd.core.exception;

public class ApplicationValidationException extends ApplicationException{
    public ApplicationValidationException(String message, RuntimeException ex) {
        super(message, ex);
    }
}
