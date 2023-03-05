package com.medicalsystem.Medical.service.Implservices;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.dao.IStockRepository;
import com.medicalsystem.Medical.service.entity.Stock;
import com.medicalsystem.Medical.service.entity.Transaction;
import com.medicalsystem.Medical.service.services.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService implements IStockService {
    IStockRepository stockRepository;
    @Autowired
    public StockService( IStockRepository stockRepository){
        this.stockRepository=stockRepository;
    }
    @Override
    public Response addStock(Stock stock) {
        var res=new Response();
        stockRepository.save(stock);
        res.make("Success insert for Stock",200,stock);
        return res;

    }

    @Override
    public Response deleteStockBId(String id) {
        Response res=new Response();
        Stock tempStock=stockRepository.findById(id).orElse(null);
        if(tempStock==null)
        {
            res.make("Failed to Delete  for Stock id is not found", 400, tempStock);
        }
        else {
            stockRepository.deleteById(id);
            res.make("Success Deletion  for Stock  ", 201, tempStock);
        }
        return res;


    }

    @Override
    public Response getStockById(String id) {
        Response res=new Response();
        Stock result = stockRepository.findById(id).orElse(null);
        if(result==null)
        {
            res.make("Failed to retrive  for Stock id is not found", 400, result);
        }
        else {
            res.make("Success Retrive  for Stock ", 201, result);
        }
        return res;
    }

    @Override
    public Response getAllStock() {
        var res=new Response();
        List<Stock>stocks=stockRepository.findAll();
        res.make("Success Retrive of Stock", 201, stocks);
        return res;
    }

    @Override
    public Response updateStock(String id, Stock stock) {
        var res=new Response();
        Stock tempStock=stockRepository.findById(id).orElse(null);
        if(tempStock==null)
            res.make("Failed to retrive  for Stock id is not found", 400, tempStock);
        else {
            tempStock.setMedicineId(stock.getMedicineId());
            tempStock.setQuantity(stock.getQuantity());
            stockRepository.save(tempStock);
            res.make("Success Update of Stock", 201, tempStock);
        }
        return res;
    }
}
