package com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.repository;

import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.TicketId;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.tickethistory.TicketHistory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Mapper
@Repository
public interface TicketHistoryRepository {
    Optional<TicketHistory> latest(TicketId ticketId);
    void add(TicketHistory ticketHistory);
    void deleteBy(TicketId ticketId);
}
