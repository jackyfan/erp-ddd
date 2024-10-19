package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket;

import com.jackyfan.ddd.core.domain.EmployeeId;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.candidate.Candidate;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.exception.TicketException;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.tickethistory.OperationType;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.tickethistory.StateTransit;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.tickethistory.TicketHistory;

import java.time.LocalDateTime;

public class Ticket {
    private TicketId ticketId;
    private String trainingId;
    private TicketStatus ticketStatus;
    /**
     *被提名者
     */
    private EmployeeId nomineeId;

    public Ticket(TicketId ticketId, String trainingId, TicketStatus ticketStatus) {
        this.ticketId = ticketId;
        this.trainingId = trainingId;
        this.ticketStatus = ticketStatus;
    }
    public Ticket(TicketId ticketId, String trainingId) {
        this.ticketId = ticketId;
        this.trainingId = trainingId;
    }

    public void nominate(Candidate candidate) {
        if (!ticketStatus.isAvailable()) {
            throw new TicketException("ticket is not available, cannot be nominated.");
        }
        this.ticketStatus = TicketStatus.WaitForConfirm;
        this.nomineeId = candidate.employeeId();
    }
    public TicketHistory nominate(Candidate candidate, Nominator nominator) {
        validateTicketStatus();
        doNomination(candidate);
        return generateHistory(candidate, nominator);
    }

    private void validateTicketStatus(){
        if (!ticketStatus.isAvailable()) {
            throw new TicketException("ticket is not available, cannot be nominated.");
        }
    }
    private void doNomination(Candidate candidate){
        this.ticketStatus = TicketStatus.WaitForConfirm;
        this.nomineeId = candidate.employeeId();
    }

    private TicketHistory generateHistory(Candidate candidate, Nominator nominator){
        return new TicketHistory(ticketId,
                candidate.toOwner(),
                transitState(),
                OperationType.Nomination,
                nominator.toOperator(),
                LocalDateTime.now());
    }

    private StateTransit transitState() {
        return new StateTransit(TicketStatus.Available,ticketStatus);
    }

    public TicketStatus status(){
        return ticketStatus;
    }

    public EmployeeId nomineeId(){
        return nomineeId;
    }

    public TicketId id(){
        return this.ticketId;
    }

}
