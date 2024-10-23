package com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.local.appservice;

import com.jackyfan.ddd.core.exception.*;
import com.jackyfan.ddd.core.stereotype.Local;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.NominationService;
import com.jackyfan.ddd.erp.valueadded.trainingcontext.northbound.message.NominatingCandidateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


import java.util.Objects;

@Service
@EnableTransactionManagement
@Local
public class NominationAppService {
    @Autowired
    private NominationService nominationService;

    @Transactional(rollbackFor = ApplicationException.class)
    public void nominate(NominatingCandidateRequest nominatingCandidateRequest) {
        if (Objects.isNull(nominatingCandidateRequest)) {
            throw new ApplicationValidationException("nomination request can not be null");
        }
        try {
            nominationService.nominate(
                    nominatingCandidateRequest.getTicketId(),
                    nominatingCandidateRequest.getTrainingId(),
                    nominatingCandidateRequest.toCandidate(),
                    nominatingCandidateRequest.toNominator());
        } catch (DomainException ex) {
            throw new ApplicationDomainException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new ApplicationInfrastructureException("Infrastructure Error", ex);
        }
    }
}