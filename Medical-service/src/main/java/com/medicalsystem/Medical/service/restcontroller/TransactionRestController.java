package com.medicalsystem.Medical.service.restcontroller;

import com.medicalsystem.Medical.service.entity.Medicine;
import com.medicalsystem.Medical.service.entity.Transaction;
import com.medicalsystem.Medical.service.entity.User;
import com.medicalsystem.Medical.service.services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionRestController {


    ITransactionService transactionService;
    @Autowired
    public TransactionRestController(ITransactionService transactionService) {
        this.transactionService=transactionService;
    }

    @RequestMapping(value="/addtransaction",method = RequestMethod.POST)
    public Transaction addTransaction(@RequestBody Transaction transaction){
        transactionService.addTransaction(transaction);
        return transaction;

    }
    @RequestMapping(value="/gettransaction/{theid}",method = RequestMethod.GET)
    public Transaction getTransaction(@PathVariable String theid){

        return  transactionService.getTransaction(theid);

    }
    @RequestMapping(value="/getalltransaction",method = RequestMethod.GET)
    public List<Transaction> getAllTransaction(){

        return transactionService.getallTransaction();


    }

    @RequestMapping(value="/deletetransaction/{theid}",method = RequestMethod.DELETE)
    public String deleteTransaction(@PathVariable String theid){

        transactionService.deleteTransaction(theid);
        return "Deleted transaction is "+theid;


    }


    @RequestMapping(value= "/updatetransaction/{theid}",method = RequestMethod.PUT)
    public Transaction updateTransaction(@PathVariable String theid, @RequestBody Transaction transaction){

        transactionService.updateTransaction(theid,transaction);
        return transaction;

    }



}
