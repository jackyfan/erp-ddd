package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket;

public enum  TicketStatus {
    Available("Available"),
    WaitForConfirm("WaitForConfirm");
    private final String status;

    TicketStatus(String status) {
        this.status = status;
    }

    public boolean isAvailable() {
        return this.status.equals("Available");
    }
}
