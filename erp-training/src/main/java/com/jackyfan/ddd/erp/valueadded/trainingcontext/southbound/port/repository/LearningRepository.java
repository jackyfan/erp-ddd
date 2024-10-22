package com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.repository;

import com.jackyfan.ddd.core.stereotype.Port;
import com.jackyfan.ddd.core.stereotype.PortType;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.course.CourseId;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
@Port(PortType.Repository)
public interface LearningRepository {
    boolean exists(String traineeId, CourseId courseId);
}