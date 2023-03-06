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
    public Response<Stock> addStock(@RequestBody Stock stock){
        Response<Stock> res=stockService.addStock(stock);
        return res;


    }

    @RequestMapping(value="/getstock/{theid}",method = RequestMethod.GET)
    public Response<Stock>  getStock(@PathVariable String theid){
        Response<Stock> res=stockService.getStockById(theid);
        return res;

    }
    @RequestMapping(value="/getallstock",method = RequestMethod.GET)
    public Response<List<Stock>> getAllStock(){
        Response<List<Stock>> res=stockService.getAllStock();
        return res;

    }
    @RequestMapping(value="/deletestock/{theid}",method = RequestMethod.DELETE)
    public Response<Stock> deleteStock(@PathVariable String theid){
        Response<Stock> res=stockService.deleteStockBId(theid);
        return res;
    }

    @RequestMapping(value="/updatestock/{theid}",method = RequestMethod.PUT)
    public Response<Stock> updateStock(@PathVariable String theid,@RequestBody Stock stock){

        Response<Stock> res=stockService.updateStock(theid,stock);
        return res;


    }


}
