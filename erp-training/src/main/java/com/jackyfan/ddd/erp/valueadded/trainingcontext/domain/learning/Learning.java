package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.learning;


import com.jackyfan.ddd.core.stereotype.Aggregate;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.course.CourseId;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.training.TrainingId;

@Aggregate
public class Learning {
    private String learningId;
    private CourseId courseId;
    private TrainingId trainingId;
    private String traineeId;

    public Learning(String learningId, CourseId courseId, TrainingId trainingId, String traineeId) {
        this.learningId = learningId;
        this.courseId = courseId;
        this.traineeId = traineeId;
        this.traineeId = traineeId;
    }
}