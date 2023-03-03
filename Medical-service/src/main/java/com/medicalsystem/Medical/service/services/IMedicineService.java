package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.entity.Medicine;

import java.util.List;

public interface IMedicineService {

    public void addMedicine(Medicine medicine);
    public void deleteMedicineById(String theid);
    public Medicine getMedicineById(String theid);
    public List<Medicine> getAllMedicine();
    public void updateMedicine(String id,Medicine medicine);


}
