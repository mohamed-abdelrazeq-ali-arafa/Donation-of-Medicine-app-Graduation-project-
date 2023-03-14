package com.medicalsystem.Medical.service.dao;

import com.medicalsystem.Medical.service.entity.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITransactionRepository  extends MongoRepository<Transaction,String> {
    List<Transaction> findByUserId(String id);
}
