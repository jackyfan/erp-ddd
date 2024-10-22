package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.tickethistory;

import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.TicketStatus;

import java.util.Objects;

public class StateTransit {
    private TicketStatus from;
    private TicketStatus to;

    private StateTransit() {
    }

    public StateTransit(TicketStatus from, TicketStatus to) {
        this.from = from;
        this.to = to;
    }

    public static StateTransit from(TicketStatus from){
        return new StateTransit(from,null);
    }

    public StateTransit to(TicketStatus to){
        this.to = to;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateTransit that = (StateTransit) o;
        return this.from.equals(that.from) && this.to.equals(that.to);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.from, this.to);
    }
}
