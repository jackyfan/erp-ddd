package com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.repository;

import com.jackyfan.ddd.core.stereotype.Port;
import com.jackyfan.ddd.core.stereotype.PortType;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.TicketId;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.tickethistory.TicketHistory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Mapper
@Repository
@Port(PortType.Repository)
public interface TicketHistoryRepository {
    Optional<TicketHistory> latest(TicketId ticketId);
    int add(TicketHistory ticketHistory);
    int deleteBy(TicketId ticketId);
}
