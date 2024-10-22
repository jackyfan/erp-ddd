package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.candidate;

import com.jackyfan.ddd.core.domain.EmployeeId;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.Nominee;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.TicketOwner;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.TicketOwnerType;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.training.TrainingId;

import java.util.UUID;

/**
 * 候选人
 */
public class Candidate {
    private String id;
    private String employeeId;
    private String name;
    private String email;
    private TrainingId trainingId;

    public Candidate(String EmployeeId, String name, String email, TrainingId trainingId) {
        this.id = UUID.randomUUID().toString();
        this.employeeId = EmployeeId;
        this.name = name;
        this.email = email;
        this.trainingId = trainingId;
    }

    public String employeeId() {
        return employeeId;
    }

    public String name() {
        return this.name;
    }

    public String email() {
        return email;
    }

    public TrainingId trainingId() {
        return trainingId;
    }

    public TicketOwner toOwner() {
        return new TicketOwner(employeeId, TicketOwnerType.Nominee);
    }

    public Nominee toNominee() {
        return new Nominee(employeeId, name, email);
    }
}
