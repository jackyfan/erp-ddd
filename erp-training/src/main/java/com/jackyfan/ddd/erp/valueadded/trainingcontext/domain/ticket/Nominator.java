package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket;

import com.jackyfan.ddd.core.domain.EmployeeId;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.tickethistory.Operator;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.training.TrainingRole;

/**
 * 提名人
 */
public class Nominator {
    private String employeeId;
    private String name;
    private String email;
    private TrainingRole role;

    public Nominator(String employeeId, String name, String email, TrainingRole role) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public Operator toOperator() {
        return Operator.of(employeeId(),name());
    }

    public String employeeId() {
        return employeeId;
    }

    public String name() {
        return name;
    }

}
