package com.jackyfan.ddd.core.exception;

public class ApplicationException extends RuntimeException{
    public ApplicationException(String message,RuntimeException ex){
        super(message,ex);
    }
}
