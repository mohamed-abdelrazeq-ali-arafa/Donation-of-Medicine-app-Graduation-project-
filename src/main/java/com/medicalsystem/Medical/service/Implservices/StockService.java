package com.medicalsystem.Medical.service.Implservices;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.dao.IStockRepository;
import com.medicalsystem.Medical.service.dao.IUserRepository;
import com.medicalsystem.Medical.service.entity.Stock;
import com.medicalsystem.Medical.service.entity.User;
import com.medicalsystem.Medical.service.services.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService implements IStockService {
    IStockRepository stockRepository;
    IUserRepository userRepository;
    @Autowired
    public StockService( IStockRepository stockRepository){
        this.stockRepository=stockRepository;
    }
    @Override
    public Response<Stock> addStock(Stock stock) {
        var res=new Response<Stock>();
        stockRepository.save(stock);
        res.make("Success insert for Stock",200,stock);
        res.sucess(stock);
        return res;

    }

    @Override
    public Response<Stock> deleteStockBId(String id) {
        Response res=new Response<Stock>();
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
    public Response<Stock> getStockById(String id) {
        Response res=new Response<Stock>();;
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
    public Response<List<Stock>> getAllStock() {
        var res=new Response<List<Stock>>();
        List<Stock>stocks=stockRepository.findAll();
        res.make("Success Retrive of Stock", 201, stocks);
        return res;
    }

    @Override
    public Response<Stock> updateStock(String id, Stock stock) {
        var res=new Response<Stock>();
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
