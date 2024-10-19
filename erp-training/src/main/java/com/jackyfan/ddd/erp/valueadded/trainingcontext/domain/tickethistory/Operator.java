package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.tickethistory;

import com.jackyfan.ddd.core.domain.EmployeeId;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.TicketOwner;

/**
 * 操作人员
 */
public class Operator {
    private EmployeeId employeeId;
    private String name;

    public Operator(EmployeeId employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator that = (Operator) o;
        return this.employeeId.equals(that.employeeId)&&this.name.equals(that.name);
    }
}
