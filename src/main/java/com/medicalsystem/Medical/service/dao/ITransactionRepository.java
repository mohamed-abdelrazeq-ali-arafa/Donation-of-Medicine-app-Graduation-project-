package com.medicalsystem.Medical.service.dao;

import com.medicalsystem.Medical.service.entity.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository  extends MongoRepository<Transaction,String> {
}
