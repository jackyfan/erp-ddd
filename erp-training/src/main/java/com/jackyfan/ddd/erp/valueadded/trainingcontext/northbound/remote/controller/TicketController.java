package com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.remote.controller;

import com.jackyfan.ddd.core.northbound.remote.resource.Resources;
import com.jackyfan.ddd.core.stereotype.Remote;
import com.jackyfan.ddd.core.stereotype.RemoteType;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.local.appservice.NominationAppService;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.local.appservice.TicketAppService;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.message.AddTicketRequest;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.message.NominatingCandidateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/tickets")
@Remote(RemoteType.Controller)
public class TicketController {
    private Logger logger = Logger.getLogger(TicketController.class.getName());

    @Autowired
    private TicketAppService ticketAppService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody AddTicketRequest addTicketRequest) {
        return Resources.with("add ticket")
                .onSuccess(HttpStatus.ACCEPTED)
                .onError(HttpStatus.BAD_REQUEST)
                .onFailed(HttpStatus.INTERNAL_SERVER_ERROR)
                .execute(() -> ticketAppService.add(addTicketRequest));
    }
}