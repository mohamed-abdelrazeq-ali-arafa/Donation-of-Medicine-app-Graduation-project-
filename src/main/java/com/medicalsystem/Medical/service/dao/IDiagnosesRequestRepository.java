package com.medicalsystem.Medical.service.dao;

import com.medicalsystem.Medical.service.entity.DiagnosesRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDiagnosesRequestRepository extends MongoRepository<DiagnosesRequest,String> {
    List<DiagnosesRequest> findByUserId(String id);

}
