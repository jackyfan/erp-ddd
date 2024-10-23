package com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.local.appservice;

import com.jackyfan.ddd.core.exception.ApplicationDomainException;
import com.jackyfan.ddd.core.exception.ApplicationInfrastructureException;
import com.jackyfan.ddd.core.exception.ApplicationValidationException;
import com.jackyfan.ddd.core.exception.DomainException;
import com.jackyfan.ddd.core.stereotype.Local;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.course.CourseId;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.training.Training;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.training.TrainingId;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.training.TrainingService;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.message.AddTrainingRequest;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.message.TrainingResponse;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Objects;

@Service
@Local
public class TrainingAppService {
    @Autowired
    private TrainingService trainingService;

    public TrainingResponse trainingOf(String trainingId) {
        if (Strings.isBlank(trainingId)) {
            throw new ApplicationValidationException("TrainingId can not be null or empty");
        }
        try {
            Training training = trainingService.trainingOf(TrainingId.from(trainingId));
            // todo: fetch the course detail by training.courseId() by CourseService;
            return TrainingResponse.from(training);
        } catch (DomainException ex) {
            throw new ApplicationDomainException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new ApplicationInfrastructureException(ex.getMessage(), ex);
        }
    }

    public void addTraining(AddTrainingRequest addTrainingRequest) {
        if (Objects.isNull(addTrainingRequest)) {
            throw new ApplicationValidationException("training request can not be null");
        }
            trainingService.addTraining(addTrainingRequest.getTitle(), addTrainingRequest.getDescription(),
                    addTrainingRequest.getBeginTime(),
                    addTrainingRequest.getEndTime(),
                    addTrainingRequest.getPlace(), CourseId.from(addTrainingRequest.getCourseId()));

    }
}