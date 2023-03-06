package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.Medicine;

import java.util.List;

public interface IMedicineService {

    public Response<Medicine> addMedicine(Medicine medicine);
    public Response<Medicine> deleteMedicineById(String theid);
    public Response<Medicine> getMedicineById(String theid);
    public Response<List<Medicine>> getAllMedicine();
    public Response<Medicine> updateMedicine(String id,Medicine medicine);


}
