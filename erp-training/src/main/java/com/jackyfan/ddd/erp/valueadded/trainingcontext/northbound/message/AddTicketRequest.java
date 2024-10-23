package com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.message;


import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.TicketId;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.training.TrainingId;

import java.io.Serializable;

// Request Message: DTO
public class AddTicketRequest implements Serializable {
    private String trainingId;


    public AddTicketRequest() {
    }

    public AddTicketRequest(String trainingId) {
        this.trainingId = trainingId;
    }

    public TicketId getTicketId() {
        return TicketId.next();
    }

    public TrainingId getTrainingId() {
        return TrainingId.from(this.trainingId);
    }

}