package com.medicalsystem.Medical.service.dao;

import com.medicalsystem.Medical.service.entity.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILogRepository extends MongoRepository<Log,String> {
}
