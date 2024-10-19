package com.jackyfan.ddd.erp.valueadded.trainingcontext.ticket;

import com.jackyfan.ddd.core.domain.EmployeeId;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.candidate.Candidate;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.exception.TicketException;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.*;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.tickethistory.OperationType;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.tickethistory.Operator;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.tickethistory.StateTransit;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.tickethistory.TicketHistory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TicketTest {
    private String trainingId;
    private Candidate candidate;
    private Nominator nominator;
    private TicketHistory ticketHistory;

    @BeforeEach
    public void setUp() {
        trainingId = "111011111111";
        candidate = new Candidate("200901010110", "Tom", "tom@eas.com", trainingId);
        Operator operator = new Operator(EmployeeId.of("1111102"), "Andy");
        nominator = new Nominator(operator, EmployeeId.of("1111102"), "Andy");
    }

    @Test
    public void should_throw_TicketException_given_ticket_is_not_AVAILABLE() {
        Ticket ticket = new Ticket(TicketId.next(), trainingId, TicketStatus.WaitForConfirm);
        assertThatThrownBy(() -> ticket.nominate(candidate))
                .isInstanceOf(TicketException.class)
                .hasMessageContaining("ticket is not available");
    }

    @Test
    public void ticket_status_should_be_WAIT_FOR_CONFIRM_after_ticket_was_nominated() {
        Ticket ticket = new Ticket(TicketId.next(), trainingId, TicketStatus.Available);
        ticket.nominate(candidate);
        assertThat(ticket.status()).isEqualTo(TicketStatus.WaitForConfirm);
        assertThat(ticket.nomineeId()).isEqualTo(candidate.employeeId());
    }

    @Test
    public void should_generate_ticket_history_after_ticket_was_nominated() {
        Ticket ticket = new Ticket(TicketId.next(), trainingId, TicketStatus.Available);
        TicketHistory ticketHistory = ticket.nominate(candidate, nominator);
        assertTicketHistory(ticket, ticketHistory);
    }

    private void assertTicketHistory(Ticket ticket, TicketHistory ticketHistory) {
        assertThat(ticketHistory.ticketId()).isEqualTo(ticket.id());
        assertThat(ticketHistory.operationType()).isEqualTo(OperationType.Nomination);
        assertThat(ticketHistory.owner()).isEqualTo(new TicketOwner(candidate.employeeId(),
                TicketOwnerType.Nominee));
        assertThat(ticketHistory.stateTransit()).isEqualTo(new StateTransit(TicketStatus.
                Available, TicketStatus.WaitForConfirm));
        assertThat(ticketHistory.operatedBy()).isEqualTo(new Operator(nominator.employeeId(),
                nominator.name()));
        assertThat(ticketHistory.operatedAt()).isEqualToIgnoringSeconds(LocalDateTime.now());
    }
}
