package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket;

import com.jackyfan.ddd.core.domain.EmployeeId;

public class TicketOwner {
    private EmployeeId employeeId;
    private TicketOwnerType ticketOwnerType;

    public TicketOwner(EmployeeId employeeId, TicketOwnerType ticketOwnerType) {
        this.employeeId = employeeId;
        this.ticketOwnerType = ticketOwnerType;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketOwner that = (TicketOwner) o;
        return this.employeeId.equals(that.employeeId)&&this.ticketOwnerType.equals(that.ticketOwnerType);
    }
}
