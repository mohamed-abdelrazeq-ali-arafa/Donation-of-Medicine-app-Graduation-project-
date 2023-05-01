package com.medicalsystem.Medical.service.dao;


import com.medicalsystem.Medical.service.entity.DoctorRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDoctorRequestRepository extends MongoRepository<DoctorRequest,String> {
    DoctorRequest findByUserId(String id);
}
