package com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.repository;

import com.jackyfan.ddd.core.stereotype.Port;
import com.jackyfan.ddd.core.stereotype.PortType;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.notification.MailTemplate;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.notification.TemplateType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Mapper
@Repository
@Port(PortType.Repository)
public interface MailTemplateRepository {
    Optional<MailTemplate> of(TemplateType templateType);
}
