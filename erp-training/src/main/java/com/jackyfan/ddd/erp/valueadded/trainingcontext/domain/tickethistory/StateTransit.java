package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.tickethistory;

import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.TicketOwner;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.TicketStatus;

public class StateTransit {
    private TicketStatus fromStatus;
    private TicketStatus toStatus;

    public StateTransit(TicketStatus toStatus, TicketStatus fromStatus) {
        this.toStatus = toStatus;
        this.fromStatus = fromStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateTransit that = (StateTransit) o;
        return this.fromStatus.equals(that.fromStatus) && this.toStatus.equals(that.toStatus);
    }
}
