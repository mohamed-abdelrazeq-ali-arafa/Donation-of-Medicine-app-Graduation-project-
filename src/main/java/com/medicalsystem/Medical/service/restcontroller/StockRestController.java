package com.medicalsystem.Medical.service.restcontroller;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.Medicine;
import com.medicalsystem.Medical.service.entity.Stock;
import com.medicalsystem.Medical.service.services.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/stock")
public class StockRestController {
    IStockService stockService;
    @Autowired
    public StockRestController (IStockService stockService){
        this.stockService=stockService;

    }

    @RequestMapping(value="/addstock",method = RequestMethod.POST)
    public ResponseEntity addStock(@RequestBody Stock stock){
        Response res=stockService.addStock(stock);
        return ResponseEntity.status(res.getCode()).body(res.toData());


    }

    @RequestMapping(value="/getstock/{theid}",method = RequestMethod.GET)
    public ResponseEntity  getStock(@PathVariable String theid){
        Response res=stockService.getStockById(theid);
        return ResponseEntity.status(res.getCode()).body(res.toData());

    }
    @RequestMapping(value="/getallstock",method = RequestMethod.GET)
    public ResponseEntity getAllStock(){
        Response res=stockService.getAllStock();
        return ResponseEntity.status(res.getCode()).body(res.toData());

    }
    @RequestMapping(value="/deletestock/{theid}",method = RequestMethod.DELETE)
    public ResponseEntity deleteStock(@PathVariable String theid){
        Response res=stockService.deleteStockBId(theid);
        return ResponseEntity.status(res.getCode()).body(res.toData());
    }

    @RequestMapping(value="/updatestock/{theid}",method = RequestMethod.PUT)
    public ResponseEntity updateStock(@PathVariable String theid,@RequestBody Stock stock){

        Response res=stockService.updateStock(theid,stock);
        return ResponseEntity.status(res.getCode()).body(res.toData());


    }


}
