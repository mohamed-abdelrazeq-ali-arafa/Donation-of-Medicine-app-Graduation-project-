package com.medicalsystem.Medical.service.dao;

import com.medicalsystem.Medical.service.entity.DiagnosesResult;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiagnosesResultRepository extends MongoRepository<DiagnosesResult,String> {
}
