package com.medicalsystem.Medical.service.dao;

import com.medicalsystem.Medical.service.entity.DiagnosesRequest;
import com.medicalsystem.Medical.service.entity.DiagnosesResult;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDiagnosesResultRepository extends MongoRepository<DiagnosesResult,String> {
    List<DiagnosesResult> findByUserId(String id);
}
