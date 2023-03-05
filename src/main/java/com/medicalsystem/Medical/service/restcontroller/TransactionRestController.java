package com.medicalsystem.Medical.service.restcontroller;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.Medicine;
import com.medicalsystem.Medical.service.entity.Transaction;
import com.medicalsystem.Medical.service.entity.User;
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
    public ResponseEntity addTransaction(@RequestBody Transaction transaction){
        Response res=transactionService.addTransaction(transaction);
        return ResponseEntity.status(res.getCode()).body(res.toData());

    }
    @RequestMapping(value="/gettransaction/{theid}",method = RequestMethod.GET)
    public ResponseEntity getTransaction(@PathVariable String theid){

        Response res=transactionService.getTransaction(theid);
        return ResponseEntity.status(res.getCode()).body(res.toData());

    }
    @RequestMapping(value="/getalltransaction",method = RequestMethod.GET)
    public ResponseEntity getAllTransaction(){

        Response res=transactionService.getallTransaction();
        return ResponseEntity.status(res.getCode()).body(res.toData());



    }

    @RequestMapping(value="/deletetransaction/{theid}",method = RequestMethod.DELETE)
    public ResponseEntity deleteTransaction(@PathVariable String theid){

        Response res=transactionService.deleteTransaction(theid);
        return ResponseEntity.status(res.getCode()).body(res.toData());


    }


    @RequestMapping(value= "/updatetransaction/{theid}",method = RequestMethod.PUT)
    public ResponseEntity updateTransaction(@PathVariable String theid, @RequestBody Transaction transaction){

        Response res=transactionService.updateTransaction(theid,transaction);
        return ResponseEntity.status(res.getCode()).body(res.toData());

    }



}
