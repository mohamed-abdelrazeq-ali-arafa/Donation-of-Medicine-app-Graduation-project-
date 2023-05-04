package com.medicalsystem.Medical.service.dao;

import com.medicalsystem.Medical.service.entity.DonationRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDonationRequestRepository extends MongoRepository<DonationRequest,String> {
}
