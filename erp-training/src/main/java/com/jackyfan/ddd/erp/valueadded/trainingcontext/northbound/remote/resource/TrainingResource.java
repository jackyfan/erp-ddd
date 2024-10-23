package com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.remote.resource;

import com.jackyfan.ddd.core.northbound.remote.resource.Resources;
import com.jackyfan.ddd.core.stereotype.Remote;
import com.jackyfan.ddd.core.stereotype.RemoteType;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.local.appservice.TrainingAppService;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.message.TrainingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.logging.Logger;

@RestController
@RequestMapping("/trainings")
@Remote(RemoteType.Resource)
public class TrainingResource {
    private Logger logger = Logger.getLogger(TrainingResource.class.getName());

    @Autowired
    private TrainingAppService trainingAppService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TrainingResponse> findBy(@PathVariable String id) {
        return Resources.with("find training by id")
                .onSuccess(HttpStatus.OK)
                .onError(HttpStatus.BAD_REQUEST)
                .onFailed(HttpStatus.NOT_FOUND)
                .execute(() -> trainingAppService.trainingOf(id));
    }
}