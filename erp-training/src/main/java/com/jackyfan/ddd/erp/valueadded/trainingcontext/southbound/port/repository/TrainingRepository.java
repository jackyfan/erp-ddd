package com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.repository;

import com.jackyfan.ddd.core.stereotype.Port;
import com.jackyfan.ddd.core.stereotype.PortType;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.training.Training;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.training.TrainingId;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Mapper
@Repository
@Port(PortType.Repository)
public interface TrainingRepository {
    Optional<Training> of(TrainingId trainingId);
    int add(Training training);
    int remove(Training training);
    boolean exists(TrainingId trainingId);
}