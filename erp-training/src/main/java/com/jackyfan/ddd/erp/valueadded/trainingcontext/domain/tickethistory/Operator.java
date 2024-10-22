package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.tickethistory;

import com.jackyfan.ddd.core.domain.EmployeeId;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.TicketOwner;

import java.util.Objects;

/**
 * 操作人员
 */
public class Operator {
    private String operatorId;
    private String name;

    private Operator(String operatorId, String name) {
        this.operatorId = operatorId;
        this.name = name;
    }

    public static Operator of(String operatorId, String name) {
        return new Operator(operatorId, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator that = (Operator) o;
        return this.operatorId.equals(that.operatorId) && this.name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operatorId, name);
    }


}
