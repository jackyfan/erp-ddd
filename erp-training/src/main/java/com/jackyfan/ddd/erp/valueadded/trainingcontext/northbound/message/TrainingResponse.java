package com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.message;


import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.training.Training;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class TrainingResponse implements Serializable {
    private String trainingId;
    private String title;
    private String description;
    private Date beginTime;
    private Date endTime;
    private String place;

    public TrainingResponse(
            String trainingId,
            String title,
            String description,
            Date beginTime,
            Date endTime,
            String place) {
        this.trainingId = trainingId;
        this.title = title;
        this.description = description;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.place = place;
    }

    public static TrainingResponse from(Training training) {
        return new TrainingResponse(
                training.id().value(),
                training.title(),
                training.description(),
                training.beginTime(),
                training.endTime(),
                training.place());
    }

    public String getTrainingId() {
        return trainingId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public String getPlace() {
        return place;
    }
}