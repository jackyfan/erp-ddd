package com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.message;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.course.CourseId;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.training.Training;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class AddTrainingRequest implements Serializable {
    private String title;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    private String place;
    private String courseId;

    public AddTrainingRequest(String title, String description, Date beginTime, Date endTime,
                              String place, String courseId) {
        this.title = title;
        this.description = description;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.place = place;
        this.courseId = courseId;
    }
    public Training toTraining(){
        return new Training(this.title,this.description,this.beginTime,this.endTime,this.place,
                CourseId.from(this.courseId));
    }

}
