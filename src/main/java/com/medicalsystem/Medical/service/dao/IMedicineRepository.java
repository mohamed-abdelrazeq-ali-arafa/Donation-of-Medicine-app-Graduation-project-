package com.medicalsystem.Medical.service.dao;


import com.medicalsystem.Medical.service.entity.Medicine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicineRepository extends MongoRepository<Medicine,String> {
    Medicine findByName(String name);
}
