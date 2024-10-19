package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket;

import com.jackyfan.ddd.core.domain.UUIDIdentity;

import java.util.UUID;

public class TicketId {
    private String value;

    public TicketId(String value) {
        this.value = value;
    }

    public static TicketId next() {
        return new TicketId(UUID.randomUUID().toString());
    }

    public String id(){
        return value;
    }
}
