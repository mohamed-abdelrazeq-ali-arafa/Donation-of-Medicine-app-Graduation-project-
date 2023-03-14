package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.Transaction;

import java.util.List;

public interface ITransactionService {
    public Response<Transaction> addTransaction(Transaction transaction);
    public Response<Transaction> getTransaction(String id);
    public Response<Transaction> deleteTransaction(String id);
    public Response<List<Transaction>> getallTransaction();
    public Response<Transaction> updateTransaction(String id,Transaction transaction);
    public Response<List<Transaction>> getTransactionByUserId();


}
