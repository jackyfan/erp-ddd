package com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.repository;

import com.jackyfan.ddd.core.stereotype.Port;
import com.jackyfan.ddd.core.stereotype.PortType;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.training.TrainingId;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.validate.ValidDate;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.validate.ValidDateType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Mapper
@Repository
@Port(PortType.Repository)
public interface ValidDateRepository {
    Optional<ValidDate> of(TrainingId trainingId, ValidDateType validDateType);
    int add(ValidDate validDate);
    int remove(ValidDate validDate);
}
