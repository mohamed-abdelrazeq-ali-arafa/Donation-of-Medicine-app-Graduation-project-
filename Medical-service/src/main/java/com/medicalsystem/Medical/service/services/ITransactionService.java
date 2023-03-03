package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.entity.Transaction;

import java.util.List;

public interface ITransactionService {
    public void addTransaction(Transaction transaction);
    public Transaction getTransaction(String id);
    public void deleteTransaction(String id);
    public List<Transaction> getallTransaction();
    public void updateTransaction(String id,Transaction transaction);

}
