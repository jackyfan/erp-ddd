package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.candidate;

import com.jackyfan.ddd.core.domain.EmployeeId;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.TicketOwner;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.TicketOwnerType;

/**
 * 候选人
 */
public class Candidate {
    private TicketOwner owner;
    private EmployeeId employeeId;
    private String trainingId;
    private String name;
    private String email;
    /**
     * 候选人ID
     */
    private String candidateId;

    public Candidate(String candidateId, String name, String email, String trainingId) {
        this.candidateId = candidateId;
        this.name = name;
        this.email = email;
        this.trainingId = trainingId;
        this.employeeId = EmployeeId.of(candidateId);
        this.owner = new TicketOwner(employeeId, TicketOwnerType.Nominee);
    }

    public TicketOwner toOwner() {
        return owner;
    }

    public EmployeeId employeeId() {
        return employeeId;
    }
}
