package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.entity.Stock;

import java.util.List;

public interface IStockService {

    public void addStock(Stock stock);
    public void deleteStockBId(String id);
    public Stock getStockById (String id);
    public List<Stock> getAllStock();
    public void updateStock(String id,Stock stock);



}
