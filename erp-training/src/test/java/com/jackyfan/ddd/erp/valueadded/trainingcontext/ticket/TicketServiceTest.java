package com.jackyfan.ddd.erp.valueadded.trainingcontext.ticket;

import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.candidate.Candidate;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.exception.TicketException;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.*;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.tickethistory.TicketHistory;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.training.TrainingId;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.training.TrainingRole;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.repository.CandidateRepository;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.repository.TicketHistoryRepository;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.repository.TicketRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

public class TicketServiceTest {
    @Test
    public void should_throw_TicketException_if_available_ticket_not_found() {
        TicketId ticketId = TicketId.next();
        TicketRepository mockTickRepo = mock(TicketRepository.class);
        when(mockTickRepo.ticketOf(ticketId, TicketStatus.Available)).thenReturn(Optional.empty());
        TicketService ticketService = new TicketService();
        ticketService.setTicketRepository(mockTickRepo);
        TrainingId trainingId = TrainingId.from("111011111111");
        Candidate candidate = new Candidate("200901010110", "Tom", "tom@eas.com", trainingId);
        Nominator nominator = new Nominator("200901010007", "admin", "admin@eas.com",
                TrainingRole.Coordinator);
        assertThatThrownBy(() -> ticketService.nominate(ticketId, nominator, candidate))
                .isInstanceOf(TicketException.class)
                .hasMessageContaining(String.format("available ticket by id {%s} is not found", ticketId.id()));
        verify(mockTickRepo).ticketOf(ticketId, TicketStatus.Available);
    }

    @Test
    public void should_nominate_candidate_for_specific_ticket() {
        // given
        TrainingId trainingId = TrainingId.next();
        TicketId ticketId = TicketId.next();
        Ticket ticket = new Ticket(TicketId.next(), trainingId, TicketStatus.Available);
        TicketRepository mockTickRepo = mock(TicketRepository.class);
        when(mockTickRepo.ticketOf(ticketId, TicketStatus.Available)).thenReturn(Optional.of(ticket));
        TicketHistoryRepository mockTicketHistoryRepo = mock(TicketHistoryRepository.class);
        CandidateRepository mockCandidateRepo = mock(CandidateRepository.class);
        TicketService ticketService = new TicketService();
        ticketService.setTicketRepository(mockTickRepo);
        ticketService.setTicketHistoryRepository(mockTicketHistoryRepo);
        ticketService.setCandidateRepository(mockCandidateRepo);
        Candidate candidate = new Candidate("200901010110", "Tom", "tom@eas.com", trainingId);
        Nominator nominator = new Nominator("200901010007", "admin", "admin@eas.com", TrainingRole.Coordinator);
        // when
        ticketService.nominate(ticketId, nominator, candidate);
        // then
        verify(mockTickRepo).ticketOf(ticketId, TicketStatus.Available);
        verify(mockTickRepo).update(ticket);
        verify(mockTicketHistoryRepo).add(isA(TicketHistory.class));
        verify(mockCandidateRepo).remove(candidate);
    }
}
