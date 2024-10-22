package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.notification;


import com.jackyfan.ddd.core.exception.DomainException;

public class MailTemplateException extends DomainException {
    public MailTemplateException(String message) {
        super(message);
    }
}