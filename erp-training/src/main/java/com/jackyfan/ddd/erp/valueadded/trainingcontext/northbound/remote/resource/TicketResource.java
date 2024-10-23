package com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.remote.resource;

import com.jackyfan.ddd.core.northbound.remote.resource.Resources;
import com.jackyfan.ddd.core.stereotype.Remote;
import com.jackyfan.ddd.core.stereotype.RemoteType;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.local.appservice.NominationAppService;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.message.NominatingCandidateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.logging.Logger;

@RestController
@RequestMapping("/tickets")
@Remote(RemoteType.Resource)
public class TicketResource {
    private Logger logger = Logger.getLogger(TicketResource.class.getName());

    @Autowired
    private NominationAppService nominationAppService;

    @PutMapping
    public ResponseEntity<?> nominate(@RequestBody NominatingCandidateRequest nominatingCandidateRequest) {
        return Resources.with("nominate ticket")
                .onSuccess(HttpStatus.ACCEPTED)
                .onError(HttpStatus.BAD_REQUEST)
                .onFailed(HttpStatus.INTERNAL_SERVER_ERROR)
                .execute(() -> nominationAppService.nominate(nominatingCandidateRequest));
    }
}