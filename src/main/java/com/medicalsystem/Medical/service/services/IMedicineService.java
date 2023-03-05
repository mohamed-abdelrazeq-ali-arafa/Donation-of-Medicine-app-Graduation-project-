package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.Medicine;

import java.util.List;

public interface IMedicineService {

    public Response addMedicine(Medicine medicine);
    public Response deleteMedicineById(String theid);
    public Response getMedicineById(String theid);
    public Response getAllMedicine();
    public Response updateMedicine(String id,Medicine medicine);


}
