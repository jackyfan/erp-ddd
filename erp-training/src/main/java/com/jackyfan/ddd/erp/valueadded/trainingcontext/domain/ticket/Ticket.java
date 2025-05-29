package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket;

import com.jackyfan.ddd.core.stereotype.Aggregate;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.candidate.Candidate;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.exception.TicketException;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.tickethistory.OperationType;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.tickethistory.StateTransit;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.tickethistory.TicketHistory;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.training.TrainingId;

import java.time.LocalDateTime;

@Aggregate
public class Ticket {
    private TicketId id;
    private TrainingId trainingId;
    private TicketStatus ticketStatus;
    private String nomineeId;
    private String url;


    public Ticket(TicketId id, TrainingId trainingId) {
        this(id, trainingId, TicketStatus.Available, null);
    }

    public Ticket(TicketId id, TrainingId trainingId, TicketStatus ticketStatus) {
        this(id, trainingId, ticketStatus, null);
    }

    public Ticket(TicketId id, TrainingId trainingId, TicketStatus ticketStatus, String nomineeId) {
        this.id = id;
        this.trainingId = trainingId;
        this.ticketStatus = ticketStatus;
        this.nomineeId = nomineeId;
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

    private void validateTicketStatus() {
        if (!ticketStatus.isAvailable()) {
            throw new TicketException("ticket is not available, cannot be nominated.");
        }
    }

    private void doNomination(Candidate candidate) {
        this.ticketStatus = TicketStatus.WaitForConfirm;
        this.nomineeId = candidate.employeeId();
    }

    private TicketHistory generateHistory(Candidate candidate, Nominator nominator) {
        return new TicketHistory(id,
                candidate.toOwner(),
                transitState(),
                OperationType.Nomination,
                nominator.toOperator(),
                LocalDateTime.now());
    }

    private StateTransit transitState() {
        return new StateTransit(TicketStatus.Available, ticketStatus);
    }

    public TicketStatus status() {
        return ticketStatus;
    }

    public String nomineeId() {
        return nomineeId;
    }

    public TicketId id() {
        return this.id;
    }

    public String url() {
        return this.url;
    }

    public TrainingId trainingId() {
        return this.trainingId;
    }

}
