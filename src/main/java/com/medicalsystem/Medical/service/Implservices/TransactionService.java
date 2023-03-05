package com.medicalsystem.Medical.service.Implservices;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.dao.ITransactionRepository;
import com.medicalsystem.Medical.service.entity.Transaction;
import com.medicalsystem.Medical.service.entity.User;
import com.medicalsystem.Medical.service.services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    ITransactionRepository transactionRepository;
    @Autowired
    public TransactionService(ITransactionRepository transactionRepository) {
        this.transactionRepository=transactionRepository;
    }

    @Override
    public Response addTransaction(Transaction transaction) {
        Response res=new Response();
        transactionRepository.save(transaction);
        res.make("Success insert for Transaction",201,transaction);
        return  res;
    }

    @Override
    public Response getTransaction(String id) {
        Response res=new Response();
        Transaction result = transactionRepository.findById(id).orElse(null);
        if(result==null)
        {
            res.make("Failed to retrive  for Transaction id is not found", 400, result);
        }
        else {
            res.make("Success Retrive  for Transaction ", 201, result);
        }
        return res;

    }

    @Override
    public Response deleteTransaction(String id) {
        Response res=new Response();
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
    public Response getallTransaction() {
        var res=new Response();
        List<Transaction>transactions=transactionRepository.findAll();
        res.make("Success Retrive of Transaction", 201, transactions);
        return res;
    }

    @Override
    public Response updateTransaction(String theid,Transaction transaction) {
        var res=new Response();
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
