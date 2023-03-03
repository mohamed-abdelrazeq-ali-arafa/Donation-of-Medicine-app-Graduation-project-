package com.medicalsystem.Medical.service.Implservices;

import com.medicalsystem.Medical.service.dao.IMedicineRepository;
import com.medicalsystem.Medical.service.entity.Medicine;
import com.medicalsystem.Medical.service.services.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService implements IMedicineService {

    IMedicineRepository medicineRepository;

    @Autowired
    public MedicineService(IMedicineRepository medicineRepository){
        this.medicineRepository=medicineRepository;
    }

    @Override
    public void addMedicine(Medicine medicine) {
        medicineRepository.save(medicine);

    }

    @Override
    public void deleteMedicineById(String theid) {
        Medicine tempMedicine= medicineRepository.findById(theid).orElse(null);
        if(tempMedicine==null)
            throw new RuntimeException("there is no medicine with this id"+theid);
        medicineRepository.deleteById(theid);

    }

    @Override
    public Medicine getMedicineById(String theid) {

        Medicine tempMedicine= medicineRepository.findById(theid).orElse(null);
        if(tempMedicine==null)
            throw new RuntimeException("there is no medicine with this id"+theid);
      return tempMedicine;

    }

    @Override
    public List<Medicine> getAllMedicine() {
        return medicineRepository.findAll();

    }

    @Override
    public void updateMedicine(String id, Medicine medicine) {
        Medicine tempMedicine=medicineRepository.findById(id).orElse(null);
        if(tempMedicine==null)
            throw new RuntimeException("There is No medicine with this id");
        tempMedicine.setName(medicine.getName());
        tempMedicine.setAdditionalInformation(medicine.getAdditionalInformation());
        tempMedicine.setPrecautions(medicine.getPrecautions());
        tempMedicine.setDiseasesID(medicine.getDiseasesID());
        tempMedicine.setOverDos(medicine.getOverDos());
        tempMedicine.setSideEffects(medicine.getSideEffects());
        tempMedicine.setUses(medicine.getUses());
        //work is like save
        medicineRepository.save(tempMedicine);
    }
}
