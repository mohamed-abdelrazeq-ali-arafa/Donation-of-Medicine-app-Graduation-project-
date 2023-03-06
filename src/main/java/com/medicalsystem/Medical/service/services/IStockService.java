package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.Stock;

import java.util.List;

public interface IStockService {

    public Response<Stock> addStock(Stock stock);
    public Response<Stock> deleteStockBId(String id);
    public Response<Stock> getStockById (String id);
    public Response<List<Stock>> getAllStock();
    public Response<Stock> updateStock(String id,Stock stock);



}
