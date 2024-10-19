package com.jackyfan.ddd.erp.valueadded.trainingcontext.southbound.port.repository;

import com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.candidate.Candidate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CandidateRepository {
    void remove(Candidate candidate);
}
