package com.medicalsystem.Medical.service.dao;

import com.medicalsystem.Medical.service.entity.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStockRepository  extends MongoRepository<Stock,String> {
}
