package com.medicalsystem.Medical.service.Implservices;

import com.medicalsystem.Medical.service.dao.IStockRepository;
import com.medicalsystem.Medical.service.entity.Stock;
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
    public void addStock(Stock stock) {

        stockRepository.save(stock);

    }

    @Override
    public void deleteStockBId(String id) {
        Stock tempStock=stockRepository.findById(id).orElse(null);
        if(tempStock==null)
            throw new RuntimeException("There is no Transaction with this id");
        else
            stockRepository.deleteById(id);

    }

    @Override
    public Stock getStockById(String id) {
        Stock tempStock=stockRepository.findById(id).orElse(null);
        if(tempStock==null)
            throw new RuntimeException("There is no Transaction with this id");

        return tempStock;
    }

    @Override
    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    @Override
    public void updateStock(String id, Stock stock) {
        Stock tempStock=stockRepository.findById(id).orElse(null);
        if(tempStock==null)
            throw  new RuntimeException("There is no Transaction with id "+id);
        tempStock.setMedicineId(stock.getMedicineId());
        tempStock.setQuantity(stock.getQuantity());


        stockRepository.save(tempStock);

    }
}
