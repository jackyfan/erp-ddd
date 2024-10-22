package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket;

import com.jackyfan.ddd.core.domain.EmployeeId;

import java.util.Objects;

public class TicketOwner {
    private String employeeId;
    private TicketOwnerType ownerType;

    public TicketOwner(String employeeId, TicketOwnerType ownerType) {
        this.employeeId = employeeId;
        this.ownerType = ownerType;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketOwner that = (TicketOwner) o;
        return this.employeeId.equals(that.employeeId)&&this.ownerType.equals(that.ownerType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, ownerType);
    }
}
