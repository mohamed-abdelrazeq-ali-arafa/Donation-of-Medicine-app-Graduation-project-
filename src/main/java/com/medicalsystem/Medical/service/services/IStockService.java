package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.Stock;

import java.util.List;

public interface IStockService {

    public Response addStock(Stock stock);
    public Response deleteStockBId(String id);
    public Response getStockById (String id);
    public Response getAllStock();
    public Response updateStock(String id,Stock stock);



}
