package com.medicalsystem.Medical.service.Implservices;

import com.medicalsystem.Medical.service.dao.ITransactionRepository;
import com.medicalsystem.Medical.service.entity.Transaction;
import com.medicalsystem.Medical.service.services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void addTransaction(Transaction transaction) {
                transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransaction(String id) {
        Transaction temptransaction=transactionRepository.findById(id).orElse(null);
        if(temptransaction==null)
            throw new RuntimeException("there is no transaction with this Id");
        return temptransaction;

    }

    @Override
    public void deleteTransaction(String id) {
        Transaction temptransaction=transactionRepository.findById(id).orElse(null);
        if(temptransaction==null)
            throw new RuntimeException("There is No Transaction with this id");

        transactionRepository.deleteById(id);


    }

    @Override
    public List<Transaction> getallTransaction() {
        return transactionRepository.findAll();
    }

    @Override
    public void updateTransaction(String theid,Transaction transaction) {

        Transaction tempTransaction=transactionRepository.findById(theid).orElse(null);
        if(tempTransaction==null)
            throw new RuntimeException("There is no Transaction with this id");

        tempTransaction.setMyStatusValue(transaction.getMyStatusValue());
        tempTransaction.setCreatedAt(transaction.getCreatedAt());
        tempTransaction.setMedicineId(transaction.getMedicineId());
        tempTransaction.setCreatedBy(transaction.getCreatedBy());


        transactionRepository.save(tempTransaction);



    }

}
