package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.learning;

import com.jackyfan.ddd.core.stereotype.DomainService;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.training.Training;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.training.TrainingException;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.training.TrainingId;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.repository.LearningRepository;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@DomainService
public class LearningService {
    @Autowired
    private TrainingRepository trainingRepo;
    @Autowired
    private LearningRepository learningRepo;

    public void setTrainingRepository(TrainingRepository trainingRepo) {
        this.trainingRepo = trainingRepo;
    }

    public void setLearningRepository(LearningRepository learningRepo) {
        this.learningRepo = learningRepo;
    }

    public boolean beLearned(String traineeId, TrainingId trainingId) {
        Optional<Training> optionalTraining = trainingRepo.of(trainingId);
        if (!optionalTraining.isPresent())
            throw new TrainingException(String.format("training by id {%s} can not be found.", trainingId));

        Training training = optionalTraining.get();
        return learningRepo.exists(traineeId, training.courseId());
    }
}