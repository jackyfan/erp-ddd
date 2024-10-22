package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket;

import com.jackyfan.ddd.core.stereotype.DomainService;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.candidate.Candidate;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.exception.TicketException;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.tickethistory.TicketHistory;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.repository.CandidateRepository;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.repository.TicketHistoryRepository;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@DomainService
public class TicketService {
    @Autowired
    private TicketRepository tickRepo;
    @Autowired
    private TicketHistoryRepository ticketHistoryRepo;
    @Autowired
    private CandidateRepository candidateRepo;

    public Ticket nominate(TicketId ticketId, Nominator nominator, Candidate candidate) {
        Optional<Ticket> optionalTicket = tickRepo.ticketOf(ticketId, TicketStatus.Available);
        Ticket ticket = optionalTicket.orElseThrow(() -> availableTicketNotFound(ticketId));

        TicketHistory ticketHistory = ticket.nominate(candidate, nominator);

        tickRepo.update(ticket);
        ticketHistoryRepo.add(ticketHistory);
        candidateRepo.remove(candidate);

        return ticket;
    }

    private TicketException availableTicketNotFound(TicketId ticketId) {
        return new TicketException(String.format("available ticket by id {%s} is not found.", ticketId));
    }

    public void setTicketRepository(TicketRepository tickRepo) {
        this.tickRepo = tickRepo;
    }

    public void setTicketHistoryRepository(TicketHistoryRepository ticketHistoryRepository) {
        this.ticketHistoryRepo = ticketHistoryRepository;
    }

    public void setCandidateRepository(CandidateRepository candidateRepository) {
        this.candidateRepo = candidateRepository;
    }
}