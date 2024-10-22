package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.notification;

public enum TemplateType {
    Nomination {
        public NotificationComposer composer(String template, VariableContext context) {
            return new NominationNotificationComposer(template, context);
        }
    };
    abstract NotificationComposer composer(String template, VariableContext context);
}