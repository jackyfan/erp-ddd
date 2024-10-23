package com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.remote.controller;

import com.jackyfan.ddd.core.northbound.remote.resource.Resources;
import com.jackyfan.ddd.core.stereotype.Remote;
import com.jackyfan.ddd.core.stereotype.RemoteType;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.local.appservice.TrainingAppService;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.message.AddTrainingRequest;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.message.TrainingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/trainings")
@Remote(RemoteType.Controller)
public class TrainingController {
    private Logger logger = Logger.getLogger(TrainingController.class.getName());

    @Autowired
    private TrainingAppService trainingAppService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody AddTrainingRequest addTrainingRequest) {
        return Resources.with("add a training")
                .onSuccess(HttpStatus.OK)
                .onError(HttpStatus.BAD_REQUEST)
                .onFailed(HttpStatus.NOT_FOUND)
                .execute(() -> trainingAppService.addTraining(addTrainingRequest));
    }
}