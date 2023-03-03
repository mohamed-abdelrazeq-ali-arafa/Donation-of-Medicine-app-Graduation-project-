package com.medicalsystem.Medical.service.Implservices;

import com.medicalsystem.Medical.service.dao.IDiseaseRepository;
import com.medicalsystem.Medical.service.dao.IMedicineRepository;
import com.medicalsystem.Medical.service.entity.Disease;
import com.medicalsystem.Medical.service.entity.Medicine;
import com.medicalsystem.Medical.service.services.IDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiseaseService implements IDiseaseService {
    private IDiseaseRepository diseaseRepository;
    @Autowired
    public DiseaseService(IDiseaseRepository diseaseRepository ){
        this.diseaseRepository=diseaseRepository;
    }
    @Override
    public void addDisease(Disease disease) {

        diseaseRepository.save(disease);

    }



    @Override
    public Disease getDiseasById(String id) {
        Optional<Disease> result = diseaseRepository.findById(id);
        Disease disease=null;
        if(result.isPresent())
            disease=result.get();
        else
            throw new RuntimeException("There is no Employee with id"+id);
        return disease;
    }

    @Override
    public List<Disease> getAllDisease() {

        return diseaseRepository.findAll();


    }

    @Override
    public void deleteDiseaseById(String id) {
        Optional<Disease> result = diseaseRepository.findById(id);
        Medicine medicine=null;
        if(result.isPresent())
            diseaseRepository.deleteById(id);
        else
            throw new RuntimeException("There is no Employee with id"+id);
    }

    @Override
    public void updateDisease(String id, Disease disease) {
        Disease tempdisease=diseaseRepository.findById(id).orElse(null);
        if(tempdisease==null)
            throw new RuntimeException("There is no medicine with this id");
        tempdisease.setName(disease.getName());
        tempdisease.setDescription(disease.getDescription());
        tempdisease.setSyndromesList(disease.getSyndromesList());
        tempdisease.setAdditionalInformartion(disease.getAdditionalInformartion());

        diseaseRepository.save(tempdisease);

    }
}
