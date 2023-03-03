package com.medicalsystem.Medical.service.restcontroller;

import com.medicalsystem.Medical.service.entity.Medicine;
import com.medicalsystem.Medical.service.entity.Stock;
import com.medicalsystem.Medical.service.services.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Stock  addStock(@RequestBody Stock stock){
        stockService.addStock(stock);
        return stock;

    }

    @RequestMapping(value="/getstock/{theid}",method = RequestMethod.GET)
    public Stock  getStock(@PathVariable String theid){
        return  stockService.getStockById(theid);

    }
    @RequestMapping(value="/getallstock",method = RequestMethod.GET)
    public List<Stock>  getAllStock(){
        return  stockService.getAllStock();

    }
    @RequestMapping(value="/deletestock/{theid}",method = RequestMethod.DELETE)
    public String deleteStock(@PathVariable String theid){
        stockService.deleteStockBId(theid);
        return "Transaction deleted with Id is  "+theid;
    }

    @RequestMapping(value="/updatestock/{theid}",method = RequestMethod.PUT)
    public void updateStock(@PathVariable String theid,@RequestBody Stock stock){

        stockService.updateStock(theid,stock);


    }


}
