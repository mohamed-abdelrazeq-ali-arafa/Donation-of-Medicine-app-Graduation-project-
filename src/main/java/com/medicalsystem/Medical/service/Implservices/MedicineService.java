package com.medicalsystem.Medical.service.Implservices;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.dao.IMedicineRepository;
import com.medicalsystem.Medical.service.entity.Medicine;
import com.medicalsystem.Medical.service.services.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MedicineService implements IMedicineService {

    IMedicineRepository medicineRepository;

    @Autowired
    public MedicineService(IMedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Override
    public Response<Medicine> addMedicine(Medicine medicine) throws InterruptedException, IOException {
        var res = new Response();
        //create stock with each medicine addd and update quantity
        List<String> diseaseList = new ArrayList<String>();
        for (String i : diseaseList) {
            medicine.setDiseasesID(Collections.singletonList(i));
        }

        Medicine temp = medicineRepository.findByName(medicine.getName());
        System.out.println(temp);
        if (temp != null)
            res.make("There is Medicine with this name", 400, medicine);

        else {
            String workingDirectory = "/home/mohamed/PycharmProjects/medicineWebScrap";
            var process = new ProcessBuilder(
                    "python", "MedicineScraper.py",
                    medicine.getName(),
                    String.join(",", medicine.getDiseasesID())
            ).directory(new File(workingDirectory)).start();

            process.waitFor();
            temp = medicineRepository.findByName(medicine.getName());
            res.make("Success insert for Medicine", 200, temp);
        }

        return res;

    }

    @Override
    public Response<Medicine> deleteMedicineById(String theid) {
        Response res = new Response();
        Medicine tempMedicine = medicineRepository.findById(theid).orElse(null);
        if (tempMedicine == null) {
            res.make("Failed to Delete  for Medicine id is not found", 400, tempMedicine);
        } else {
            medicineRepository.deleteById(theid);
            res.make("Success Deletion  for Medicine  ", 201, tempMedicine);
        }
        return res;


    }

    @Override
    public Response<Medicine> getMedicineById(String theid) {
        Response res = new Response();
        Medicine result = medicineRepository.findById(theid).orElse(null);
        if (result == null) {
            res.make("Failed to retrive  for Medicine id is not found", 400, result);
        } else {
            res.make("Success Retrive  for Medicine ", 201, result);
        }
        return res;
    }

    @Override
    public Response<List<Medicine>> getAllMedicine() {
        var res = new Response();
        List<Medicine> medicines = medicineRepository.findAll();
        res.make("Success Retrive of Medicine", 201, medicines);
        return res;

    }

    @Override
    public Response<Medicine> updateMedicine(String id, Medicine medicine) {
        var res = new Response();
        Medicine tempMedicine = medicineRepository.findById(id).orElse(null);
        List<String> tempMedicineId = tempMedicine.getDiseasesID();
        tempMedicineId.addAll(medicine.getDiseasesID());
        if (tempMedicine == null)
            res.make("Failed to Update for Medicine id is not found", 400, tempMedicine);
        else {
            tempMedicine.setName(medicine.getName());
            tempMedicine.setAdditionalInformation(medicine.getAdditionalInformation());
            tempMedicine.setPrecautions(medicine.getPrecautions());
            tempMedicine.setDiseasesID(tempMedicineId);
            tempMedicine.setOverDos(medicine.getOverDos());
            tempMedicine.setSideEffects(medicine.getSideEffects());
            tempMedicine.setUses(medicine.getUses());
            //work is like save
            medicineRepository.save(tempMedicine);
            res.make("Success Update of Medicine", 201, tempMedicine);
        }
        return res;
    }
}
