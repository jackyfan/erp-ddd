package com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.local.appservice;

import com.jackyfan.ddd.core.exception.*;
import com.jackyfan.ddd.core.stereotype.Local;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.TicketService;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.message.AddTicketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@EnableTransactionManagement
@Local
public class TicketAppService {
    @Autowired
    private TicketService ticketService;

    @Transactional(rollbackFor = ApplicationException.class)
    public void add(AddTicketRequest addTicketRequest) {
        if (Objects.isNull(addTicketRequest)) {
            throw new ApplicationValidationException("add request can not be null");
        }
        try {
            ticketService.add(addTicketRequest.getTicketId(), addTicketRequest.getTrainingId());
        } catch (DomainException ex) {
            throw new ApplicationDomainException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new ApplicationInfrastructureException("Infrastructure Error", ex);
        }
    }
}