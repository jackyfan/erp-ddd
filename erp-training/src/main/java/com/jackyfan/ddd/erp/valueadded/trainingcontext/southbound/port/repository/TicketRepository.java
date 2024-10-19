package com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.repository;

import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.Ticket;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.TicketId;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.TicketStatus;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Mapper
@Repository
public interface TicketRepository {
    void update(Ticket ticket);
    Optional<Ticket> ticketOf(TicketId ticketId, TicketStatus ticketStatus);
}
