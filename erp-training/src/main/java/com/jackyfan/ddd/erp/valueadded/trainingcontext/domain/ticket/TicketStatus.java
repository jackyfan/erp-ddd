package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket;

public enum TicketStatus {
    Available,
    WaitForConfirm;

    public boolean isAvailable() {
        return this == Available;
    }
}
