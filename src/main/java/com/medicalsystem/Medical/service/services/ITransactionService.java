package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.Transaction;

import java.util.List;

public interface ITransactionService {
    public Response addTransaction(Transaction transaction);
    public Response getTransaction(String id);
    public Response deleteTransaction(String id);
    public Response getallTransaction();
    public Response updateTransaction(String id,Transaction transaction);

}
