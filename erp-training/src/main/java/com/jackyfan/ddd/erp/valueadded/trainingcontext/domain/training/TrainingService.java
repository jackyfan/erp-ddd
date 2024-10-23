package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.training;

import com.jackyfan.ddd.core.stereotype.DomainService;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.course.CourseId;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
@DomainService
public class TrainingService {
    @Autowired
    private TrainingRepository trainingRepository;

    public Training trainingOf(TrainingId trainingId) {
        Optional<Training> optionalTraining = trainingRepository.of(trainingId);
        return optionalTraining.orElseThrow(() -> trainingNotFoundError(trainingId));
    }

    public void addTraining(String title, String description, Date beginTime, Date endTime,
                            String place, CourseId courseId) {
        Training training = new Training(title, description, beginTime, endTime,
                place, courseId);
        trainingRepository.add(training);
    }

    public boolean exists(TrainingId trainingId) {
        return trainingRepository.exists(trainingId);
    }

    private TrainingException trainingNotFoundError(TrainingId trainingId) {
        return new TrainingException(String.format("Training by id {%s} is not found.", trainingId));
    }

    public void setTrainingRepository(TrainingRepository trainingRepo) {
        trainingRepository = trainingRepo;
    }
}