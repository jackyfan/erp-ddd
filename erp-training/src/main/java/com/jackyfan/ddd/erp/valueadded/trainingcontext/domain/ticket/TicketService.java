package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket;

import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.candidate.Candidate;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.exception.TicketException;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.tickethistory.TicketHistory;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.repository.CandidateRepository;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.repository.TicketHistoryRepository;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.repository.TicketRepository;

import java.util.Optional;
import java.util.function.Supplier;

public class TicketService {
    private TicketRepository tickRepo;
    private TicketHistoryRepository ticketHistoryRepo;
    private CandidateRepository candidateRepo;


    public void nominate(TicketId ticketId, Candidate candidate, Nominator nominator) {
        Optional<Ticket> optionalTicket = tickRepo.ticketOf(ticketId, TicketStatus.Available);
        if (optionalTicket.isEmpty()) {
            throw new TicketException(String.format("available ticket by id {%s} is not found.", ticketId));
        }
        Ticket ticket = optionalTicket.get();
        TicketHistory ticketHistory = ticket.nominate(candidate, nominator);
        tickRepo.update(ticket);
        ticketHistoryRepo.add(ticketHistory);
        candidateRepo.remove(candidate);
    }

//    private static void availableTicketNotFound(TicketId ticketId) throws TicketException{
//        throw new TicketException(String.format("available ticket by id {%s} is not found.", ticketId));
//    }

    public void setTicketHistoryRepository(TicketHistoryRepository ticketHistoryRepo) {
        this.ticketHistoryRepo = ticketHistoryRepo;
    }

    public void setCandidateRepository(CandidateRepository candidateRepo) {
        this.candidateRepo = candidateRepo;
    }

    public void setTicketRepository(TicketRepository tickRepo) {
        this.tickRepo = tickRepo;
    }

}
