package com.medicalsystem.Medical.service.restcontroller;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.Transaction;
import com.medicalsystem.Medical.service.services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
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
    public Response<Transaction> addTransaction(@RequestBody Transaction transaction){
        Response <Transaction> res=transactionService.addTransaction(transaction);
        return res;

    }
    @RequestMapping(value="/gettransaction/{theid}",method = RequestMethod.GET)
    public Response<Transaction> getTransaction(@PathVariable String theid){

        Response <Transaction> res=transactionService.getTransaction(theid);
        return res;

    }
    @RequestMapping(value="/getalltransaction",method = RequestMethod.GET)
    public Response<List<Transaction>> getAllTransaction(){

        Response<List<Transaction>> res=transactionService.getallTransaction();
        return res;



    }

    @RequestMapping(value="/deletetransaction/{theid}",method = RequestMethod.DELETE)
    public Response<Transaction> deleteTransaction(@PathVariable String theid){

        Response<Transaction> res=transactionService.deleteTransaction(theid);
        return res;


    }


    @RequestMapping(value= "/updatetransaction/{theid}",method = RequestMethod.PUT)
    public Response<Transaction> updateTransaction(@PathVariable String theid, @RequestBody Transaction transaction){

        Response<Transaction> res=transactionService.updateTransaction(theid,transaction);
        return res;

    }

    @RequestMapping(value= "/gettransactionbyuserid",method = RequestMethod.GET)
    public Response<List<Transaction>> getTransactionByUserId(){
        Response<List<Transaction>> res=transactionService.getTransactionByUserId();
        return res;

    }



}
