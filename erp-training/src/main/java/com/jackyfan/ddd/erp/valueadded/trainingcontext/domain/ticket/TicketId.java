package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket;

import com.jackyfan.ddd.core.domain.AbstractIdentity;
import com.jackyfan.ddd.core.domain.UUIDIdentity;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.course.CourseId;

import java.util.UUID;

public class TicketId extends AbstractIdentity<String> {
    private String value;

    public TicketId(String value) {
        super(value);
    }

    public static TicketId next() {
        return new TicketId(UUID.randomUUID().toString());
    }

    public String id(){
        return value;
    }

    public static TicketId from(String value) {
        return new TicketId(value);
    }
}
