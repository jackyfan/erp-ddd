package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.notification;


import com.jackyfan.ddd.core.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
public class MailTemplate {
    private String id;
    private String template;
    private TemplateType templateType;

    public MailTemplate(String template, TemplateType templateType) {
        this.id = UUID.randomUUID().toString();
        this.template = template;
        this.templateType = templateType;
    }

    public Notification compose(VariableContext context) {
        NotificationComposer notificationComposer = this.templateType.composer(template, context);
        return notificationComposer.compose();
    }
}