package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.notification;

import java.util.List;
import org.antlr.stringtemplate.StringTemplate;

public abstract class NotificationComposer {
    private static final char BEGIN_VARIABLE = '$';
    private static final char END_VARIABLE = '$';
    protected String template;

    public NotificationComposer(String template, VariableContext context) {
        this.template = template;
        setup(context);
    }

    protected void setup(VariableContext context) {}

    public Notification compose() {
        String from = renderFrom();
        String to = renderTo();
        String subject = renderSubject();
        String body = renderBody();
        return new Notification(from, to, subject, body);
    }

    protected abstract String renderFrom();

    protected abstract String renderSubject();

    protected abstract String renderTo();

    private String renderBody() {
        List<TemplateVariable> variables = registerVariables();
        StringTemplate st = new StringTemplate(template);
        for (TemplateVariable variable : variables) {
            st.setAttribute(variable.name(), variable, variable.value());
        }
        return st.toString();
    }

    protected abstract List<TemplateVariable> registerVariables();
}