package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket;

import com.jackyfan.ddd.core.domain.EmployeeId;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.tickethistory.Operator;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.training.TrainingRole;

/**
 * 提名人
 */
public class Nominator {
    private Operator operator;
    private EmployeeId employeeId;
    private String name;
    private String nominatorId;
    private String email;
    private TrainingRole trainingRole;

    public Nominator(Operator operator, EmployeeId employeeId, String name) {
        this.operator = operator;
        this.employeeId = employeeId;
        this.name = name;
    }

    public Nominator(String nominatorId, String name, String email, TrainingRole trainingRole) {
        this.nominatorId = nominatorId;
        this.name = name;
        this.email = email;
        this.trainingRole = trainingRole;
    }

    public Operator toOperator() {
        return this.operator;
    }

    public EmployeeId employeeId() {
        return employeeId;
    }

    public String name() {
        return name;
    }

}
