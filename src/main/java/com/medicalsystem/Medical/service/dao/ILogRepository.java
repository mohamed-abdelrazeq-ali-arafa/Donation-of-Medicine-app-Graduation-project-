package com.medicalsystem.Medical.service.dao;

import com.medicalsystem.Medical.service.entity.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILogRepository extends MongoRepository<Log,String> {
    List<Log> findByUserId(String id);
}
