package com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.training;

import com.jackyfan.ddd.core.stereotype.Aggregate;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.course.CourseId;

import java.util.Date;
import java.util.UUID;

@Aggregate
public class Training {
    private TrainingId id;
    private String title;
    private String description;
    private Date beginTime;
    private Date endTime;
    private String place;
    private CourseId courseId;

    public Training(String title, String description, Date beginTime, Date endTime, String place, CourseId courseId) {
        this(TrainingId.from(UUID.randomUUID().toString()), title, description, beginTime, endTime, place, courseId);
    }

    public Training(TrainingId id, String title, String description, Date beginTime, Date endTime, String place, CourseId courseId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.place = place;
        this.courseId = courseId;
    }

    public TrainingId id() {
        return this.id;
    }

    public CourseId courseId() {
        return courseId;
    }

    public String title() {
        return this.title;
    }

    public String description() {
        return this.description;
    }

    public Date beginTime() {
        return beginTime;
    }

    public Date endTime() {
        return endTime;
    }

    public String place() {
        return place;
    }
}
