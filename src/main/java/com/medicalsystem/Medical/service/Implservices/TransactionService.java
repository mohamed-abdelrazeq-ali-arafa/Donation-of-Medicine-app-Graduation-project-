package com.medicalsystem.Medical.service.Implservices;


import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.dao.ITransactionRepository;
import com.medicalsystem.Medical.service.entity.Transaction;
import com.medicalsystem.Medical.service.services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    ITransactionRepository transactionRepository;
    @Autowired
    public TransactionService(ITransactionRepository transactionRepository) {
        this.transactionRepository=transactionRepository;
    }

    @Override
    public Response<Transaction> addTransaction(Transaction transaction) {
        String userId="640b6231d7d96a4f28cc05ab";
        transaction.setCreatedBy(userId);
        Response<Transaction> res=new Response<Transaction>();
        transactionRepository.save(transaction);
        res.make("Success insert for Transaction",201,transaction);
        return  res;
    }

    @Override
    public Response<Transaction> getTransaction(String id) {
        Response<Transaction> res=new Response<Transaction>();
        Transaction result = transactionRepository.findById(id).orElse(null);
        if(result==null)
        {
            res.make("Failed to reterive  for Transaction id is not found", 400, result);
        }
        else {
            res.make("Success Retreive  for Transaction ", 201, result);
        }
        return res;

    }

    @Override
    public Response<Transaction> deleteTransaction(String id) {
        Response<Transaction> res=new Response<Transaction>();
        Transaction temptransaction=transactionRepository.findById(id).orElse(null);
        if(temptransaction==null)
        {
            res.make("Failed to Delete  for Transaction id is not found", 400, temptransaction);
        }
        else {
            transactionRepository.deleteById(id);
            res.make("Success Delettion  for Transaction ", 201, temptransaction);
        }
        return res;


    }

    @Override
    public Response<List<Transaction>> getallTransaction() {
        Response<List<Transaction>> res=new Response<>();
        List<Transaction> transactions=transactionRepository.findAll();
        res.make("Success Retrive of Transaction", 201, transactions);
        return res;
    }

    @Override
    public Response<Transaction> updateTransaction(String theid,Transaction transaction) {
        var res=new Response<Transaction>();
        var tempTransaction=transactionRepository.findById(theid).orElse(null);
        if(tempTransaction==null)
            res.make("Failed updated for Transaction ", 201, null);
        else {
            tempTransaction.setMyStatusValue(transaction.getMyStatusValue());
            tempTransaction.setCreatedAt(transaction.getCreatedAt());
            tempTransaction.setMedicineId(transaction.getMedicineId());
            tempTransaction.setCreatedBy(transaction.getCreatedBy());
            transactionRepository.save(tempTransaction);
            res.make("Successfull Update for transaction",200,tempTransaction);
        }
        return res;


    }

}
