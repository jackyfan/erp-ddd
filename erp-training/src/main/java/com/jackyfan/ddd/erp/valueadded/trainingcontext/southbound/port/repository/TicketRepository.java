package com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.repository;

import com.jackyfan.ddd.core.stereotype.Port;
import com.jackyfan.ddd.core.stereotype.PortType;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.Ticket;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.TicketId;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.TicketStatus;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Mapper
@Repository
@Port(PortType.Repository)
public interface TicketRepository {
    int update(Ticket ticket);
    Optional<Ticket> Of(TicketId ticketId, TicketStatus ticketStatus);
}
