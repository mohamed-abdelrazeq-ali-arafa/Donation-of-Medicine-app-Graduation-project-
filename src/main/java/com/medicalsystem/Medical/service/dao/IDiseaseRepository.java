package com.medicalsystem.Medical.service.dao;

import com.medicalsystem.Medical.service.entity.Disease;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiseaseRepository extends MongoRepository <Disease,String> {
}
